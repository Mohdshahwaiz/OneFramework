

package io.github.oneframework.enums;

import java.util.Arrays;

import io.github.oneframework.actions.interfaces.listeners.BoykaListener;
import io.github.oneframework.actions.interfaces.listeners.api.IApiActionsListener;
import io.github.oneframework.actions.interfaces.listeners.data.ITestDataActionsListener;
import io.github.oneframework.actions.interfaces.listeners.device.IAndroidDeviceActionsListener;
import io.github.oneframework.actions.interfaces.listeners.device.IDeviceActionsListener;
import io.github.oneframework.actions.interfaces.listeners.drivers.IAlertActionsListener;
import io.github.oneframework.actions.interfaces.listeners.drivers.IContextActionsListener;
import io.github.oneframework.actions.interfaces.listeners.drivers.ICookieActionsListener;
import io.github.oneframework.actions.interfaces.listeners.drivers.IDriverActionsListener;
import io.github.oneframework.actions.interfaces.listeners.drivers.IFrameActionsListener;
import io.github.oneframework.actions.interfaces.listeners.drivers.INavigateActionsListener;
import io.github.oneframework.actions.interfaces.listeners.drivers.IWindowActionsListener;
import io.github.oneframework.actions.interfaces.listeners.elements.IClickableActionsListener;
import io.github.oneframework.actions.interfaces.listeners.elements.IDropDownActionsListener;
import io.github.oneframework.actions.interfaces.listeners.elements.IElementActionsListener;
import io.github.oneframework.actions.interfaces.listeners.elements.IFingerActionsListener;
import io.github.oneframework.actions.interfaces.listeners.elements.IFingersActionsListener;
import io.github.oneframework.actions.interfaces.listeners.elements.ITextBoxActionsListener;
import lombok.Getter;

/**
 * List all the available listener types in the framework.
 *
 * @author Rahul Rana
 * @since 07-Apr-2023
 */
@Getter
public enum ListenerType {
    /**
     * Alert Actions listener.
     */
    ALERT_ACTION (IAlertActionsListener.class),
    /**
     * Android device action listener.
     */
    ANDROID_DEVICE_ACTION (IAndroidDeviceActionsListener.class),
    /**
     * API actions listener.
     */
    API_ACTION (IApiActionsListener.class),
    /**
     * Mouse actions listener.
     */
    CLICKABLE_ACTION (IClickableActionsListener.class),
    /**
     * Context actions listener.
     */
    CONTEXT_ACTION (IContextActionsListener.class),
    /**
     * Cookies action listener.
     */
    COOKIE_ACTION (ICookieActionsListener.class),
    /**
     * Device action listener.
     */
    DEVICE_ACTION (IDeviceActionsListener.class),
    /**
     * Driver action listener.
     */
    DRIVER_ACTION (IDriverActionsListener.class),
    /**
     * Drop down action listener.
     */
    DROP_DOWN_ACTION (IDropDownActionsListener.class),
    /**
     * Element action listener.
     */
    ELEMENT_ACTION (IElementActionsListener.class),
    /**
     * Fingers action listener.
     */
    FINGERS_ACTION (IFingersActionsListener.class),
    /**
     * Finger action listener.
     */
    FINGER_ACTION (IFingerActionsListener.class),
    /**
     * Frame action listener.
     */
    FRAME_ACTION (IFrameActionsListener.class),
    /**
     * Navigate action listener.
     */
    NAVIGATE_ACTION (INavigateActionsListener.class),
    /**
     * Test data action listener.
     */
    TEST_DATA_ACTION (ITestDataActionsListener.class),
    /**
     * Text Box action listener.
     */
    TEXT_BOX_ACTION (ITextBoxActionsListener.class),
    /**
     * Window action listener.
     */
    WINDOW_ACTION (IWindowActionsListener.class);

    /**
     * Convert provided listener class to Listener type enum.
     *
     * @param className Class name of probable listener interface
     *
     * @return Listener type item.
     */
    public static ListenerType valueOf (final Class<?> className) {
        return Arrays.stream (values ())
            .filter (l -> l.getClassName ()
                .equals (className))
            .findFirst ()
            .orElse (null);
    }

    private final Class<? extends BoykaListener> className;

    ListenerType (final Class<? extends BoykaListener> className) {
        this.className = className;
    }
}
