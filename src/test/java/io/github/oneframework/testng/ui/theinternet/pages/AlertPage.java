

package io.github.oneframework.testng.ui.theinternet.pages;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;

import io.github.oneframework.builders.Locator;
import lombok.Getter;

/**
 * Alert page object.
 *
 * @author Rahul Rana
 * @since 14-Jul-2022
 */
@Getter
public class AlertPage {
    private static final AlertPage ALERT_PAGE = new AlertPage ();

    /**
     * Alert page instance.
     *
     * @return {@link AlertPage}
     */
    public static AlertPage alertPage () {
        return ALERT_PAGE;
    }

    private final Locator alertButton   = Locator.buildLocator ()
        .web (cssSelector ("ul > li > button"))
        .name ("Alert button")
        .index (0)
        .build ();
    private final Locator confirmButton = Locator.buildLocator ()
        .web (cssSelector ("ul > li > button"))
        .name ("Confirm Button")
        .index (1)
        .build ();
    private final Locator promptButton  = Locator.buildLocator ()
        .web (cssSelector ("ul > li > button"))
        .name ("Prompt Button")
        .index (2)
        .build ();
    private final Locator result        = Locator.buildLocator ()
        .web (id ("result"))
        .name ("Result")
        .build ();
}
