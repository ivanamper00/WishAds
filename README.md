# WishAds
Wishland Advertisement implementation


Step 1. Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.ivanamper00:WishAds:1.1.0'
	}
  
Step 3. Extends AdsActivity to your target Activity and implement the methods


![image](https://user-images.githubusercontent.com/57562156/184313040-bfbeb898-ba92-4254-bd10-ff164f005143.png)


*Note : You can set the parameter of the AdsActivity to true or false for testing purposes

You can also change the Domain access on AndroidManifest.xml

<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    package="com.wishland.myads">
    
    <application
        ...>

        <meta-data
            android:name="appDomain"
            android:value="INPUT_YOUR_DOMAIN_HERE"
            tools:replace="android:value"/>
    </application>

</manifest>
