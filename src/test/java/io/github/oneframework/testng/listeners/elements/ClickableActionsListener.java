

package io.github.oneframework.testng.listeners.elements;

import static io.qameta.allure.Allure.step;
import static java.text.MessageFormat.format;

import io.github.oneframework.actions.interfaces.listeners.elements.IClickableActionsListener;
import io.github.oneframework.builders.Locator;

public class ClickableActionsListener implements IClickableActionsListener {
    @Override
    public void onClick (final Locator locator) {
        step (format ("Clicking on element [{0}]...", locator.getName ()));
    }

    @Override
    public void onClickAndHold (final Locator locator) {
        step (format ("Click and Hold on element [{0}]...", locator.getName ()));
    }

    @Override
    public void onDoubleClick (final Locator locator) {
        step (format ("Double clicking on element [{0}]...", locator.getName ()));
    }

    @Override
    public void onDragTo (final Locator source, final Locator destination) {
        step (format ("Dragging element [{0}] to element [{1}]...", source.getName (), destination.getName ()));
    }

    @Override
    public void onHover (final Locator locator) {
        step (format ("Hovering on element [{0}]...", locator.getName ()));
    }

    @Override
    public void onRightClick (final Locator locator) {
        step (format ("Right Clicking on element [{0}]...", locator.getName ()));
    }

    @Override
    public void onSubmit (final Locator locator) {
        step (format ("Submitting on element [{0}]...", locator.getName ()));
    }
}
