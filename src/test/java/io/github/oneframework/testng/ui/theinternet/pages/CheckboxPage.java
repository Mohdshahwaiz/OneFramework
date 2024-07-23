

package io.github.oneframework.testng.ui.theinternet.pages;

import static org.openqa.selenium.By.cssSelector;

import io.github.oneframework.builders.Locator;
import lombok.Getter;

/**
 * Checkbox page.
 *
 * @author Rahul Rana
 * @since 05-Aug-2022
 */
@Getter
public class CheckboxPage {
    private static final CheckboxPage CHECKBOX_PAGE = new CheckboxPage ();

    /**
     * Checkbox page instance.
     *
     * @return {@link CheckboxPage}
     */
    public static CheckboxPage checkboxPage () {
        return CHECKBOX_PAGE;
    }

    private final Locator option1 = Locator.buildLocator ()
        .web (cssSelector ("form#checkboxes input"))
        .name ("Option 1")
        .build ();
    private final Locator option2 = Locator.buildLocator ()
        .web (cssSelector ("form#checkboxes input"))
        .name ("Option 2")
        .index (1)
        .build ();
}
