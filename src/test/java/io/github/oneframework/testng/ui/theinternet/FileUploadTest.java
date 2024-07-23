

package io.github.oneframework.testng.ui.theinternet;

import static io.github.oneframework.actions.drivers.NavigateActions.navigate;
import static io.github.oneframework.actions.elements.ClickableActions.withMouse;
import static io.github.oneframework.actions.elements.ElementActions.onElement;
import static io.github.oneframework.actions.elements.TextBoxActions.onTextBox;
import static io.github.oneframework.manager.ParallelSession.clearSession;
import static io.github.oneframework.manager.ParallelSession.createSession;
import static io.github.oneframework.testng.ui.theinternet.pages.FileUploadPage.fileUploadPage;
import static java.lang.System.getProperty;

import java.nio.file.Path;

import io.github.oneframework.enums.PlatformType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Test File Upload feature.
 *
 * @author Rahul Rana
 * @since 14-Mar-2023
 */
public class FileUploadTest {
    private static final String URL = "https://the-internet.herokuapp.com/upload";

    /**
     * Setup test class by initialising driver.
     *
     * @param platformType Application type
     * @param driverKey Driver config key
     */
    @BeforeClass (description = "Setup test class")
    @Parameters ({ "platformType", "driverKey" })
    public void setupClass (final PlatformType platformType, final String driverKey) {
        createSession ("FileUploadTest", platformType, driverKey);
        navigate ().toBaseUrl ();
        navigate ().to (URL);
    }

    /**
     * Tear down test class by closing driver.
     */
    @AfterClass (description = "Tear down test class")
    public void tearDownClass () {
        clearSession ();
    }

    @Test
    public void testFileUpload () {
        final var filePath = Path.of (getProperty ("user.dir"), "src/test/resources/test-file.txt")
            .toFile ();
        onTextBox (fileUploadPage ().getFileUploadInput ()).enterText (filePath.getPath ());

        withMouse (fileUploadPage ().getFileSubmit ()).click ();
        onElement (fileUploadPage ().getSuccessTitle ()).verifyText ()
            .isEqualTo ("File Uploaded!");
    }
}
