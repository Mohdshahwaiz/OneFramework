

package io.github.oneframework.testng.ui.saucedemo.pages;

import static io.appium.java_client.AppiumBy.accessibilityId;
import static org.openqa.selenium.By.id;

import io.github.oneframework.builders.Locator;
import lombok.Getter;

/**
 * Login page object for Sauce demo application.
 *
 * @author Rahul Rana
 * @since 24-Feb-2022
 */
@Getter
public class LoginPage {
    private static final LoginPage LOGIN_PAGE = new LoginPage ();

    /**
     * Login page object.
     *
     * @return {@link LoginPage}
     */
    public static LoginPage loginPage () {
        return LOGIN_PAGE;
    }

    private final Locator loginButton = Locator.buildLocator ()
        .web (id ("login-button"))
        .android (accessibilityId ("test-LOGIN"))
        .ios (accessibilityId ("test-LOGIN"))
        .name ("Login Button")
        .build ();
    private final Locator password    = Locator.buildLocator ()
        .web (id ("password"))
        .android (accessibilityId ("test-Password"))
        .ios (accessibilityId ("test-Password"))
        .name ("Password")
        .build ();
    private final Locator username    = Locator.buildLocator ()
        .web (id ("user-name"))
        .android (accessibilityId ("test-Username"))
        .ios (accessibilityId ("test-Username"))
        .name ("User Name")
        .build ();

    private LoginPage () {
        // Avoid explicit class initialisation.
    }
}
