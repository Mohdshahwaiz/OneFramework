

package io.github.oneframework.actions.interfaces.drivers;

/**
 * All frames related actions
 *
 * @author Rahul Rana
 * @since 16-Feb-2023
 */
public interface IFrameActions {
    /**
     * Switch to an iFrame.
     *
     * @param frameNameOrId Name / ID of the Iframe.
     */
    void switchTo (final String frameNameOrId);

    /**
     * Switch to an iFrame.
     *
     * @param index Index of the frame.
     */
    void switchTo (int index);

    /**
     * Switch to Parent Frame.
     */
    void switchToParent ();
}
