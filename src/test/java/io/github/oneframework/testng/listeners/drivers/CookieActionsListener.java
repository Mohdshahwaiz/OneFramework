

package io.github.oneframework.testng.listeners.drivers;

import static io.qameta.allure.Allure.step;
import static java.text.MessageFormat.format;

import io.github.oneframework.actions.interfaces.listeners.drivers.ICookieActionsListener;

public class CookieActionsListener implements ICookieActionsListener {
    @Override
    public void onCookie (final String name) {
        step (format ("Getting Cookie for name [{0}]...", name));
    }

    @Override
    public void onCookies () {
        step ("Getting all the cookies...");
    }

    @Override
    public void onDelete (final String name) {
        step (format ("Deleting cookie of name [{0}]...", name));
    }

    @Override
    public void onDeleteAll () {
        step ("Deleting all the cookies...");
    }
}
