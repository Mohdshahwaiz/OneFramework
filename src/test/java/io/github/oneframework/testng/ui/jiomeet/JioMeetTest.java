

package io.github.oneframework.testng.ui.jiomeet;

import static io.github.oneframework.actions.drivers.DriverActions.withDriver;
import static io.github.oneframework.actions.drivers.NavigateActions.navigate;
import static io.github.oneframework.actions.elements.ClickableActions.withMouse;
import static io.github.oneframework.actions.elements.ElementActions.onElement;
import static io.github.oneframework.manager.ParallelSession.clearAllSessions;
import static io.github.oneframework.manager.ParallelSession.createSession;
import static io.github.oneframework.manager.ParallelSession.getSession;
import static io.github.oneframework.manager.ParallelSession.switchPersona;
import static io.github.oneframework.testng.ui.jiomeet.pages.GuestJoinPage.guestJoinPage;
import static io.github.oneframework.testng.ui.jiomeet.pages.HomePage.homePage;
import static io.github.oneframework.testng.ui.jiomeet.pages.MeetingPage.meetingPage;
import static io.github.oneframework.testng.ui.jiomeet.pages.SignInPage.signInPage;
import static io.github.oneframework.testng.ui.jiomeet.pages.StartMeetingPage.startMeetingPage;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;

import io.github.oneframework.actions.drivers.WindowActions;
import io.github.oneframework.actions.elements.TextBoxActions;
import io.github.oneframework.enums.PlatformType;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class JioMeetTest {
    private static final String GUEST_PERSONA = "User 2";
    private static final String HOST_NAME     = "hostName";
    private static final String HOST_PERSONA  = "User 1";
    private static final String MEETING_URL   = "meetingUrl";

    @AfterMethod
    public void afterMethod (final ITestResult result) {
        if (!result.isSuccess ()) {
            WindowActions.onWindow ()
                .takeScreenshot ();
        }
    }

    @BeforeClass
    @Parameters ({ "platformType", "driverKey" })
    public void setupTestClass (final PlatformType platformType, final String chromeConfig) {
        createSession (HOST_PERSONA, platformType, chromeConfig);
        createSession (GUEST_PERSONA, platformType, chromeConfig);
    }

    @AfterClass
    public void tearDownClass () {
        clearAllSessions ();
    }

    @Test (dependsOnMethods = "testHostParticipantName")
    public void testEndMeeting () {
        switchPersona (GUEST_PERSONA);
        withMouse (meetingPage ().getEndCallButton ()).click ();

        switchPersona (HOST_PERSONA);
        withMouse (meetingPage ().getEndCallButton ()).click ();
        withMouse (meetingPage ().getEndForAll ()).click ();

        if (onElement (meetingPage ().getSkipButton ()).isDisplayed ()) {
            withMouse (meetingPage ().getSkipButton ()).click ();
        }
    }

    @Test (dependsOnMethods = "testGuestStartMeeting")
    public void testGuestParticipantName () {
        withMouse (meetingPage ().getParticipants ()).click ();
        onElement (meetingPage ().getCurrentParticipantName (GUEST_PERSONA)).verifyText ()
            .endsWith ("(You)");
    }

    @Test (dependsOnMethods = "testStartHostMeeting")
    public void testGuestStartMeeting () {
        final var meetingUrl = getSession ().getSharedData (MEETING_URL)
            .toString ();

        switchPersona (GUEST_PERSONA);
        navigate ().to (meetingUrl);

        TextBoxActions.onTextBox (guestJoinPage ().getGuestName ())
            .enterText (GUEST_PERSONA);
        withMouse (guestJoinPage ().getJoinButton ()).click ();

        withDriver ().waitUntil (invisibilityOfElementLocated (homePage ().getLoader ()
            .getLocator ()));
    }

    @Test (dependsOnMethods = "testGuestParticipantName")
    public void testHostParticipantName () {
        switchPersona (HOST_PERSONA);
        withMouse (meetingPage ().getParticipants ()).click ();
        onElement (meetingPage ().getCurrentParticipantName (getSession ().getSharedData (HOST_NAME))).verifyText ()
            .endsWith ("(You)");
    }

    @Test
    public void testHostSignIn () {
        switchPersona (HOST_PERSONA);
        navigate ().to ("https://jiomeetpro.jio.com/home");

        withMouse (homePage ().getSignIn ()).click ();
        TextBoxActions.onTextBox (signInPage ().getEmail ())
            .enterText ("test-user1@mailinator.com");
        withMouse (signInPage ().getProceedButton ()).click ();
        TextBoxActions.onTextBox (signInPage ().getPassword ())
            .enterText ("Admin@1234");
        withMouse (signInPage ().getSignInButton ()).click ();
    }

    @Test (dependsOnMethods = "testHostSignIn")
    public void testStartHostMeeting () {
        withMouse (homePage ().getStartMeeting ()).click ();
        withMouse (startMeetingPage ().getStart ()).click ();

        withDriver ().waitUntil (invisibilityOfElementLocated (homePage ().getLoader ()
            .getLocator ()));

        getSession ().setSharedData (HOST_NAME, "Test User");
        getSession ().setSharedData (MEETING_URL, onElement (meetingPage ().getMeetingLink ()).getText ());
    }
}
