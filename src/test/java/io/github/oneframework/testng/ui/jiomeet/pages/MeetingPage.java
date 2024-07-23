

package io.github.oneframework.testng.ui.jiomeet.pages;

import static java.text.MessageFormat.format;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;

import io.github.oneframework.builders.Locator;
import lombok.Getter;

@Getter
public class MeetingPage {
    private static final MeetingPage MEETING_PAGE = new MeetingPage ();

    public static MeetingPage meetingPage () {
        return MEETING_PAGE;
    }

    private final Locator endCallButton = Locator.buildLocator ()
        .name ("End Call Button")
        .web (id ("endCallButton"))
        .build ();
    private final Locator endForAll     = Locator.buildLocator ()
        .name ("End for All")
        .web (cssSelector ("div.leave-dropdown div"))
        .filter (e -> e.getText ()
            .trim ()
            .equals ("End meeting for all"))
        .build ();
    private final Locator hostName      = Locator.buildLocator ()
        .name ("Host Name")
        .web (cssSelector ("div.participantName"))
        .build ();
    private final Locator meetingLink   = Locator.buildLocator ()
        .name ("Meeting Link")
        .web (cssSelector ("div.link-container span.link"))
        .build ();
    private final Locator participants  = Locator.buildLocator ()
        .name ("Show Participants")
        .web (id ("participants"))
        .build ();
    private final Locator skipButton    = Locator.buildLocator ()
        .name ("Skip Button")
        .web (id ("skipButton"))
        .build ();

    private MeetingPage () {
        // Utility class.
    }

    public Locator getCurrentParticipantName (final String name) {
        return Locator.buildLocator ()
            .name (format ("User [{0}]", name))
            .web (cssSelector (format ("div[title*=\"{0}\"]", name)))
            .build ();
    }
}
