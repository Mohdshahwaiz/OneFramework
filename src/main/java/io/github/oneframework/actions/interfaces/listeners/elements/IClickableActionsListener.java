

package io.github.oneframework.actions.interfaces.listeners.elements;

import io.github.oneframework.actions.interfaces.listeners.BoykaListener;
import io.github.oneframework.builders.Locator;

/**
 * Handle all clickable actions events.
 *
 * @author Rahul Rana
 * @since 09-Apr-2023
 */
public interface IClickableActionsListener extends BoykaListener {
    /**
     * Handle click method
     *
     * @param locator Locator of the element.
     */
    default void onClick (final Locator locator) {
        // not implemented.
    }

    /**
     * Handle click and hold method.
     *
     * @param locator Locator of the element.
     */
    default void onClickAndHold (final Locator locator) {
        // not implemented.
    }

    /**
     * Handle double click method.
     *
     * @param locator Locator of the element.
     */
    default void onDoubleClick (final Locator locator) {
        // not implemented.
    }

    /**
     * Handle drag to the target element.
     *
     * @param source source element.
     * @param destination target element
     */
    default void onDragTo (final Locator source, final Locator destination) {
        // not implemented.
    }

    /**
     * Handle hover method.
     *
     * @param locator Locator of the element.
     */
    default void onHover (final Locator locator) {
        // not implemented.
    }

    /**
     * Handle right click method.
     *
     * @param locator Locator of the element.
     */
    default void onRightClick (final Locator locator) {
        // not implemented.
    }

    /**
     * Handle submit method.
     *
     * @param locator Locator of the element.
     */
    default void onSubmit (final Locator locator) {
        // not implemented.
    }
}
