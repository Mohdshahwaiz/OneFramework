

package io.github.oneframework.testng.ui.theinternet.pages;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.tagName;

import io.github.oneframework.builders.Locator;
import lombok.Getter;

/**
 * File Upload page class
 *
 * @author Rahul Rana
 * @since 14-Mar-2023
 */
@Getter
public class FileUploadPage {
    private static final FileUploadPage FILE_UPLOAD_PAGE = new FileUploadPage ();

    /**
     * Gets File upload page class instance
     *
     * @return File upload page
     */
    public static FileUploadPage fileUploadPage () {
        return FILE_UPLOAD_PAGE;
    }

    private final Locator fileSubmit      = Locator.buildLocator ()
        .name ("File Submit Button")
        .web (id ("file-submit"))
        .build ();
    private final Locator fileUploadInput = Locator.buildLocator ()
        .name ("File Upload Input")
        .web (id ("file-upload"))
        .build ();
    private final Locator successTitle    = Locator.buildLocator ()
        .name ("Success Title")
        .web (tagName ("h3"))
        .build ();
}
