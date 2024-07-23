

package io.github.oneframework.actions.interfaces.listeners.drivers;

import io.github.oneframework.actions.interfaces.listeners.BoykaListener;

/**
 * Handle Context actions related events.
 *
 * @author Rahul Rana
 * @since 09-Apr-2023
 */
public interface IContextActionsListener extends BoykaListener {
    /**
     * Handle contexts method.
     */
    default void onContexts () {
        // not implemented.
    }

    /**
     * Handle current context method.
     */
    default void onCurrentContext () {
        // not implemented.
    }

    /**
     * Handle switch to native view method.
     */
    default void onSwitchToNative () {
        // not implemented.
    }

    /**
     * Handle switch to web view method.
     *
     * @param name Name of WebView
     */
    default void onSwitchToWebView (final String name) {
        // not implemented.
    }

    /**
     * Handle switch to web view method.
     */
    default void onSwitchToWebView () {
        // not implemented.
    }
}
