

package io.github.oneframework.testng.ui.theinternet.pages;

import static org.openqa.selenium.By.linkText;

import io.github.oneframework.builders.Locator;
import lombok.Getter;

/**
 * Frames pages.
 *
 * @author Rahul Rana
 * @since 23-Jul-2022
 */
@Getter
public class FramesPage {
    private static final FramesPage FRAMES_PAGE = new FramesPage ();

    /**
     * Frames page locators.
     *
     * @return {@link FramesPage} instance
     */
    public static FramesPage framesPage () {
        return FRAMES_PAGE;
    }

    private final Locator frame        = Locator.buildLocator ()
        .web (linkText ("iFrame"))
        .name ("Frame")
        .build ();
    private final Locator nestedFrames = Locator.buildLocator ()
        .web (linkText ("Nested Frames"))
        .name ("Nested Frames")
        .build ();
}
