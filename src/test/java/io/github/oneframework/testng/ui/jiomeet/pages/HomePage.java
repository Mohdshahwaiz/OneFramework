

package io.github.oneframework.testng.ui.jiomeet.pages;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.linkText;

import io.github.oneframework.builders.Locator;
import lombok.Getter;

/**
 * Jio Meet Application.
 *
 * @author Rahul Rana
 * @since 24-Mar-2023
 */
@Getter
public class HomePage {
    private static final HomePage HOME_PAGE = new HomePage ();

    public static HomePage homePage () {
        return HOME_PAGE;
    }

    private final Locator loader       = Locator.buildLocator ()
        .name ("Loader")
        .web (cssSelector ("div.loaderContainer div.loader"))
        .build ();
    private final Locator signIn       = Locator.buildLocator ()
        .name ("Sign In")
        .web (linkText ("Sign In"))
        .build ();
    private final Locator startMeeting = Locator.buildLocator ()
        .name ("Start Meeting")
        .web (cssSelector ("div.quick-link"))
        .filter (e -> e.getText ()
            .equals ("Start a Meeting"))
        .build ();

    private HomePage () {
        // Utility class.
    }
}
