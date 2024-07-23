

package io.github.oneframework.testng.ui.jiomeet.pages;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;

import io.github.oneframework.builders.Locator;
import lombok.Getter;

@Getter
public class GuestJoinPage {
    private static final GuestJoinPage GUEST_JOIN_PAGE = new GuestJoinPage ();

    public static GuestJoinPage guestJoinPage () {
        return GUEST_JOIN_PAGE;
    }

    private final Locator guestName = Locator.buildLocator ()
        .name ("Guest Name")
        .web (id ("name"))
        .build ();

    private final Locator joinButton = Locator.buildLocator ()
        .name ("Join Button")
        .web (cssSelector ("button[type=\"submit\"]"))
        .build ();

    private GuestJoinPage () {
        // Utility class.
    }
}
