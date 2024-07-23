

package io.github.oneframework.testng.ui.theinternet;

import static io.github.oneframework.actions.elements.ClickableActions.withMouse;
import static io.github.oneframework.actions.elements.ElementActions.onElement;
import static io.github.oneframework.manager.ParallelSession.clearSession;
import static io.github.oneframework.manager.ParallelSession.createSession;
import static io.github.oneframework.testng.ui.theinternet.pages.DoubleClickPage.doubleClickPage;

import io.github.oneframework.actions.drivers.AlertActions;
import io.github.oneframework.actions.drivers.NavigateActions;
import io.github.oneframework.enums.PlatformType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Drag and drop test.
 *
 * @author Rahul Rana
 * @since 26-Jul-2022
 */
public class DoubleClickTest {
    private static final String URL = "https://webdriveruniversity.com/Actions/index.html";

    /**
     * Setup test class by initialising driver.
     *
     * @param platformType Application type
     * @param driverKey Driver config key
     */
    @BeforeClass (description = "Setup test class")
    @Parameters ({ "platformType", "driverKey" })
    public void setupClass (final PlatformType platformType, final String driverKey) {
        createSession ("DoubleClickTest", platformType, driverKey);
        NavigateActions.navigate ()
            .to (URL);
    }

    /**
     * Tear down test class by closing driver.
     */
    @AfterClass (description = "Tear down test class")
    public void tearDownClass () {
        clearSession ();
    }

    /**
     * Test click and hold method.
     */
    @Test (description = "Verify Click and Hold method")
    public void testClickAndHold () {
        withMouse (doubleClickPage ().getClickHold ()).clickAndHold ();
        onElement (doubleClickPage ().getClickHold ()).verifyText ()
            .isEqualTo ("Well done! keep holding that click now.....");
    }

    /**
     * Double click test.
     */
    @Test (description = "Double click test")
    public void testDoubleClick () {
        withMouse (doubleClickPage ().getDoubleClick ()).doubleClick ();
        onElement (doubleClickPage ().getDoubleClick ()).verifyStyle ("background-color")
            .isEqualTo ("rgba(147, 203, 90, 1)");
    }

    /**
     * Test hover and click method.
     */
    @Test (description = "Verify Click and Hold method")
    public void testHoverAndClick () {
        withMouse (doubleClickPage ().getHoverButton ()).hover ();
        withMouse (doubleClickPage ().getHoverMenu ()).click ();
        AlertActions.onAlert ()
            .verifyAccept ()
            .isEqualTo ("Well done you clicked on the link!");
    }
}
