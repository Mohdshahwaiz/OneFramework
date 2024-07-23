

package io.github.oneframework.testng.ui.theinternet.pages;

import static org.openqa.selenium.By.tagName;

import io.github.oneframework.builders.Locator;
import lombok.Getter;

/**
 * Nested Frames pages.
 *
 * @author Rahul Rana
 * @since 25-Jul-2022
 */
@Getter
public class NestedFramePage {
    /**
     * Nested Frames page.
     *
     * @return {@link NestedFramePage}
     */
    public static NestedFramePage nestedFramePage () {
        return new NestedFramePage ();
    }

    private final Locator body        = Locator.buildLocator ()
        .web (tagName ("body"))
        .name ("Body")
        .build ();
    private final String  frameBottom = "frame-bottom";
    private final String  frameLeft   = "frame-left";
    private final String  frameMiddle = "frame-middle";
    private final String  frameRight  = "frame-right";
    private final String  frameTop    = "frame-top";
}
