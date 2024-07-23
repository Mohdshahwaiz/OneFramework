package io.github.oneframework.testng.ui.saucedemo.actions;

import static io.appium.java_client.android.nativekey.AndroidKey.BACK;
import static io.github.oneframework.actions.device.AndroidDeviceActions.onAndroidDevice;
import static io.github.oneframework.actions.device.DeviceActions.onDevice;
import static io.github.oneframework.actions.drivers.NavigateActions.navigate;
import static io.github.oneframework.actions.drivers.WindowActions.onWindow;
import static io.github.oneframework.actions.elements.ClickableActions.withMouse;
import static io.github.oneframework.actions.elements.ElementActions.onElement;
import static io.github.oneframework.actions.elements.FingerActions.withFinger;
import static io.github.oneframework.actions.elements.FingersActions.withFingers;
import static io.github.oneframework.actions.elements.TextBoxActions.onTextBox;
import static io.github.oneframework.enums.PlatformType.ANDROID;
import static io.github.oneframework.enums.PlatformType.WEB;
import static io.github.oneframework.enums.SwipeDirection.DOWN;
import static io.github.oneframework.enums.SwipeDirection.UP;
import static io.github.oneframework.manager.ParallelSession.getSession;
import static io.github.oneframework.testng.ui.saucedemo.pages.CartPage.cartPage;
import static io.github.oneframework.testng.ui.saucedemo.pages.CheckoutPage.checkoutPage;
import static io.github.oneframework.testng.ui.saucedemo.pages.HomePage.homePage;
import static io.github.oneframework.testng.ui.saucedemo.pages.LoginPage.loginPage;
import static io.github.oneframework.testng.ui.saucedemo.pages.ProductDetailsPage.productDetailsPage;
import static java.text.MessageFormat.format;

import io.github.oneframework.enums.PlatformType;

public class SauceDemoActions {
    private static final String       URL = "https://www.saucedemo.com";
    private final        PlatformType platformType;

    public SauceDemoActions () {
        this.platformType = getSession ().getPlatformType ();
    }

    public void verifyAddToCart () {
        if (this.platformType == WEB) {
            withMouse (homePage ().getAddToCartButton ()).click ();
        } else {
            withFinger (homePage ().getAddToCartDragHandle ()).dragTo (homePage ().getCartDropZone ());
        }

        onElement (homePage ().getProductPrice ()).verifyText ()
            .isEqualTo ("$29.99");
        onElement (homePage ().getShoppingCartCount ()).verifyText ()
            .isEqualTo ("1");

        verifyProductDetailPage ();
        verifyProductCartPage ();
    }

    public void verifyCheckoutStep1 () {
        withMouse (cartPage ().getCheckout ()).click ();
        if (this.platformType == WEB) {
            navigate ().verifyUrl ()
                .isEqualTo (format ("{0}/checkout-step-one.html", URL));
            onElement (checkoutPage ().getTitle ()).verifyText ()
                .ignoringCase ()
                .isEqualTo ("CHECKOUT: YOUR INFORMATION");
        }

        onTextBox (checkoutPage ().getFirstName ()).enterText ("Wasiq");
        onTextBox (checkoutPage ().getLastName ()).enterText ("Bhamla");
        onTextBox (checkoutPage ().getZipCode ()).enterText ("12345");

        withMouse (checkoutPage ().getContinueButton ()).click ();
    }

    public void verifyCheckoutStep2 () {
        if (this.platformType != WEB) {
            withFinger (checkoutPage ().getFinish ()).swipeTill (UP);
        }
        withMouse (checkoutPage ().getFinish ()).click ();

        if (this.platformType != WEB) {
            onElement (checkoutPage ().getCompleteHeader ()).verifyText ()
                .isEqualTo ("THANK YOU FOR YOU ORDER");
        } else {
            navigate ().verifyUrl ()
                .isEqualTo (format ("{0}/checkout-complete.html", URL));
            onElement (checkoutPage ().getTitle ()).verifyText ()
                .ignoringCase ()
                .isEqualTo ("CHECKOUT: COMPLETE!");
            onElement (checkoutPage ().getCompleteHeader ()).verifyText ()
                .ignoringCase ()
                .contains ("THANK YOU FOR YOUR ORDER");
        }

        onElement (checkoutPage ().getCompleteText ()).verifyText ()
            .isEqualTo ("Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }

    public void verifyLogin (final String userName, final String password) {
        verifyNavigateToSite ();
        onTextBox (loginPage ().getUsername ()).enterText (userName);
        onTextBox (loginPage ().getPassword ()).enterText (password);
        if (this.platformType == ANDROID && onDevice ().isKeyboardVisible ()) {
            onAndroidDevice ().pressKey (BACK);
        }
        withMouse (loginPage ().getLoginButton ()).click ();
        verifyLoggedIn ();
    }

    public void verifySignOut () {
        withMouse (homePage ().getMenuButton ()).click ();
        withMouse (homePage ().getLogout ()).click ();
        if (this.platformType == WEB) {
            navigate ().verifyUrl ()
                .startsWith (URL);
        }
        onElement (loginPage ().getUsername ()).verifyIsDisplayed ()
            .isTrue ();
    }

    private void verifyLoggedIn () {
        if (this.platformType == WEB) {
            navigate ().verifyUrl ()
                .isEqualTo (format ("{0}/inventory.html", URL));
            onWindow ().verifyTitle ()
                .isEqualTo ("Swag Labs");
        }
        onElement (homePage ().getMenuButton ()).verifyIsDisplayed ()
            .isTrue ();
        onElement (homePage ().getMenuButton ()).verifyIsEnabled ()
            .isTrue ();
    }

    private void verifyNavigateToSite () {
        if (this.platformType == WEB) {
            navigate ().to (URL);
            navigate ().verifyUrl ()
                .startsWith (URL);
        }
    }

    private void verifyProductCartPage () {
        withMouse (homePage ().getShoppingCart ()).click ();
        if (this.platformType == WEB) {
            navigate ().verifyUrl ()
                .isEqualTo (format ("{0}/cart.html", URL));
        }
        onElement (cartPage ().getCheckout ()).verifyIsDisplayed ()
            .isTrue ();
    }

    private void verifyProductDetailPage () {
        withMouse (homePage ().productItem ("Sauce Labs Backpack")).click ();
        if (this.platformType == WEB) {
            navigate ().verifyUrl ()
                .startsWith (format ("{0}/inventory-item.html?id=", URL));
        }
        onElement (productDetailsPage ().getContainer ()).verifyIsDisplayed ()
            .isTrue ();
        if (this.platformType != WEB) {
            withFinger ().swipe (UP);
            withFinger ().swipe (DOWN);
            withFingers (productDetailsPage ().getImage ()).zoomIn ();
            withFingers (productDetailsPage ().getImage ()).zoomOut ();
        }
    }
}
