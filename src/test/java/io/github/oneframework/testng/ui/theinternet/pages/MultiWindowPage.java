

package io.github.oneframework.testng.ui.theinternet.pages;

import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.tagName;

import io.github.oneframework.builders.Locator;
import lombok.Getter;

/**
 * Multi window page.
 *
 * @author Rahul Rana
 * @since 16-Jul-2022
 */
@Getter
public class MultiWindowPage {
    /**
     * Multi window page instance.
     *
     * @return {@link MultiWindowPage}
     */
    public static MultiWindowPage multiWindowPage () {
        return new MultiWindowPage ();
    }

    private final Locator clickHere = Locator.buildLocator ()
        .web (linkText ("Click Here"))
        .name ("Click Here")
        .build ();
    private final Locator title     = Locator.buildLocator ()
        .web (tagName ("h3"))
        .name ("Title")
        .build ();
}
