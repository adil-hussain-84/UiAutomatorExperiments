package com.tazkiyatech.uiautomator.app1

import android.os.Build
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
     * This test method passes when run in an Android 10.0 emulator because the Android 10.0 emulator
     * reports its default launcher package as "com.google.android.apps.nexuslauncher"
     * but fails when run in an Android 11.0 emulator because the Android 11.0 emulator
     * reports its default launcher package as "com.android.settings".
     */
    @Test
    fun launcherPackageName() {
        assertNotEquals("com.android.settings", uiDevice.launcherPackageName)
    }

    /**
     * This test method passes when run in an Android 10.0 emulator because the Android 10.0 emulator
     * correctly reports its default launcher package as "com.google.android.apps.nexuslauncher"
     * but fails when run in an Android 11.0 emulator because the Android 11.0 emulator
     * incorrectly reports its default launcher package as "com.android.settings".
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
     * This test method passes when run in both the Android 10.0 and Android 11.0 emulator
     * because it waits on a hard-coded package name of "com.google.android.apps.nexuslauncher"
     * when run in the Android 11.0 emulator
     * instead of trusting what the emulator reports as its launcher package.
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
     * because that method returns `"com.android.settings"` (incorrectly) when run in an Android 11 emulator device.
     *
     * @return the package name of the device's default launcher (a.k.a. home) app.
     */
    private fun getHackedLauncherPackageName(): String? {
        return if (Build.VERSION.SDK_INT == Build.VERSION_CODES.R && uiDevice.productName.startsWith("sdk_gphone_")) {
            "com.google.android.apps.nexuslauncher"
        } else {
            uiDevice.launcherPackageName
        }
    }
}