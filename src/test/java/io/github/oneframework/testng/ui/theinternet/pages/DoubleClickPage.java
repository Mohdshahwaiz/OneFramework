

package io.github.oneframework.testng.ui.theinternet.pages;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.id;

import io.github.oneframework.builders.Locator;
import lombok.Getter;

/**
 * Double click page.
 *
 * @author Rahul Rana
 * @since 27-Jul-2022
 */
@Getter
public class DoubleClickPage {
    private static final DoubleClickPage DOUBLE_CLICK_PAGE = new DoubleClickPage ();

    /**
     * Double click page instance.
     *
     * @return Double click menu
     */
    public static DoubleClickPage doubleClickPage () {
        return DOUBLE_CLICK_PAGE;
    }

    private final Locator clickHold   = Locator.buildLocator ()
        .web (id ("click-box"))
        .name ("Click Hold")
        .build ();
    private final Locator doubleClick = Locator.buildLocator ()
        .web (id ("double-click"))
        .name ("Double Click")
        .build ();
    private final Locator hoverButton = Locator.buildLocator ()
        .web (className ("dropbtn"))
        .name ("Hover Button")
        .build ();
    private final Locator hoverMenu   = Locator.buildLocator ()
        .web (className ("dropdown-content"))
        .name ("Hover Menu")
        .build ();
}
