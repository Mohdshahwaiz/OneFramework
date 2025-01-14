

package io.github.oneframework.actions.interfaces.listeners.elements;

import io.github.oneframework.actions.interfaces.listeners.BoykaListener;
import io.github.oneframework.builders.Locator;

/**
 * Handle all element actions events.
 *
 * @author Rahul Rana
 * @since 09-Apr-2023
 */
public interface IElementActionsListener extends BoykaListener {
    /**
     * Handle clear method.
     *
     * @param locator Locator of the element.
     */
    default void onClear (final Locator locator) {
        // not implemented.
    }

    /**
     * Handle get attribute method.
     *
     * @param locator Locator of the element.
     * @param attribute Attribute name
     */
    default void onGetAttribute (final Locator locator, final String attribute) {
        // not implemented.
    }

    /**
     * Handle get style method.
     *
     * @param locator Locator of the element.
     * @param styleName Style name
     */
    default void onGetStyle (final Locator locator, final String styleName) {
        // not implemented.
    }

    /**
     * Handle get text method.
     *
     * @param locator Locator of the element.
     */
    default void onGetText (final Locator locator) {
        // not implemented.
    }

    /**
     * Handle is displayed method.
     *
     * @param locator Locator of the element.
     */
    default void onIsDisplayed (final Locator locator) {
        // not implemented.
    }

    /**
     * Handle is enabled method.
     *
     * @param locator Locator of the element.
     */
    default void onIsEnabled (final Locator locator) {
        // not implemented.
    }

    /**
     * Handle is selected method.
     *
     * @param locator Locator of the element.
     */
    default void onIsSelected (final Locator locator) {
        // not implemented.
    }

    /**
     * Handle scroll into view method.
     *
     * @param locator Locator of the element.
     */
    default void onScrollIntoView (final Locator locator) {
        // not implemented.
    }

    /**
     * Handle verify attribute method.
     *
     * @param locator Locator of the element.
     * @param attribute attribute name
     */
    default void onVerifyAttribute (final Locator locator, final String attribute) {
        // not implemented.
    }

    /**
     * Handle verify is displayed method.
     *
     * @param locator Locator of the element.
     */
    default void onVerifyIsDisplayed (final Locator locator) {
        // not implemented.
    }

    /**
     * Handle verify is enabled method.
     *
     * @param locator Locator of the element.
     */
    default void onVerifyIsEnabled (final Locator locator) {
        // not implemented.
    }

    /**
     * Handle verify is selected method.
     *
     * @param locator Locator of the element.
     */
    default void onVerifyIsSelected (final Locator locator) {
        // not implemented.
    }

    /**
     * Handle verify style method.
     *
     * @param locator Locator of the element.
     * @param styleName Style name
     */
    default void onVerifyStyle (final Locator locator, final String styleName) {
        // not implemented.
    }

    /**
     * Handle verify text method.
     *
     * @param locator Locator of the element.
     */
    default void onVerifyText (final Locator locator) {
        // not implemented.
    }
}
