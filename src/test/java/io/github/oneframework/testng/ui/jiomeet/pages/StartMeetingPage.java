

package io.github.oneframework.testng.ui.jiomeet.pages;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;

import io.github.oneframework.builders.Locator;
import lombok.Getter;

@Getter
public class StartMeetingPage {
    private static final StartMeetingPage START_MEETING_PAGE = new StartMeetingPage ();

    public static StartMeetingPage startMeetingPage () {
        return START_MEETING_PAGE;
    }

    private final Locator oneTimeID = Locator.buildLocator ()
        .name ("One Time Meeting ID")
        .web (id ("dynamic"))
        .build ();
    private final Locator start     = Locator.buildLocator ()
        .name ("Start Button")
        .web (cssSelector ("button[type=\"button\"]"))
        .build ();

    private StartMeetingPage () {
        // Utility class.
    }
}
