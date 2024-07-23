

package io.github.oneframework.testng.ui.jiomeet.pages;

import static org.openqa.selenium.By.id;

import io.github.oneframework.builders.Locator;
import lombok.Getter;

@Getter
public class SignInPage {
    private static final SignInPage SIGN_IN_PAGE = new SignInPage ();

    public static SignInPage signInPage () {
        return SIGN_IN_PAGE;
    }

    private final Locator email         = Locator.buildLocator ()
        .name ("Email")
        .web (id ("username"))
        .build ();
    private final Locator password      = Locator.buildLocator ()
        .name ("Password")
        .web (id ("password"))
        .build ();
    private final Locator proceedButton = Locator.buildLocator ()
        .name ("Proceed Button")
        .web (id ("proceedButton"))
        .build ();
    private final Locator signInButton  = Locator.buildLocator ()
        .name ("Sign In Button")
        .web (id ("signinButton"))
        .build ();

    private SignInPage () {
        // Utility class.
    }
}
