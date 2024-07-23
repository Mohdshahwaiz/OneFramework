

package io.github.oneframework.actions.interfaces.elements;

/**
 * All multi-finger related actions.
 *
 * @author Rahul Rana
 * @since 15-Feb-2023
 */
public interface IFingersActions extends IFingerActions {
    /**
     * Zoom in on the screen.
     */
    void zoomIn ();

    /**
     * Zoom out of the screen.
     */
    void zoomOut ();
}
