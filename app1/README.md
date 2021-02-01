# UiDevice.getLauncherPackageName() bug

This Android application project demonstrates that the [UIDevice.getLauncherPackageName()](https://developer.android.com/reference/androidx/test/uiautomator/UiDevice#getlauncherpackagename) method reports an incorrect package name for the device's default launcher (a.k.a. home) app when run in an Android 11 emulator. Note that the method works fine when run in older versions of the Android emulator and when run on real Android devices. Note also that the problem could well be in the Android 11 emulator rather than the [UIDevice.getLauncherPackageName()](https://developer.android.com/reference/androidx/test/uiautomator/UiDevice#getlauncherpackagename) method.

The class of interest in this project is the [UiAutomatorTest](src/androidTest/java/com/tazkiyatech/uiautomator/app1/UiAutomatorTest.kt) test class. This test class contains a single test method which asserts that the device's launcher package name is not `com.android.settings`. The test fails when run on an Android 11 emulator because the Android 11 emulator reports its default launcher package as `com.android.settings`.

##### Additional links

* See [here](https://issuetracker.google.com/issues/178965163) for the associated bug report in IssueTracker.
