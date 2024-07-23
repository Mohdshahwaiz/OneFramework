

package io.github.oneframework.testng.listeners.elements;

import static io.qameta.allure.Allure.step;
import static java.text.MessageFormat.format;

import io.github.oneframework.actions.interfaces.listeners.elements.IFingerActionsListener;
import io.github.oneframework.builders.Locator;
import io.github.oneframework.enums.SwipeDirection;

public class FingerActionsListener implements IFingerActionsListener {
    @Override
    public void onDragTo (final Locator source, final Locator destination) {
        step (format ("Dragging element [{0}] to element [{1}]...", source.getName (), destination.getName ()));
    }

    @Override
    public void onSwipe (final Locator locator, final SwipeDirection direction) {
        step (format ("Swiping on element [{0}] in [{1}] direction...", locator, direction.name ()));
    }

    @Override
    public void onSwipeTill (final Locator locator, final SwipeDirection direction) {
        step (format ("Swiping till the element [{0}] is visible in [{1}] direction...", locator.getName (),
            direction.name ()));
    }

    @Override
    public void onTap (final Locator locator) {
        step (format ("Tapping on element [{0}]...", locator.getName ()));
    }
}
