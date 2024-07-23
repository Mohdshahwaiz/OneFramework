

package io.github.oneframework.testng.ui.theinternet;

import static io.github.oneframework.actions.elements.ClickableActions.withMouse;
import static io.github.oneframework.actions.elements.ElementActions.onElement;
import static io.github.oneframework.manager.ParallelSession.clearSession;
import static io.github.oneframework.manager.ParallelSession.createSession;
import static io.github.oneframework.testng.ui.theinternet.pages.DragDropPage.dragDropPage;

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
public class DragDropTest {
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
        createSession ("DragDropTest", platformType, driverKey);
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
     * Drag and Drop test.
     */
    @Test (description = "Drag Drop test")
    public void testDragDrop () {
        withMouse (dragDropPage ().getDraggable ()).dragTo (dragDropPage ().getDroppable ());
        onElement (dragDropPage ().getHeader ()).verifyText ()
            .isEqualTo ("Dropped!");
    }
}
