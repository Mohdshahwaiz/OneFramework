

package io.github.oneframework.actions.elements;

import static io.github.oneframework.actions.CommonActions.getDriverAttribute;
import static io.github.oneframework.actions.CommonActions.getElementAttribute;
import static io.github.oneframework.actions.CommonActions.performMobileGestures;
import static io.github.oneframework.enums.ListenerType.FINGER_ACTION;
import static io.github.oneframework.enums.Message.ELEMENT_NOT_FOUND;
import static io.github.oneframework.enums.PlatformType.WEB;
import static io.github.oneframework.manager.ParallelSession.getSession;
import static io.github.oneframework.utils.ErrorHandler.throwError;
import static java.time.Duration.ofMillis;
import static java.util.Collections.singletonList;
import static java.util.Optional.ofNullable;
import static org.apache.logging.log4j.LogManager.getLogger;

import io.github.oneframework.actions.interfaces.elements.IFingerActions;
import io.github.oneframework.actions.interfaces.listeners.elements.IFingerActionsListener;
import io.github.oneframework.builders.Locator;
import io.github.oneframework.config.ui.mobile.device.SwipeSetting;
import io.github.oneframework.enums.SwipeDirection;
import org.apache.logging.log4j.Logger;

/**
 * Handles all single finger related actions
 *
 * @author Rahul Rana
 * @since 16-Feb-2023
 */
public class FingerActions extends ElementActions implements IFingerActions {
    private static final Logger LOGGER = getLogger ();

    /**
     * Perform single finger actions on element
     *
     * @param locator Locator of the element
     *
     * @return Finger actions instance
     */
    public static IFingerActions withFinger (final Locator locator) {
        return new FingerActions (locator);
    }

    /**
     * Perform single finger actions on element
     *
     * @return Finger actions instance
     */
    public static IFingerActions withFinger () {
        return new FingerActions ();
    }

    private final IFingerActionsListener listener;
    private       SwipeSetting           swipeSetting;

    FingerActions () {
        this (null);
    }

    FingerActions (final Locator locator) {
        super (locator);
        this.listener = getSession ().getListener (FINGER_ACTION);
        if (getSession ().getPlatformType () != WEB) {
            this.swipeSetting = getSession ().getMobileSetting ()
                .getDevice ()
                .getSwipe ();
        }
    }

    @Override
    public void dragTo (final Locator destination) {
        LOGGER.traceEntry ();
        LOGGER.info ("Dragging [{}] to [{}] on Mobile devices.", this.locator.getName (), destination.getName ());
        ofNullable (this.listener).ifPresent (l -> l.onDragTo (this.locator, destination));
        final var dragSequence = getDriverAttribute (driver -> FingerGestureBuilder.init ()
            .sourceElement (this.locator)
            .pause (ofMillis (this.delaySetting.getBeforeMouseMove ()))
            .build ()
            .dragTo (destination), null);
        performMobileGestures (singletonList (dragSequence));
        LOGGER.traceExit ();
    }

    @Override
    public void swipe (final SwipeDirection direction) {
        LOGGER.traceEntry ();
        LOGGER.info ("Swiping {} on Mobile devices.", direction);
        ofNullable (this.listener).ifPresent (l -> l.onSwipe (this.locator, direction));
        final var swipeUpSequence = getDriverAttribute (driver -> FingerGestureBuilder.init ()
            .direction (direction)
            .sourceElement (this.locator)
            .build ()
            .swipe (), null);
        performMobileGestures (singletonList (swipeUpSequence));
        LOGGER.traceExit ();
    }

    @Override
    public void swipeTill (final SwipeDirection direction) {
        LOGGER.traceEntry ();
        LOGGER.info ("Swiping till the element in the [{}] direction...", direction);
        ofNullable (this.listener).ifPresent (l -> l.onSwipeTill (this.locator, direction));
        final var maxSwipe = this.swipeSetting.getMaxSwipeUntilFound ();
        var swipeCounts = 0;
        final var element = onElement (this.locator);
        final var finger = withFinger ();
        while (!element.isDisplayed () && swipeCounts++ < maxSwipe) {
            finger.swipe (direction);
        }
        if (!element.isDisplayed ()) {
            throwError (ELEMENT_NOT_FOUND, this.locator.getName (), getSession ().getPlatformType ());
        }
        LOGGER.traceExit ();
    }

    @Override
    public void tap () {
        LOGGER.traceEntry ();
        LOGGER.info ("Tapping on the element...");
        ofNullable (this.listener).ifPresent (l -> l.onTap (this.locator));
        final var sequences = getElementAttribute (element -> FingerGestureBuilder.init ()
            .sourceElement (this.locator)
            .pause (ofMillis (this.delaySetting.getBeforeTap ()))
            .build ()
            .tapOn (), this.locator, null);
        performMobileGestures (singletonList (sequences));
        LOGGER.traceExit ();
    }
}
