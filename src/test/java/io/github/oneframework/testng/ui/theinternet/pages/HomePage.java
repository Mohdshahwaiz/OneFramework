

package io.github.oneframework.testng.ui.theinternet.pages;

import static java.text.MessageFormat.format;
import static org.openqa.selenium.By.linkText;

import io.github.oneframework.builders.Locator;
import lombok.Getter;

/**
 * Home page.
 *
 * @author Rahul Rana
 * @since 13-Jul-2022
 */
@Getter
public class HomePage {
    private static final HomePage HOME_PAGE = new HomePage ();

    /**
     * Home page instance.
     *
     * @return {@link HomePage}
     */
    public static HomePage homePage () {
        return HOME_PAGE;
    }

    /**
     * Gets link locator based on the link name.
     *
     * @param linkText link name
     *
     * @return link locator
     */
    public Locator link (final String linkText) {
        return Locator.buildLocator ()
            .web (linkText (linkText))
            .name (format ("Link [{0}]", linkText))
            .build ();
    }
}
