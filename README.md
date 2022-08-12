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
