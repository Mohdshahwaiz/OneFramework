

package io.github.oneframework.actions.interfaces.listeners.elements;

import io.github.oneframework.actions.interfaces.listeners.BoykaListener;
import io.github.oneframework.builders.Locator;
import io.github.oneframework.enums.SwipeDirection;

/**
 * Handle all single finger actions event.
 *
 * @author Rahul Rana
 * @since 09-Apr-2023
 */
public interface IFingerActionsListener extends BoykaListener {
    /**
     * Handle drag to method.
     *
     * @param source Source element to drag.
     * @param destination target element to drop to
     */
    default void onDragTo (final Locator source, final Locator destination) {
        // not implemented.
    }

    /**
     * Handle swipe method.
     *
     * @param locator Locator of the element.
     * @param direction Swipe direction
     */
    default void onSwipe (final Locator locator, final SwipeDirection direction) {
        // not implemented.
    }

    /**
     * Handle swipe till method.
     *
     * @param locator Locator of the element.
     * @param direction swipe direction
     */
    default void onSwipeTill (final Locator locator, final SwipeDirection direction) {
        // not implemented.
    }

    /**
     * Handle tap method.
     *
     * @param locator Locator of the element.
     */
    default void onTap (final Locator locator) {
        // not implemented.
    }

    /**
     * Handle Tap and Hold.
     *
     * @param locator Locator of the element.
     */
    default void onTapAndHold (final Locator locator) {
        // not implemented.
    }
}
