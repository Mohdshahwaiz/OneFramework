

package io.github.oneframework.actions.interfaces.elements;

/**
 * All Clickable actions
 *
 * @author Rahul Rana
 * @since 15-Feb-2023
 */
public interface IClickableActions extends IFingersActions {
    /**
     * Click on element
     */
    void click ();

    /**
     * LongPress on element
     */
    void clickAndHold ();

    /**
     * DoubleClick on element
     */
    void doubleClick ();

    /**
     * Hover on element
     */
    void hover ();

    /**
     * RightClick on element
     */
    void rightClick ();

    /**
     * Submit the element.
     */
    void submit ();
}
