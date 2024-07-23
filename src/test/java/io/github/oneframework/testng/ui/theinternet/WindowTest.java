

package io.github.oneframework.testng.ui.theinternet;

import static com.google.common.truth.Truth.assertWithMessage;
import static io.github.oneframework.actions.drivers.AlertActions.onAlert;
import static io.github.oneframework.actions.drivers.DriverActions.withDriver;
import static io.github.oneframework.actions.elements.ClickableActions.withMouse;
import static io.github.oneframework.actions.elements.ElementActions.onElement;
import static io.github.oneframework.manager.ParallelSession.clearSession;
import static io.github.oneframework.manager.ParallelSession.createSession;
import static io.github.oneframework.testng.ui.theinternet.pages.HomePage.homePage;
import static io.github.oneframework.testng.ui.theinternet.pages.MultiWindowPage.multiWindowPage;
import static java.text.MessageFormat.format;
import static org.openqa.selenium.WindowType.TAB;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlMatches;

import io.github.oneframework.actions.drivers.NavigateActions;
import io.github.oneframework.actions.drivers.WindowActions;
import io.github.oneframework.enums.PlatformType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Browser window specific tests.
 *
 * @author Rahul Rana
 * @since 16-Jul-2022
 */
public class WindowTest {
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
        createSession ("WindowTest", platformType, driverKey);
        WindowActions.onWindow ()
            .maximize ();
        NavigateActions.navigate ()
            .to (URL);
        withMouse (homePage ().link ("Multiple Windows")).click ();
    }

    /**
     * Tear down test class by closing driver.
     */
    @AfterClass (description = "Tear down test class")
    public void tearDownClass () {
        clearSession ();
    }

    /**
     * Test case to verify browser back navigation.
     */
    @Test (description = "Test browser back navigation")
    public void testBackNavigation () {
        NavigateActions.navigate ()
            .back ();
        NavigateActions.navigate ()
            .verifyUrl ()
            .isEqualTo (URL);
    }

    /**
     * Test case to verify execute script.
     */
    @Test (description = "Test execute script method")
    public void testExecuteScript () {
        final String script = "alert('Hello World');";
        withDriver ().executeScript (script);
        onAlert ().verifyAccept ()
            .isEqualTo ("Hello World");
    }

    /**
     * Test case to verify browser forward navigation.
     */
    @Test (description = "Test browser forward navigation")
    public void testForwardNavigation () {
        NavigateActions.navigate ()
            .forward ();
        NavigateActions.navigate ()
            .verifyUrl ()
            .isEqualTo (format ("{0}windows", URL));
    }

    /**
     * Test case to verify opening new tab window.
     */
    @Test (description = "Test to verify opening new tab")
    public void testOpenNewTab () {
        try {
            WindowActions.onWindow ()
                .switchToNew (TAB);
            WindowActions.onWindow ()
                .verifyTitle ()
                .isEmpty ();
            NavigateActions.navigate ()
                .verifyUrl ()
                .isEqualTo ("about:blank");
        } finally {
            WindowActions.onWindow ()
                .close ();
        }
    }

    /**
     * Test case to verify opening new window.
     */
    @Test
    public void testOpenWindow () {
        final var currentWindow = WindowActions.onWindow ()
            .currentHandle ();
        withMouse (multiWindowPage ().getClickHere ()).click ();
        final var newWindow = WindowActions.onWindow ()
            .handles ()
            .stream ()
            .filter (handle -> !handle.equals (currentWindow))
            .findFirst ();
        assertWithMessage ("Window").that (newWindow.isPresent ())
            .isTrue ();
        WindowActions.onWindow ()
            .switchTo (newWindow.get ());
        withDriver ().waitUntil (urlMatches (format ("{0}windows/new", URL)));
        NavigateActions.navigate ()
            .verifyUrl ()
            .isEqualTo (format ("{0}windows/new", URL));
        onElement (multiWindowPage ().getTitle ()).verifyText ()
            .isEqualTo ("New Window");
        WindowActions.onWindow ()
            .close ();
        NavigateActions.navigate ()
            .verifyUrl ()
            .isEqualTo (format ("{0}windows", URL));
    }

    /**
     * Test case to verify browser refresh.
     */
    @Test (description = "Test to verify page refresh")
    public void testRefreshPage () {
        NavigateActions.navigate ()
            .refresh ();
        NavigateActions.navigate ()
            .verifyUrl ()
            .isEqualTo (format ("{0}windows", URL));
    }
}
