

package io.github.oneframework.testng.ui.theinternet;

import static io.github.oneframework.actions.elements.ClickableActions.withMouse;
import static io.github.oneframework.actions.elements.ElementActions.onElement;
import static io.github.oneframework.manager.ParallelSession.clearSession;
import static io.github.oneframework.manager.ParallelSession.createSession;
import static io.github.oneframework.testng.ui.theinternet.pages.LoginPage.loginPage;
import static java.text.MessageFormat.format;

import io.github.oneframework.actions.device.DeviceActions;
import io.github.oneframework.actions.drivers.NavigateActions;
import io.github.oneframework.actions.drivers.WindowActions;
import io.github.oneframework.actions.elements.TextBoxActions;
import io.github.oneframework.enums.PlatformType;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Login Test class.
 *
 * @author Rahul Rana
 * @since 16-Sept-2023
 */
public class LoginTest {
    private static final String URL = "https://the-internet.herokuapp.com/login";

    /**
     * Setup test method to take screenshot after each test method.
     */
    @AfterMethod
    public void afterMethod (final ITestResult result) {
        WindowActions.onWindow ()
            .takeScreenshot ();
    }

    /**
     * Setup test class by initialising driver.
     *
     * @param platformType Application type
     * @param driverKey Driver config key
     */
    @BeforeClass (description = "Setup test class")
    @Parameters ({ "platformType", "driverKey" })
    public void setupClass (final PlatformType platformType, final String driverKey) {
        createSession (format ("LoginTest-{0}", platformType), platformType, driverKey);
        DeviceActions.onDevice ()
            .startRecording ();
        NavigateActions.navigate ()
            .to (URL);
    }

    /**
     * Tear down test class by closing driver.
     */
    @AfterClass (description = "Tear down test class")
    public void tearDownClass () {
        DeviceActions.onDevice ()
            .stopRecording ();
        clearSession ();
    }

    @Test (description = "Test Login Flow")
    public void testLogin () {
        TextBoxActions.onTextBox (loginPage ().getUserName ())
            .enterText ("tomsmith");
        TextBoxActions.onTextBox (loginPage ().getPassword ())
            .enterText ("SuperSecretPassword!");
        withMouse (loginPage ().getLogin ()).click ();
        onElement (loginPage ().getMessage ()).verifyText ()
            .contains ("You logged into a secure area!");
        withMouse (loginPage ().getLogout ()).click ();
        onElement (loginPage ().getMessage ()).verifyText ()
            .contains ("You logged out of the secure area!");
    }
}
