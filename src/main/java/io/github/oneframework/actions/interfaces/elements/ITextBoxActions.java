

package io.github.oneframework.actions.interfaces.elements;

/**
 * All text box related actions
 *
 * @author Rahul Rana
 * @since 15-Feb-2023
 */
public interface ITextBoxActions extends IClickableActions {
    /**
     * Enter text in text field.
     *
     * @param text text to enter
     */
    void enterText (final String text);
}
