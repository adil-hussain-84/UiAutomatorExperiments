# UiDevice.getLauncherPackageName() bug workaround

This Android application project demonstrates a workaround for
the [UIDevice.getLauncherPackageName()](https://developer.android.com/reference/androidx/test/uiautomator/UiDevice#getlauncherpackagename)
method reporting an incorrect package name when run in an Android 11+ emulator. The workaround is to add
a [queries](https://developer.android.com/guide/topics/manifest/queries-element) element in the app's manifest
which enables
the [UIDevice.getLauncherPackageName()](https://developer.android.com/reference/androidx/test/uiautomator/UiDevice#getlauncherpackagename)
method to return the correct package name. See
the [src/debug/AndroidManifest.xml](src/debug/AndroidManifest.xml) file in this application module for the
minimal [queries](https://developer.android.com/guide/topics/manifest/queries-element) definition that works.

The class of interest in this application module is
the [UiAutomatorTest](src/androidTest/java/com/tazkiyatech/uiautomator/app2/UiAutomatorTest.kt) test class.
This test class contains a couple of test methods which pass when run on an Android 11+ emulator purely due to
the [queries](https://developer.android.com/guide/topics/manifest/queries-element) element in
the [src/debug/AndroidManifest.xml](src/debug/AndroidManifest.xml) file.

##### Additional links

* See [here](https://issuetracker.google.com/issues/178965163) for the associated bug report in IssueTracker.
