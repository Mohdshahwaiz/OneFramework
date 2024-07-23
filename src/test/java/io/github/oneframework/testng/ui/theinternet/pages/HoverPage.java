

package io.github.oneframework.testng.ui.theinternet.pages;

import static io.github.oneframework.builders.Locator.buildLocator;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.cssSelector;

import io.github.oneframework.builders.Locator;

/**
 * Hover mouse page.
 *
 * @author Rahul Rana
 * @since 26-Jul-2022
 */
public class HoverPage {
    private static final HoverPage HOVER_PAGE = new HoverPage ();

    /**
     * Hover mouse page instance.
     *
     * @return {@link HoverPage}
     */
    public static HoverPage hoverPage () {
        return HOVER_PAGE;
    }

    /**
     * User image locator.
     *
     * @param index Image index
     *
     * @return User image locator
     */
    public Locator userImage (final int index) {
        return buildLocator ().web (className ("figure"))
            .index (index)
            .name ("User Image")
            .build ();
    }

    /**
     * Username locator.
     *
     * @param index Image index
     *
     * @return Username locator
     */
    public Locator userName (final int index) {
        return buildLocator ().web (cssSelector ("div.figcaption h5"))
            .name ("User Name")
            .parent (userImage (index))
            .build ();
    }
}
