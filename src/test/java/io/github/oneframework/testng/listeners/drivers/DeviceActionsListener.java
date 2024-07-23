

package io.github.oneframework.testng.listeners.drivers;

import static io.qameta.allure.Allure.step;

import io.github.oneframework.actions.interfaces.listeners.device.IDeviceActionsListener;

public class DeviceActionsListener implements IDeviceActionsListener {
    @Override
    public void onHideKeyboard () {
        step ("Hiding the keyboard...");
    }

    @Override
    public void onIsKeyboardVisible () {
        step ("Checking if keyboard is visible...");
    }
}