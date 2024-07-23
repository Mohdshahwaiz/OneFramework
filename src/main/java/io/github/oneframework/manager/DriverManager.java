

package io.github.oneframework.manager;

import static io.github.oneframework.manager.ParallelSession.getSession;
import static java.time.Duration.ofSeconds;
import static org.apache.logging.log4j.LogManager.getLogger;

import io.github.oneframework.config.ui.TimeoutSetting;
import io.github.oneframework.config.ui.mobile.server.ServerSetting;
import io.github.oneframework.enums.ApplicationType;
import io.github.oneframework.enums.PlatformType;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Rahul Rana
 * @since 17-Feb-2022
 */
final class DriverManager {
    private static final Logger LOGGER = getLogger ();

    private final PlatformType platformType;

    DriverManager () {
        LOGGER.traceEntry ();
        this.platformType = getSession ().getPlatformType ();
        LOGGER.traceExit ();
    }

    void setupDriver () {
        LOGGER.traceEntry ();
        final var settings = getSession ().getSetting ()
            .getUi ();
        if (this.platformType != PlatformType.WEB) {
            final var mobileSetting = getSession ().getMobileSetting ();
            setupAppiumServer (mobileSetting.getServer ());
        }
        final IDriverManager driverManager = switch (this.platformType) {
            case WEB -> new WebDriverManager ();
            case ANDROID -> new AndroidManager ();
            default -> new IOSManager ();
        };
        driverManager.setupDriver ();
        setDriverWaits (settings.getTimeout ());
        LOGGER.traceExit ();
    }

    private void setDriverWaits (final TimeoutSetting timeoutSetting) {
        LOGGER.traceEntry ();
        final var session = getSession ();
        final var driver = session.getDriver ();
        final var timeouts = driver.manage ()
            .timeouts ();
        timeouts.implicitlyWait (ofSeconds (timeoutSetting.getImplicitWait ()));
        if (this.platformType == PlatformType.WEB || session.getMobileSetting ()
            .getDevice ()
            .getApplication ()
            .getType () == ApplicationType.WEB) {
            timeouts.pageLoadTimeout (ofSeconds (timeoutSetting.getPageLoadTimeout ()));
            timeouts.scriptTimeout (ofSeconds (timeoutSetting.getScriptTimeout ()));
        }
        session.setWait (new WebDriverWait (driver, ofSeconds (timeoutSetting.getExplicitWait ())));
        LOGGER.traceExit ();
    }

    private void setupAppiumServer (final ServerSetting serverSetting) {
        getSession ().setServiceManager (new ServiceManager (serverSetting));
        getSession ().getServiceManager ()
            .startServer ();
    }
}