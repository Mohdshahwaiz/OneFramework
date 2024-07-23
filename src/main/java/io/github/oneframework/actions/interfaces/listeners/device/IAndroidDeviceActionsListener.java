

package io.github.oneframework.actions.interfaces.listeners.device;

import io.appium.java_client.android.nativekey.AndroidKey;

/**
 * Handles all Android device specific events.
 *
 * @author Rahul Rana
 * @since 03-Jun-2023
 */
public interface IAndroidDeviceActionsListener extends IDeviceActionsListener {
    /**
     * Handle key press event.
     *
     * @param key Android key
     */
    default void onPressKey (final AndroidKey key) {
        // not implemented.
    }
}
