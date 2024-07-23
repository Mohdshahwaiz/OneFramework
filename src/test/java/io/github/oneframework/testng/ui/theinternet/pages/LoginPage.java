

package io.github.oneframework.testng.ui.theinternet.pages;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.partialLinkText;
import static org.openqa.selenium.By.tagName;

import io.github.oneframework.builders.Locator;
import lombok.Getter;

/**
 * Login page object
 *
 * @author Rahul Rana
 * @since 16-Sept-2023
 */
@Getter
public class LoginPage {
    private static final LoginPage LOGIN_PAGE = new LoginPage ();

    /**
     * Login page instance.
     *
     * @return {@link LoginPage}
     */
    public static LoginPage loginPage () {
        return LOGIN_PAGE;
    }

    private final Locator login    = Locator.buildLocator ()
        .name ("Login Button")
        .web (tagName ("button"))
        .build ();
    private final Locator logout   = Locator.buildLocator ()
        .name ("Logout Button")
        .web (partialLinkText ("Logout"))
        .build ();
    private final Locator message  = Locator.buildLocator ()
        .name ("Message Label")
        .web (id ("flash"))
        .build ();
    private final Locator password = Locator.buildLocator ()
        .name ("Password")
        .web (id ("password"))
        .build ();
    private final Locator userName = Locator.buildLocator ()
        .name ("User Name")
        .web (id ("username"))
        .build ();

    private LoginPage () {
        // Utility Class.
    }
}
