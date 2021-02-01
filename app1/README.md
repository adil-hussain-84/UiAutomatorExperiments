# UiDevice.getLauncherPackageName()` bug

This Android application project demonstrates that the [UIDevice.getLauncherPackageName()](https://developer.android.com/reference/androidx/test/uiautomator/UiDevice#getlauncherpackagename) method reports an incorrect package name for the device's default launcher (a.k.a. home) app when run in an Android 11 emulator. Note that the method works fine when run in older versions of the Android emulator and when run on real Android devices.

The class of interest in this project is the [UiAutomatorTest](src/androidTest/java/com/tazkiyatech/uiautomator/app1/UiAutomatorTest.kt) test class. The test method in this class will fail when run on an Android 11 emulator because the Android 11 emulator reports the `"com.android.settings"` package as the package name of the device's default launcher app.
