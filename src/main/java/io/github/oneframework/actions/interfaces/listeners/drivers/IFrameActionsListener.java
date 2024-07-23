

package io.github.oneframework.actions.interfaces.listeners.drivers;

import io.github.oneframework.actions.interfaces.listeners.BoykaListener;

/**
 * Handle frame actions listener.
 *
 * @author Rahul Rana
 * @since 09-Apr-2023
 */
public interface IFrameActionsListener extends BoykaListener {
    /**
     * Handle switch to method.
     *
     * @param frameNameOrId Name or ID of the IFrame
     */
    default void onSwitchTo (final String frameNameOrId) {
        // not implemented.
    }

    /**
     * Handle switch to method.
     *
     * @param index index of the IFrame
     */
    default void onSwitchTo (final int index) {
        // not implemented.
    }

    /**
     * Handle switch to parent method.
     */
    default void onSwitchToParent () {
        // not implemented.
    }
}
