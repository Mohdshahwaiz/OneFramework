

package io.github.oneframework.actions.drivers;

import static com.google.common.truth.Truth.assertWithMessage;
import static io.github.oneframework.actions.CommonActions.getDriverAttribute;
import static io.github.oneframework.enums.ListenerType.ALERT_ACTION;
import static io.github.oneframework.manager.ParallelSession.getSession;
import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.logging.log4j.LogManager.getLogger;

import com.google.common.truth.StringSubject;
import io.github.oneframework.actions.interfaces.drivers.IAlertActions;
import io.github.oneframework.actions.interfaces.listeners.drivers.IAlertActionsListener;
import org.apache.logging.log4j.Logger;

/**
 * All Alert related actions
 *
 * @author Rahul Rana
 * @since 16-Feb-2023
 */
public class AlertActions implements IAlertActions {
    private static final IAlertActions ALERT_ACTIONS = new AlertActions ();
    private static final Logger        LOGGER        = getLogger ();

    /**
     * Handle all Alert related actions
     *
     * @return {@link IAlertActions} instance object
     */
    public static IAlertActions onAlert () {
        return ALERT_ACTIONS;
    }

    private final IAlertActionsListener listener;

    private AlertActions () {
        this.listener = getSession ().getListener (ALERT_ACTION);
    }

    @Override
    public String accept (final String text) {
        LOGGER.traceEntry ();
        return getDriverAttribute (driver -> {
            final var alert = driver.switchTo ()
                .alert ();
            final var message = alert.getText ();
            alert.sendKeys (text);
            alert.accept ();
            ofNullable (this.listener).ifPresent (l -> l.onAccept (text));
            return message;
        }, EMPTY);
    }

    @Override
    public String accept () {
        LOGGER.traceEntry ();
        return getDriverAttribute (driver -> {
            final var alert = driver.switchTo ()
                .alert ();
            final var message = alert.getText ();
            alert.accept ();
            ofNullable (this.listener).ifPresent (IAlertActionsListener::onAccept);
            return message;
        }, EMPTY);
    }

    @Override
    public String dismiss () {
        LOGGER.traceEntry ();
        return getDriverAttribute (driver -> {
            final var alert = driver.switchTo ()
                .alert ();
            final var message = alert.getText ();
            alert.dismiss ();
            ofNullable (this.listener).ifPresent (IAlertActionsListener::onDismiss);
            return message;
        }, EMPTY);
    }

    @Override
    public StringSubject verifyAccept () {
        LOGGER.traceEntry ();
        LOGGER.info ("Verifying accept alert");
        LOGGER.traceExit ();
        ofNullable (this.listener).ifPresent (IAlertActionsListener::onVerifyAccept);
        return assertWithMessage ("Accepted Alert").that (accept ());
    }

    @Override
    public StringSubject verifyAccept (final String text) {
        LOGGER.traceEntry ();
        LOGGER.info ("Verifying accept prompt");
        LOGGER.traceExit ();
        ofNullable (this.listener).ifPresent (l -> l.onVerifyAccept (text));
        return assertWithMessage ("Accepted Alert Prompt").that (accept (text));
    }

    @Override
    public StringSubject verifyDismiss () {
        LOGGER.traceEntry ();
        LOGGER.info ("Verifying alert message and dismissing the alert");
        LOGGER.traceExit ();
        ofNullable (this.listener).ifPresent (IAlertActionsListener::onVerifyDismiss);
        return assertWithMessage ("Dismissed Alert").that (dismiss ());
    }
}
