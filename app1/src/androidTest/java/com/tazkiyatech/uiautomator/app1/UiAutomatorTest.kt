package com.tazkiyatech.uiautomator.app1

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import org.junit.Assert.assertNotEquals
import org.junit.Assert.fail
import org.junit.Test

class UiAutomatorTest {

    private val uiDevice: UiDevice
        get() = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    /**
     * This test method passes when run in an Android 10 or older device because the device
     * reports its default launcher package correctly;
     * it fails when run in an Android 11+ device because the device
     * reports its default launcher package as `"com.android.settings"`.
     */
    @Test
    fun launcherPackageName() {
        assertNotEquals("com.android.settings", uiDevice.launcherPackageName)
    }

    /**
     * This test method passes when run in an Android 10 or older device because the device
     * reports its default launcher package correctly;
     * it fails when run in an Android 11+ device because the device
     * reports its default launcher package as `"com.android.settings"`.
     */
    @Test
    fun waitOnLauncher() {
        // When.
        uiDevice.pressHome()

        // Then.
        val hasObject = uiDevice.wait(Until.hasObject(By.pkg(uiDevice.launcherPackageName)), 10_000L)

        if (!hasObject) {
            fail("Waited on the launcher but it did not show")
        }
    }

    /**
     * This test method passes when run in an Android 11+ device
     * which has the [Pixel Launcher](https://play.google.com/store/apps/details?id=com.google.android.apps.nexuslauncher)
     * app set as its default launcher app (e.g. Pixel devices and Emulator devices).
     * It passes because it waits on a hard-coded package name of `"com.google.android.apps.nexuslauncher"`
     * when run in an Android 11+ device instead of trusting what the device reports as its launcher package.
     */
    @Test
    fun waitOnLauncher_with_hacked_launcher_package_name() {
        // When.
        uiDevice.pressHome()

        // Then.
        val hasObject = uiDevice.wait(Until.hasObject(By.pkg(getHackedLauncherPackageName())), 10_000L)

        if (!hasObject) {
            fail("Waited on the launcher but it did not show")
        }
    }

    /**
     * This method exists as an alternative to the [UiDevice.getLauncherPackageName] method
     * because that method returns `"com.android.settings"` when run in Android 11+ devices.
     *
     * @return the package name of the device's default launcher (a.k.a. home) app.
     */
    private fun getHackedLauncherPackageName(): String? {
        val launcherPackageName = uiDevice.launcherPackageName

        return if (launcherPackageName.equals("com.android.settings")) {
            "com.google.android.apps.nexuslauncher"
        } else {
            launcherPackageName
        }
    }
}