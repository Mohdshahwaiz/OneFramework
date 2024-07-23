

package io.github.oneframework.testng.ui.theinternet;

import static io.github.oneframework.actions.elements.ClickableActions.withMouse;
import static io.github.oneframework.actions.elements.ElementActions.onElement;
import static io.github.oneframework.manager.ParallelSession.clearSession;
import static io.github.oneframework.manager.ParallelSession.createSession;
import static io.github.oneframework.testng.ui.theinternet.pages.CheckboxPage.checkboxPage;

import io.github.oneframework.actions.drivers.NavigateActions;
import io.github.oneframework.enums.PlatformType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CheckboxTest {
    private static final String URL = "https://the-internet.herokuapp.com/checkboxes";

    /**
     * Setup test class by initialising driver.
     *
     * @param platformType Application type
     * @param driverKey Driver config key
     */
    @BeforeClass (description = "Setup test class")
    @Parameters ({ "platformType", "driverKey" })
    public void setupClass (final PlatformType platformType, final String driverKey) {
        createSession ("CheckboxTest", platformType, driverKey);
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
     * Test select checkbox.
     */
    @Test (description = "Verify select checkbox")
    public void testCheckOption () {
        onElement (checkboxPage ().getOption1 ()).verifyIsSelected ()
            .isFalse ();
        onElement (checkboxPage ().getOption2 ()).verifyIsSelected ()
            .isTrue ();
        withMouse (checkboxPage ().getOption1 ()).click ();
        onElement (checkboxPage ().getOption1 ()).verifyIsSelected ()
            .isTrue ();
    }
}
