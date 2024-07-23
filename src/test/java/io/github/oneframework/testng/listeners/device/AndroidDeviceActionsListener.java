

package io.github.oneframework.testng.listeners.device;

import static io.qameta.allure.Allure.step;
import static java.text.MessageFormat.format;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.github.oneframework.actions.interfaces.listeners.device.IAndroidDeviceActionsListener;

public class AndroidDeviceActionsListener implements IAndroidDeviceActionsListener {
    @Override
    public void onPressKey (final AndroidKey key) {
        step (format ("Pressing [{0}] key on the device...", key));
    }
}
