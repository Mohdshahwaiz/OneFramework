

package io.github.oneframework.testng.ui.saucedemo.pages;

import static io.appium.java_client.AppiumBy.accessibilityId;
import static org.openqa.selenium.By.id;

import io.github.oneframework.builders.Locator;
import lombok.Getter;

/**
 * Cart page.
 *
 * @author Rahul Rana
 * @since 13-Mar-2022
 */
@Getter
public class CartPage {
    private static final CartPage CART_PAGE = new CartPage ();

    /**
     * Gets Cart page instance.
     *
     * @return Cart page instance
     */
    public static CartPage cartPage () {
        return CART_PAGE;
    }

    private final Locator checkout = Locator.buildLocator ()
        .web (id ("checkout"))
        .android (accessibilityId ("test-CHECKOUT"))
        .ios (accessibilityId ("test-CHECKOUT"))
        .name ("Checkout")
        .build ();

    private CartPage () {
        // Avoid explicit class initialisation
    }
}
