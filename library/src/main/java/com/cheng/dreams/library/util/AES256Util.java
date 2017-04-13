package com.cheng.dreams.library.util;


import com.cheng.dreams.library.util.encoder.BASE64Decoder;
import com.cheng.dreams.library.util.encoder.BASE64Encoder;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES256加密解密
 * 
 * 注: 一般服务器返回的加密后数据都要Base64编码(否则容易丢失数据，抛出异常：javax.crypto.
 * IllegalBlockSizeException: last block incomplete in decryption).
 * 所以AES256加密后再用Base64编码。
 * 
 * @author tongpuxin
 */
public class AES256Util {

	private static final String KEY_ALGORITHM = "AES";

	private static final String CIPHER_ALGORITHM = "AES";

	private static final String CHARSET = "UTF8";

	private static String KEY = "";

	static {
// TODO: 2017/2/8 替换成需要的key
		KEY = "1111111111";
//		if (StringUtils.isNotBlank(k)) {
//			KEY = k;
//		} else {
//			KEY = MD5.toMD5(RandomUtil.generateString(8));
//		}
	}

	private static byte[] decrypt(byte[] src, byte[] key) throws Exception {
		Key k = toKey(key);
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, k);
		return cipher.doFinal(src);
	}

	/**
	 * 解密
	 * 
	 * @param data
	 *            待解密的字符串
	 * @return 解密后的字符串
	 */
	public static String decrypt(String data) {
		try {
			byte[] key = KEY.getBytes(CHARSET);
			byte[] src = new BASE64Decoder().decodeBuffer(data);
			return new String(decrypt(src, key), CHARSET);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static Key toKey(byte[] key) throws Exception {
		SecretKey secretKey = new SecretKeySpec(key, KEY_ALGORITHM);
		return secretKey;
	}

	private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		Key k = toKey(key);
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, k);
		return cipher.doFinal(data);
	}

	/**
	 * 加密
	 * 
	 * @param data
	 *            待加密的字符串
	 * @return 加密后的字符串
	 */
	public static String encrypt(String data) {
		return addSecureToStr(data);
	}

	private static String addSecureToStr(String str) {
		byte[] data = null;
		byte[] key = new byte[0];
		try {
			key = KEY.getBytes(CHARSET);
			data = AES256Util.encrypt(str.getBytes(CHARSET), key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new BASE64Encoder().encode(data);
	}

	/**
	 * md5 加密
	 * @param string
	 * @return
     */
	public static String md5(String string) {
		byte[] hash;
		try {
			hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Huh, MD5 should be supported?", e);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Huh, UTF-8 should be supported?", e);
		}

		StringBuilder hex = new StringBuilder(hash.length * 2);
		for (byte b : hash) {
			if ((b & 0xFF) < 0x10) hex.append("0");
			hex.append(Integer.toHexString(b & 0xFF));
		}
		return hex.toString();
	}
	public static void main(String[] args) {
		String s = encrypt("UoKyU9xq6N8J16tjfTQ4SF2BVFYLnRpEdmP2+q930VMMIexAqMBPVQTXUmqgrZuC");
		System.out.println(s);
		System.out.println(decrypt("UoKyU9xq6N8J16tjfTQ4SF2BVFYLnRpEdmP2+q930VMMIexAqMBPVQTXUmqgrZuC"));
	}
}