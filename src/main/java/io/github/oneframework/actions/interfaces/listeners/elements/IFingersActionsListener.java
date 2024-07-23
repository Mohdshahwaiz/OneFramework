

package io.github.oneframework.actions.interfaces.listeners.elements;

import io.github.oneframework.actions.interfaces.listeners.BoykaListener;
import io.github.oneframework.builders.Locator;

/**
 * Handles all multi-fingers actions events.
 *
 * @author Rahul Rana
 * @since 09-Apr-2023
 */
public interface IFingersActionsListener extends BoykaListener {
    /**
     * Handle zoom in method.
     *
     * @param locator Locator of the element.
     */
    default void onZoomIn (final Locator locator) {
        // not implemented.
    }

    /**
     * Handle zoom out method.
     *
     * @param locator Locator of the element.
     */
    default void onZoomOut (final Locator locator) {
        // not implemented.
    }
}
