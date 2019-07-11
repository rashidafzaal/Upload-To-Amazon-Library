# Upload-To-Amazon-Library
This library lets you upload the image on Amazon Server using PreSignedUrl with two lines of Code.

## Gradle Setup:
Add it in your root build.gradle at the end of repositories:
```java
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
Add the dependency:
```android
dependencies {
	implementation 'com.github.rashidafzaal:Upload-To-Amazon-Library:1.0'
}
```
## Do in Your Activity:

1. Implement the interface <b>AmazonResponse*</b>
2. Override the Method <b>processFinish(String responseCode)</b>
3. Do this code on Button click/anywhere you want

```android
UploadOnAmazon upload = new UploadOnAmazon(bitmap, "", 65);
upload.res = this;
upload.execute();

//1. pass bitmap
//2. pass PreSignedUrl
//3. pass quality (0 means the lowest, 100 means the highest)
```

4. You will get response Code in method <b>processFinish(String responseCode)</b>, once uploading finish.
