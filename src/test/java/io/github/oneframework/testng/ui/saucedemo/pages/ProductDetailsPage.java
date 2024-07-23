

package io.github.oneframework.testng.ui.saucedemo.pages;

import static io.appium.java_client.AppiumBy.accessibilityId;
import static org.openqa.selenium.By.cssSelector;

import io.github.oneframework.builders.Locator;
import lombok.Getter;

/**
 * Product details page.
 *
 * @author Rahul Rana
 * @since 10-Mar-2022
 */
@Getter
public class ProductDetailsPage {
    private static final ProductDetailsPage PRODUCT_DETAILS_PAGE = new ProductDetailsPage ();

    /**
     * Gets the product details page instance.
     *
     * @return {@link ProductDetailsPage} instance
     */
    public static ProductDetailsPage productDetailsPage () {
        return PRODUCT_DETAILS_PAGE;
    }

    private final Locator container = Locator.buildLocator ()
        .web (cssSelector ("div#inventory_item_container div.inventory_details"))
        .android (accessibilityId ("test-Inventory item page"))
        .ios (accessibilityId ("test-Inventory item page"))
        .name ("Container")
        .build ();
    private final Locator image     = Locator.buildLocator ()
        .name ("Product Image")
        .android (accessibilityId ("test-Image Container"))
        .ios (accessibilityId ("test-Image Container"))
        .build ();

    private ProductDetailsPage () {
        // Avoid explicit class initialisation.
    }
}
