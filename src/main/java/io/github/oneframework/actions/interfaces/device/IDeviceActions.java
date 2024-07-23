

package io.github.oneframework.actions.interfaces.device;

/**
 * Handle all device specific actions.
 *
 * @author Rahul Rana
 * @since 31-May-2023
 */
public interface IDeviceActions {
    /**
     * Hides the keyboard if visible.
     */
    void hideKeyboard ();

    /**
     * Gets the keyboard state whether it is visible or not.
     *
     * @return true, if visible.
     */
    boolean isKeyboardVisible ();

    /**
     * Starts video recording.
     */
    void startRecording ();

    /**
     * Stops video recording.
     */
    void stopRecording ();
}
