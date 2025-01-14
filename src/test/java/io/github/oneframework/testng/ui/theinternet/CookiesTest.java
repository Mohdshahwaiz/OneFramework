

package io.github.oneframework.testng.ui.theinternet;

import static com.google.common.truth.Truth.assertWithMessage;
import static io.github.oneframework.actions.elements.ClickableActions.withMouse;
import static io.github.oneframework.manager.ParallelSession.clearSession;
import static io.github.oneframework.manager.ParallelSession.createSession;
import static io.github.oneframework.testng.ui.theinternet.pages.HomePage.homePage;

import io.github.oneframework.actions.drivers.CookieActions;
import io.github.oneframework.actions.drivers.NavigateActions;
import io.github.oneframework.actions.drivers.WindowActions;
import io.github.oneframework.enums.PlatformType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Cookies test.
 *
 * @author Rahul Rana
 * @since 15-Jul-2022
 */
public class CookiesTest {
    private static final String URL = "https://the-internet.herokuapp.com/";

    /**
     * Setup test class by initialising driver.
     *
     * @param platformType Application type
     * @param driverKey Driver config key
     */
    @BeforeClass (description = "Setup test class")
    @Parameters ({ "platformType", "driverKey" })
    public void setupClass (final PlatformType platformType, final String driverKey) {
        createSession ("CookiesTest", platformType, driverKey);
        WindowActions.onWindow ()
            .minimize ();
        NavigateActions.navigate ()
            .to (URL);
        withMouse (homePage ().link ("JavaScript Alerts")).click ();
    }

    /**
     * Tear down test class by closing driver.
     */
    @AfterClass (description = "Tear down test class")
    public void tearDownClass () {
        clearSession ();
    }

    /**
     * Test delete all cookies.
     */
    @Test (description = "Verify delete all cookies", priority = 3)
    public void testDeleteAllCookies () {
        CookieActions.withCookies ()
            .deleteAll ();
        assertWithMessage ("Cookie size").that (CookieActions.withCookies ()
                .cookies ()
                .size ())
            .isEqualTo (0);
    }

    /**
     * Test delete a single cookie.
     */
    @Test (description = "Tests delete of single cookie", priority = 2)
    public void testDeleteSingleCookie () {
        final var cookies = CookieActions.withCookies ()
            .cookies ();
        final var cookieCount = cookies.size ();
        CookieActions.withCookies ()
            .delete (cookies.get (0));
        assertWithMessage ("Cookie Size").that (CookieActions.withCookies ()
                .cookies ()
                .size ())
            .isEqualTo (cookieCount - 1);
    }

    /**
     * Test get cookie.
     */
    @Test (description = "Test get cookie", priority = 1)
    public void testGetCookie () {
        final var cookie = CookieActions.withCookies ()
            .cookies ()
            .get (0);
        assertWithMessage ("Cookie Name").that (CookieActions.withCookies ()
                .cookie (cookie)
                .getName ())
            .isEqualTo (cookie);
    }
}
