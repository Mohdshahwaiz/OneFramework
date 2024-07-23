

package io.github.oneframework.testng.ui.wdio.pages;

import static io.appium.java_client.AppiumBy.id;
import static io.github.oneframework.actions.elements.ElementActions.onElement;
import static io.github.oneframework.actions.elements.FingerActions.withFinger;
import static io.github.oneframework.manager.ParallelSession.getSession;

import io.github.oneframework.actions.drivers.AlertActions;
import io.github.oneframework.builders.Locator;
import io.github.oneframework.enums.PlatformType;
import lombok.Getter;

/**
 * Alert dialog pop-up.
 *
 * @author Rahul Rana
 * @since 21-Oct-2023
 */
@Getter
public class AlertDialog {
    private static final AlertDialog ALERT_DIALOG = new AlertDialog ();

    /**
     * Alert dialog pop-up instance.
     *
     * @return {@link AlertDialog}
     */
    public static AlertDialog alertDialog () {
        return ALERT_DIALOG;
    }

    private final Locator button1 = Locator.buildLocator ()
        .name ("Button 1")
        .android (id ("android:id/button1"))
        .build ();
    private final Locator message = Locator.buildLocator ()
        .name ("Message")
        .android (id ("android:id/message"))
        .build ();
    private final Locator title   = Locator.buildLocator ()
        .name ("Title")
        .android (id ("android:id/alertTitle"))
        .build ();

    private AlertDialog () {
        // Page class.
    }

    /**
     * Accepts pop-up and verify message.
     */
    public void verifyMessage (final String expectedMessage) {
        if (getSession ().getPlatformType () == PlatformType.ANDROID) {
            try {
                onElement (getMessage ()).verifyText ()
                    .isEqualTo (expectedMessage);
            } finally {
                withFinger (getButton1 ()).tap ();
            }
        } else {
            AlertActions.onAlert ()
                .verifyAccept (expectedMessage);
        }
    }
}
