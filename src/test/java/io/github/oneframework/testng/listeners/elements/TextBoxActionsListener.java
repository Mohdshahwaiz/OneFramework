

package io.github.oneframework.testng.listeners.elements;

import static io.qameta.allure.Allure.step;
import static java.text.MessageFormat.format;

import io.github.oneframework.actions.interfaces.listeners.elements.ITextBoxActionsListener;
import io.github.oneframework.builders.Locator;

public class TextBoxActionsListener implements ITextBoxActionsListener {
    @Override
    public void onEnterText (final Locator locator, final String text) {
        step (format ("Entering text [{0}] in element [{1}]...", text, locator.getName ()));
    }
}
