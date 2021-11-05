# UiDevice.getLauncherPackageName() bug description

This Android application project demonstrates that
the [UIDevice.getLauncherPackageName()](https://developer.android.com/reference/androidx/test/uiautomator/UiDevice#getlauncherpackagename)
method reports an incorrect package name when run in Android 11+ devices. It reports `com.android.settings` as
the default launcher instead of the actual launcher. The problem seems to be due
to [package visibility changes in Android 11](https://developer.android.com/about/versions/11/privacy/package-visibility)
.

The class of interest in this application module is
the [UiAutomatorTest](src/androidTest/java/com/tazkiyatech/uiautomator/app1/UiAutomatorTest.kt) test class.
This test class contains a number of test methods which demonstrate the problem.

#### Additional links

* See [here](https://github.com/android/android-test/issues/1183) for an issue which was raised in
  the [android-test](https://github.com/android/android-test) GitHub repo about this problem.
