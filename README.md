紫晶骷髅
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