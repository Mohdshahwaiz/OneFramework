

package io.github.oneframework.testng.ui.theinternet;

import static io.github.oneframework.actions.drivers.NavigateActions.navigate;
import static io.github.oneframework.actions.elements.ClickableActions.withMouse;
import static io.github.oneframework.actions.elements.ElementActions.onElement;
import static io.github.oneframework.manager.ParallelSession.clearSession;
import static io.github.oneframework.manager.ParallelSession.createSession;
import static io.github.oneframework.testng.ui.theinternet.pages.HomePage.homePage;
import static io.github.oneframework.testng.ui.theinternet.pages.HoverPage.hoverPage;
import static java.text.MessageFormat.format;

import io.github.oneframework.enums.PlatformType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Hover mouse test.
 *
 * @author Rahul Rana
 * @since 26-Jul-2022
 */
public class HoverTest {
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
        createSession ("HoverTest", platformType, driverKey);
        navigate ().to (URL);
        withMouse (homePage ().link ("Hovers")).click ();
    }

    /**
     * Tear down test class by closing driver.
     */
    @AfterClass (description = "Tear down test class")
    public void tearDownClass () {
        clearSession ();
    }

    /**
     * Hover mouse test.
     */
    @Test (description = "Hover mouse test")
    public void testMouseHover () {
        final var expectedUserName = "name: user1";
        withMouse (hoverPage ().userImage (0)).hover ();
        onElement (hoverPage ().userName (0)).verifyText ()
            .isEqualTo (format (expectedUserName, 1));
    }
}
