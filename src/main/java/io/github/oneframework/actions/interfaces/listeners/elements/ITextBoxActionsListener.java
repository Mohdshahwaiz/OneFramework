

package io.github.oneframework.actions.interfaces.listeners.elements;

import io.github.oneframework.actions.interfaces.listeners.BoykaListener;
import io.github.oneframework.builders.Locator;

/**
 * Handle all text box action events.
 *
 * @author Rahul Rana
 * @since 09-Apr-2023
 */
public interface ITextBoxActionsListener extends BoykaListener {
    /**
     * Handle enter text method.
     *
     * @param locator Locator of the element.
     * @param text Text to enter into text box
     */
    default void onEnterText (final Locator locator, final String text) {
        // not implemented.
    }
}
