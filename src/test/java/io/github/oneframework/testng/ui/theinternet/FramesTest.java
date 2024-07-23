

package io.github.oneframework.testng.ui.theinternet;

import static io.github.oneframework.actions.drivers.FrameActions.onFrame;
import static io.github.oneframework.actions.elements.ClickableActions.withMouse;
import static io.github.oneframework.actions.elements.ElementActions.onElement;
import static io.github.oneframework.manager.ParallelSession.clearSession;
import static io.github.oneframework.manager.ParallelSession.createSession;
import static io.github.oneframework.testng.ui.theinternet.pages.FramesPage.framesPage;
import static io.github.oneframework.testng.ui.theinternet.pages.HomePage.homePage;
import static io.github.oneframework.testng.ui.theinternet.pages.NestedFramePage.nestedFramePage;

import io.github.oneframework.actions.drivers.NavigateActions;
import io.github.oneframework.enums.PlatformType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Frames related tests.
 *
 * @author Rahul Rana
 * @since 23-Jul-2022
 */
public class FramesTest {
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
        createSession ("FramesTest", platformType, driverKey);
        NavigateActions.navigate ()
            .to (URL);
        withMouse (homePage ().link ("Frames")).click ();
    }

    /**
     * Tear down test class by closing driver.
     */
    @AfterClass (description = "Tear down test class")
    public void tearDownClass () {
        clearSession ();
    }

    /**
     * Test nested bottom frame.
     */
    @Test
    public void testNestedBottomFrame () {
        try {
            withMouse (framesPage ().getNestedFrames ()).click ();
            onFrame ().switchTo (nestedFramePage ().getFrameBottom ());
            onElement (nestedFramePage ().getBody ()).verifyText ()
                .isEqualTo ("BOTTOM");
        } finally {
            onFrame ().switchToParent ();
        }
    }

    /**
     * Test nested left frame.
     */
    @Test
    public void testNestedLeftFrame () {
        try {
            onFrame ().switchTo (nestedFramePage ().getFrameTop ());
            onFrame ().switchTo (nestedFramePage ().getFrameLeft ());
            onElement (nestedFramePage ().getBody ()).verifyText ()
                .isEqualTo ("LEFT");
        } finally {
            onFrame ().switchToParent ();
            onFrame ().switchToParent ();
        }
    }

    /**
     * Test nested middle frame.
     */
    @Test
    public void testNestedMiddleFrame () {
        try {
            onFrame ().switchTo (nestedFramePage ().getFrameTop ());
            onFrame ().switchTo (nestedFramePage ().getFrameMiddle ());
            onElement (nestedFramePage ().getBody ()).verifyText ()
                .isEqualTo ("MIDDLE");
        } finally {
            onFrame ().switchToParent ();
            onFrame ().switchToParent ();
        }
    }

    /**
     * Test nested right frame.
     */
    @Test
    public void testNestedRightFrame () {
        try {
            onFrame ().switchTo (nestedFramePage ().getFrameTop ());
            onFrame ().switchTo (nestedFramePage ().getFrameRight ());
            onElement (nestedFramePage ().getBody ()).verifyText ()
                .isEqualTo ("RIGHT");
        } finally {
            onFrame ().switchToParent ();
            onFrame ().switchToParent ();
        }
    }
}
