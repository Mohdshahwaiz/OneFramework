

package io.github.oneframework.testng.ui.theinternet.pages;

import static org.openqa.selenium.By.id;

import io.github.oneframework.builders.Locator;
import lombok.Getter;

/**
 * DropDown page.
 *
 * @author Rahul Rana
 * @since 30-Jul-2022
 */
@Getter
public class DropDownPage {
    private static final DropDownPage DROP_DOWN_PAGE = new DropDownPage ();

    /**
     * Drag and drop page instance.
     *
     * @return {@link DropDownPage}
     */
    public static DropDownPage dropDownPage () {
        return DROP_DOWN_PAGE;
    }

    private final Locator fruits      = Locator.buildLocator ()
        .web (id ("fruits"))
        .name ("Fruits")
        .build ();
    private final Locator superHeroes = Locator.buildLocator ()
        .web (id ("superheros"))
        .name ("Super Heroes")
        .build ();
}
