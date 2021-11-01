package com.tazkiyatech.uiautomator.app2

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
     * This test method passes when run in an Android 11+ emulator
     * because the `queries` element defined in the `debug/AndroidManifest.xml` file
     * allows the emulator to correctly report its launcher package as `"com.google.android.apps.nexuslauncher"`
     * and not `"com.android.settings"`.
     */
    @Test
    fun launcherPackageName() {
        assertNotEquals("com.android.settings", uiDevice.launcherPackageName)
    }

    /**
     * This test method passes when run in an Android 11+ emulator
     * because the `queries` element defined in the `debug/AndroidManifest.xml` file
     * allows the emulator to correctly report its launcher package as `"com.google.android.apps.nexuslauncher"`
     * and not `"com.android.settings"`.
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
}