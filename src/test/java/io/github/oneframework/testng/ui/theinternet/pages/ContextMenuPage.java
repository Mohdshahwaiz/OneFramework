

package io.github.oneframework.testng.ui.theinternet.pages;

import io.github.oneframework.builders.Locator;
import lombok.Getter;
import org.openqa.selenium.By;

/**
 * Context menu page.
 *
 * @author Rahul Rana
 * @since 26-Jul-2022
 */
@Getter
public class ContextMenuPage {
    private static final ContextMenuPage CONTEXT_MENU_PAGE = new ContextMenuPage ();

    /**
     * Context menu page instance.
     *
     * @return Context menu page instance
     */
    public static ContextMenuPage contextMenuPage () {
        return CONTEXT_MENU_PAGE;
    }

    private final Locator hotSpot = Locator.buildLocator ()
        .web (By.id ("hot-spot"))
        .name ("Hot Spot")
        .build ();
}
