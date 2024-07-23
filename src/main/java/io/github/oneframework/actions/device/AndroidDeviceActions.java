

package io.github.oneframework.actions.device;

import static io.github.oneframework.actions.CommonActions.performDriverAction;
import static io.github.oneframework.enums.ListenerType.ANDROID_DEVICE_ACTION;
import static io.github.oneframework.enums.Message.ACTION_NOT_SUPPORTED_ON_PLATFORM;
import static io.github.oneframework.enums.PlatformType.ANDROID;
import static io.github.oneframework.manager.ParallelSession.getSession;
import static io.github.oneframework.utils.ErrorHandler.throwError;
import static java.util.Optional.ofNullable;
import static org.apache.logging.log4j.LogManager.getLogger;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.github.oneframework.actions.interfaces.device.IAndroidDeviceActions;
import io.github.oneframework.actions.interfaces.listeners.device.IAndroidDeviceActionsListener;
import org.apache.logging.log4j.Logger;

/**
 * Handles all Android device specific actions.
 *
 * @author Rahul Rana
 * @since 06-Jun-2023
 */
public class AndroidDeviceActions extends DeviceActions implements IAndroidDeviceActions {
    private static final IAndroidDeviceActions DEVICE_ACTIONS = new AndroidDeviceActions ();
    private static final Logger                LOGGER         = getLogger ();

    /**
     * Handles Android device specific actions.
     *
     * @return {@link IAndroidDeviceActions} instance
     */
    public static IAndroidDeviceActions onAndroidDevice () {
        return DEVICE_ACTIONS;
    }

    private final IAndroidDeviceActionsListener listener;

    private AndroidDeviceActions () {
        this.listener = getSession ().getListener (ANDROID_DEVICE_ACTION);
    }

    @Override
    public void pressKey (final AndroidKey key) {
        LOGGER.traceEntry ();
        final var platform = getSession ().getPlatformType ();
        if (platform != ANDROID) {
            throwError (ACTION_NOT_SUPPORTED_ON_PLATFORM, "Press key", platform);
        }
        LOGGER.info ("Pressing key [{}] on Android device...", key);
        ofNullable (this.listener).ifPresent (l -> l.onPressKey (key));
        performDriverAction ((AndroidDriver d) -> d.pressKey (new KeyEvent ().withKey (key)));
        LOGGER.traceExit ();
    }
}
