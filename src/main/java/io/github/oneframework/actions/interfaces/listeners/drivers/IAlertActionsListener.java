

package io.github.oneframework.actions.interfaces.listeners.drivers;

import io.github.oneframework.actions.interfaces.listeners.BoykaListener;

/**
 * Listener to handle Alert actions events.
 *
 * @author Rahul Rana
 * @since 09-Apr-2023
 */
public interface IAlertActionsListener extends BoykaListener {
    /**
     * Handle accept alert.
     */
    default void onAccept () {
        // not implemented.
    }

    /**
     * Handle Accept method for prompt alert.
     *
     * @param text Text to be entered in the Alert prompt
     */
    default void onAccept (final String text) {
        // not implemented.
    }

    /**
     * Handle dismiss alert.
     */
    default void onDismiss () {
        // not implemented.
    }

    /**
     * Handle verify accept alert method with prompt text.
     *
     * @param text Text to be entered in the Alert prompt
     */
    default void onVerifyAccept (final String text) {
        // not implemented.
    }

    /**
     * Handle verify accept alert method.
     */
    default void onVerifyAccept () {
        // not implemented.
    }

    /**
     * Handle dismiss alert method.
     */
    default void onVerifyDismiss () {
        // not implemented.
    }
}
