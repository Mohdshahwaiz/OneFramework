

package io.github.oneframework.testng.ui.saucedemo.pages;

import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.androidUIAutomator;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.iOSNsPredicateString;
import static java.text.MessageFormat.format;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

import io.github.oneframework.builders.Locator;
import lombok.Getter;

/**
 * Home page object for Sauce demo application.
 *
 * @author Rahul Rana
 * @since 24-Feb-2022
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

    private final Locator allItemsMenu        = Locator.buildLocator ()
        .android (accessibilityId ("test-ALL ITEMS"))
        .ios (accessibilityId ("test-ALL ITEMS"))
        .name ("All Items Menu")
        .build ();
    private final Locator cartDropZone        = Locator.buildLocator ()
        .name ("Cart drop zone")
        .android (accessibilityId ("test-Cart drop zone"))
        .ios (accessibilityId ("test-Cart drop zone"))
        .build ();
    private final Locator logout              = Locator.buildLocator ()
        .web (id ("logout_sidebar_link"))
        .android (accessibilityId ("test-LOGOUT"))
        .ios (accessibilityId ("test-LOGOUT"))
        .name ("Logout")
        .build ();
    private final Locator menuButton          = Locator.buildLocator ()
        .web (id ("react-burger-menu-btn"))
        .android (accessibilityId ("test-Menu"))
        .ios (accessibilityId ("test-Menu"))
        .name ("Menu Button")
        .build ();
    private final Locator productParent       = Locator.buildLocator ()
        .web (cssSelector ("div#inventory_container"))
        .android (accessibilityId ("test-PRODUCTS"))
        .ios (accessibilityId ("test-PRODUCTS"))
        .name ("Product Parent")
        .build ();
    private final Locator productDescription  = Locator.buildLocator ()
        .parent (this.productParent)
        .name ("Product description")
        .android (accessibilityId ("test-Item description"))
        .ios (accessibilityId ("test-Item description"))
        .web (cssSelector ("div.inventory_item_desc"))
        .build ();
    private final Locator addToCartButton     = Locator.buildLocator ()
        .parent (this.productParent)
        .name ("Add to cart button")
        .android (accessibilityId ("test-ADD TO CART"))
        .ios (accessibilityId ("test-ADD TO CART"))
        .web (id ("add-to-cart-sauce-labs-backpack"))
        .build ();
    private final Locator addToCartDragHandle = Locator.buildLocator ()
        .parent (this.productParent)
        .android (accessibilityId ("test-Drag Handle"))
        .ios (accessibilityId ("test-Drag Handle"))
        .name ("Add to cart handle")
        .build ();
    private final Locator productPrice        = Locator.buildLocator ()
        .parent (this.productParent)
        .name ("Product price")
        .android (accessibilityId ("test-Price"))
        .ios (accessibilityId ("test-Price"))
        .web (cssSelector ("div.inventory_item_price"))
        .build ();
    private final Locator productTitle        = Locator.buildLocator ()
        .parent (this.productParent)
        .name ("Product title")
        .android (accessibilityId ("test-Item title"))
        .ios (accessibilityId ("test-Item title"))
        .web (cssSelector ("div.inventory_item_name"))
        .build ();
    private final Locator shoppingCart        = Locator.buildLocator ()
        .web (cssSelector ("a.shopping_cart_link"))
        .android (accessibilityId ("test-Cart"))
        .ios (accessibilityId ("test-Cart"))
        .name ("Shopping Cart")
        .build ();
    private final Locator shoppingCartCount   = Locator.buildLocator ()
        .web (cssSelector ("span.shopping_cart_badge"))
        .parent (this.shoppingCart)
        .android (className ("android.widget.TextView"))
        .ios (className ("XCUIElementTypeOther"))
        .name ("Shopping Cart count")
        .build ();
    private final Locator viewToggle          = Locator.buildLocator ()
        .android (accessibilityId ("test-Toggle"))
        .ios (accessibilityId ("test-Toggle"))
        .name ("View Toggle")
        .build ();

    private HomePage () {
        // Avoid explicit class initialisation
    }

    /**
     * Get product item title locator based on its text.
     *
     * @param productName Product name
     *
     * @return {@link Locator} of product item title
     */
    public Locator productItem (final String productName) {
        return Locator.buildLocator ()
            .web (xpath (format (".//*[text()=\"{0}\"]", productName)))
            .android (androidUIAutomator (format ("new UiSelector().textContains(\"{0}\")", productName)))
            .ios (iOSNsPredicateString (format ("label == \"{0}\"", productName)))
            .name (format ("Product [{0}]", productName))
            .build ();
    }
}
