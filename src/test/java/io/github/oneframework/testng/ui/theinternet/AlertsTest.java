

package io.github.oneframework.testng.ui.theinternet;

import static io.github.oneframework.actions.drivers.AlertActions.onAlert;
import static io.github.oneframework.actions.elements.ClickableActions.withMouse;
import static io.github.oneframework.actions.elements.ElementActions.onElement;
import static io.github.oneframework.manager.ParallelSession.clearSession;
import static io.github.oneframework.manager.ParallelSession.createSession;
import static io.github.oneframework.testng.ui.theinternet.pages.AlertPage.alertPage;
import static io.github.oneframework.testng.ui.theinternet.pages.HomePage.homePage;

import io.github.oneframework.actions.drivers.NavigateActions;
import io.github.oneframework.actions.drivers.WindowActions;
import io.github.oneframework.enums.PlatformType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * This will test all Web related actions.
 *
 * @author Rahul Rana
 * @since 12-Jul-2022
 */
public class AlertsTest {
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
        createSession ("AlertsTest", platformType, driverKey);
        WindowActions.onWindow ()
            .fullScreen ();
        NavigateActions.navigate ()
            .to (URL);
        withMouse (homePage ().link ("JavaScript Alerts")).click ();
    }

    /**
     * Tear down test class by closing driver.
     */
    @AfterClass (description = "Tear down test class")
    public void tearDownClass () {
        NavigateActions.navigate ()
            .back ();
        NavigateActions.navigate ()
            .verifyUrl ()
            .isEqualTo (URL);
        clearSession ();
    }

    /**
     * This will test Accept alert button action.
     */
    @Test (description = "Tests Accept alert")
    public void testAcceptAlert () {
        withMouse (alertPage ().getAlertButton ()).click ();
        onAlert ().verifyAccept ()
            .isEqualTo ("I am a JS Alert");
        onElement (alertPage ().getResult ()).verifyText ()
            .isEqualTo ("You successfully clicked an alert");
    }

    /**
     * This will test accept confirm button action.
     */
    @Test (description = "Tests Accept confirm alert")
    public void testAcceptConfirmAlert () {
        withMouse (alertPage ().getConfirmButton ()).click ();
        onAlert ().verifyAccept ()
            .isEqualTo ("I am a JS Confirm");
        onElement (alertPage ().getResult ()).verifyText ()
            .isEqualTo ("You clicked: Ok");
    }

    /**
     * This will test dismiss confirm button action.
     */
    @Test (description = "Tests Dismiss confirm alert")
    public void testDismissConfirmAlert () {
        withMouse (alertPage ().getConfirmButton ()).click ();
        onAlert ().verifyDismiss ()
            .isEqualTo ("I am a JS Confirm");
        onElement (alertPage ().getResult ()).verifyText ()
            .isEqualTo ("You clicked: Cancel");
    }

    /**
     * This will test dismiss confirm button action.
     */
    @Test (description = "Tests Dismiss prompt alert")
    public void testDismissPromptAlert () {
        withMouse (alertPage ().getPromptButton ()).click ();
        onAlert ().verifyAccept ("Wasiq")
            .isEqualTo ("I am a JS prompt");
        onElement (alertPage ().getResult ()).verifyText ()
            .isEqualTo ("You entered: Wasiq");
    }
}
