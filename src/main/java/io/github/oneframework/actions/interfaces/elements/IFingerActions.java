

package io.github.oneframework.actions.interfaces.elements;

import io.github.oneframework.builders.Locator;
import io.github.oneframework.enums.SwipeDirection;

/**
 * All single finger actions
 *
 * @author Rahul Rana
 * @since 15-Feb-2023
 */
public interface IFingerActions extends IElementActions {
    /**
     * Drag one element to another element.
     *
     * @param destination Target element
     */
    void dragTo (final Locator destination);

    /**
     * Swipe on the Mobile screen starting from center of the screen to the direction mentioned
     *
     * @param direction Direction to swipe in.
     */
    void swipe (SwipeDirection direction);

    /**
     * Swipe until element is displayed in the mentioned direction.
     *
     * @param direction Direction to swipe in
     */
    void swipeTill (SwipeDirection direction);

    /**
     * Taps on an element.
     */
    void tap ();
}
