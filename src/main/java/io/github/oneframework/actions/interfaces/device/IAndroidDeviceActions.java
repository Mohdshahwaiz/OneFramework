

package io.github.oneframework.actions.interfaces.device;

import io.appium.java_client.android.nativekey.AndroidKey;

/**
 * Handles all Android device specific actions.
 *
 * @author Rahul Rana
 * @since 03-Jun-2023
 */
public interface IAndroidDeviceActions extends IDeviceActions {
    /**
     * Press Android key on the device.
     *
     * @param key Android key
     */
    void pressKey (AndroidKey key);
}
