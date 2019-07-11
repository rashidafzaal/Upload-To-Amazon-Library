# Upload-To-Amazon-Library
This library lets you upload the image on Amazon Server using PreSignedUrl with two lines of Code.

## Gradle Setup:
Add it in your root build.gradle at the end of repositories:
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
Add the dependency:
```
dependencies {
	implementation 'com.github.rashidafzaal:Upload-To-Amazon-Library:1.0'
}
```
## Do in Your Activity:

1. Implement the interface *AmazonResponse* 
2. Override the Method *processFinish(String responseCode)*
