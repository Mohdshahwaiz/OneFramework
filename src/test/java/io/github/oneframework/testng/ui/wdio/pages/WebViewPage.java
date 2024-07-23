

package io.github.oneframework.testng.ui.wdio.pages;

import static org.openqa.selenium.By.cssSelector;

import io.github.oneframework.builders.Locator;
import lombok.Getter;

@Getter
public class WebViewPage {
    private static final WebViewPage WEB_VIEW_PAGE = new WebViewPage ();

    public static WebViewPage webViewPage () {
        return WEB_VIEW_PAGE;
    }

    private final Locator pageTitle = Locator.buildLocator ()
        .name ("Page Title")
        .android (cssSelector ("h1 + p"))
        .ios (cssSelector ("h1 + p"))
        .build ();
}
