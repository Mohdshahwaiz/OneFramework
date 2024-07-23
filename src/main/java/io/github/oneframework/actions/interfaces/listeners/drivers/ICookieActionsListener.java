

package io.github.oneframework.actions.interfaces.listeners.drivers;

import io.github.oneframework.actions.interfaces.listeners.BoykaListener;

/**
 * Handle all cookies action events.
 *
 * @author Rahul Rana
 * @since 09-Apr-2023
 */
public interface ICookieActionsListener extends BoykaListener {
    /**
     * Handle cookie method.
     *
     * @param name Cookie name
     */
    default void onCookie (final String name) {
        // not implemented.
    }

    /**
     * Handle cookies method.
     */
    default void onCookies () {
        // not implemented.
    }

    /**
     * Handle delete cookie method.
     *
     * @param name Cookie name
     */
    default void onDelete (final String name) {
        // not implemented.
    }

    /**
     * Handle delete all method.
     */
    default void onDeleteAll () {
        // not implemented.
    }
}
