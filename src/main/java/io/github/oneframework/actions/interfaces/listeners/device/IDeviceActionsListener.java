

package io.github.oneframework.actions.interfaces.listeners.device;

import io.github.oneframework.actions.interfaces.listeners.BoykaListener;

/**
 * Handles all the common device specific events.
 *
 * @author Rahul Rana
 * @since 03-Jun-2023
 */
public interface IDeviceActionsListener extends BoykaListener {
    /**
     * Handle hide keyboard event.
     */
    default void onHideKeyboard () {
        // not implemented.
    }

    /**
     * Handle is keyboard visible event.
     */
    default void onIsKeyboardVisible () {
        // not implemented.
    }

    /**
     * Handle start recording event.
     */
    default void onStartRecording () {
        // not implemented.
    }

    /**
     * Handle stop recording event.
     */
    default void onStopRecording () {
        // not implemented.
    }
}
