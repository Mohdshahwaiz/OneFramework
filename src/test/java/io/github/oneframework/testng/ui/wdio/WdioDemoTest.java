

package io.github.oneframework.testng.ui.wdio;

import static io.github.oneframework.actions.drivers.DriverActions.withDriver;
import static io.github.oneframework.actions.elements.ClickableActions.withMouse;
import static io.github.oneframework.actions.elements.ElementActions.onElement;
import static io.github.oneframework.actions.elements.FingerActions.withFinger;
import static io.github.oneframework.enums.PlatformType.ANDROID;
import static io.github.oneframework.manager.ParallelSession.clearSession;
import static io.github.oneframework.manager.ParallelSession.createSession;
import static io.github.oneframework.manager.ParallelSession.getSession;
import static io.github.oneframework.testng.ui.wdio.pages.AlertDialog.alertDialog;
import static io.github.oneframework.testng.ui.wdio.pages.DragDropPage.dragDropPage;
import static io.github.oneframework.testng.ui.wdio.pages.SignUpPage.signUpPage;
import static io.github.oneframework.testng.ui.wdio.pages.WDIOHomePage.wdioHomePage;
import static io.github.oneframework.testng.ui.wdio.pages.WebViewPage.webViewPage;
import static java.text.MessageFormat.format;

import io.github.oneframework.actions.device.DeviceActions;
import io.github.oneframework.actions.drivers.ContextActions;
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
 * Test class for testing different Mobile gestures.
 *
 * @author Rahul Rana
 * @since 24-Dec-2022
 */
public class WdioDemoTest {
    /**
     * Setup test method to take screenshot after each test method.
     */
    @AfterMethod
    public void afterMethod (final ITestResult result) {
        if (!result.isSuccess ()) {
            WindowActions.onWindow ()
                .takeScreenshot ();
        }
    }

    /**
     * Setup test class by initializing driver.
     *
     * @param platformType Application type
     * @param driverKey Driver config key
     */
    @BeforeClass (description = "Setup test class")
    @Parameters ({ "platformType", "driverKey" })
    public void setupTestClass (final PlatformType platformType, final String driverKey) {
        createSession (format ("WdioDemoTest-{0}", platformType), platformType, driverKey);
        DeviceActions.onDevice ()
            .startRecording ();
    }

    /**
     * Tear down test class by closing driver.
     */
    @AfterClass (description = "Tear down test class")
    public void tearDownTestClass () {
        DeviceActions.onDevice ()
            .stopRecording ();
        withDriver ().saveLogs ();
        clearSession ();
    }

    /**
     * Test Drag drop
     */
    @Test
    public void testDragDrop () {
        withFinger (wdioHomePage ().getDragTab ()).tap ();
        for (var index = 1; index <= 3; index++) {
            withFinger (dragDropPage ().leftSourceTile (index)).dragTo (dragDropPage ().leftTargetTile (index));
            withFinger (dragDropPage ().centerSourceTile (index)).dragTo (dragDropPage ().centerTargetTile (index));
            withFinger (dragDropPage ().rightSourceTile (index)).dragTo (dragDropPage ().rightTargetTile (index));
        }
        onElement (dragDropPage ().getTitle ()).verifyText ()
            .isEqualTo ("Congratulations");
        onElement (dragDropPage ().getDescription ()).verifyText ()
            .isEqualTo ("You made it, click retry if you want to try it again.");
    }

    /**
     * Sign Up test.
     */
    @Test
    public void testSignUp () {
        final var userName = "admin@gmail.com";
        final var password = "Admin@1234";
        withFinger (wdioHomePage ().getLoginTab ()).tap ();

        withFinger (signUpPage ().getSignUpTab ()).tap ();
        TextBoxActions.onTextBox (signUpPage ().getEmail ())
            .enterText (userName);
        TextBoxActions.onTextBox (signUpPage ().getPassword ())
            .enterText (password);
        TextBoxActions.onTextBox (signUpPage ().getConfirmPassword ())
            .enterText (password);

        if (getSession ().getPlatformType () == ANDROID) {
            DeviceActions.onDevice ()
                .hideKeyboard ();
        }

        withFinger (signUpPage ().getSignUp ()).tap ();

        alertDialog ().verifyMessage ("You successfully signed up!");
    }

    /**
     * Test web view screen.
     */
    @Test (description = "Test WebView screen")
    public void testWebView () {
        withMouse (wdioHomePage ().getWebViewTab ()).click ();

        verifyWebView ();
    }

    private void verifyWebView () {
        ContextActions.withContext ()
            .switchToWebView ();

        onElement (webViewPage ().getPageTitle ()).verifyText ()
            .isEqualTo ("Next-gen browser and mobile automation test framework for Node.js");

        ContextActions.withContext ()
            .switchToNative ();

        onElement (wdioHomePage ().getWebViewTab ()).verifyIsDisplayed ()
            .isTrue ();
    }
}
