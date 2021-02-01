package com.tazkiyatech.uiautomator.app1

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import org.junit.Assert.assertNotEquals
import org.junit.Test

class UiAutomatorTest {

    private val uiDevice: UiDevice
        get() = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    @Test
    fun launcherPackageName() {
        assertNotEquals("com.android.settings", uiDevice.launcherPackageName)
    }
}