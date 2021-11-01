# UiDevice.getLauncherPackageName() bug description

This Android application project demonstrates that
the [UIDevice.getLauncherPackageName()](https://developer.android.com/reference/androidx/test/uiautomator/UiDevice#getlauncherpackagename)
method reports an incorrect package name when run in an Android 11+ emulator. It
reports `com.android.settings` as the default launcher instead of the actual launcher. Note that the method
works fine when run in older versions of the Android emulator and when run on real Android devices.

The class of interest in this application module is
the [UiAutomatorTest](src/androidTest/java/com/tazkiyatech/uiautomator/app1/UiAutomatorTest.kt) test class.
This test class contains a number of test methods which demonstrate the problem.

##### Additional links

* See [here](https://issuetracker.google.com/issues/178965163) for the associated bug report in IssueTracker.
