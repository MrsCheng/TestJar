
提供一些工具类的集合 来源自网络

Step 1. Add it in your root build.gradle at the end of repositories:
	
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
Step 2. Add the dependency

	dependencies {
	         compile 'com.github.MrsCheng:TestJar:2.1'
	}

Jar下载地址为：https://github.com/MrsCheng/TestJar/releases/download/2.1/TestJar_V2.1.jar


1.ACacheUtils          数据保存工具 提供需要保存时间等功能：
2.ActivityManager      Activity管理工具：
3.AES256Util           AES256加密工具：
4.BitmapUtils          图片压缩工具：
5.DataCleanManagerUtil 缓存管理工具：
6.DensityUtils         dp sp px 转换工具：
7.DeviceUtils          设备信息工具：
8.KeyBoardUtils        软键盘管理工具：
9.MD5Utils             MD5加密工具：
10.NetUtils            网络管理工具：
11.ScreenUtils         设备屏幕宽高工具：
12.SPUtils             数据保存工具：
13.TimeUtils           时间管理工具：
14.ToastUtils          吐司管理工具：