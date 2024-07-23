

package io.github.oneframework.testng.ui.theinternet;

import static io.github.oneframework.actions.drivers.AlertActions.onAlert;
import static io.github.oneframework.actions.drivers.NavigateActions.navigate;
import static io.github.oneframework.actions.elements.ClickableActions.withMouse;
import static io.github.oneframework.manager.ParallelSession.clearSession;
import static io.github.oneframework.manager.ParallelSession.createSession;
import static io.github.oneframework.testng.ui.theinternet.pages.ContextMenuPage.contextMenuPage;
import static io.github.oneframework.testng.ui.theinternet.pages.HomePage.homePage;

import io.github.oneframework.enums.PlatformType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Context menu test.
 *
 * @author Rahul Rana
 * @since 26-Jul-2022
 */
public class ContextMenuTest {
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
        createSession ("ContextMenuTest", platformType, driverKey);
        navigate ().to (URL);
        withMouse (homePage ().link ("Context Menu")).click ();
    }

    /**
     * Tear down test class by closing driver.
     */
    @AfterClass (description = "Tear down test class")
    public void tearDownClass () {
        clearSession ();
    }

    /**
     * Test context menu.
     */
    @Test (description = "Test context menu")
    public void testContextMenu () {
        withMouse (contextMenuPage ().getHotSpot ()).rightClick ();
        onAlert ().verifyAccept ()
            .isEqualTo ("You selected a context menu");
    }
}
