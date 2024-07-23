

package io.github.oneframework.config.ui.mobile.device;

import static io.github.oneframework.enums.DeviceType.VIRTUAL;
import static io.github.oneframework.enums.OS.ANDROID;

import java.util.Map;

import io.github.oneframework.enums.DeviceType;
import io.github.oneframework.enums.OS;
import lombok.Data;

/**
 * Appium Device settings.
 *
 * @author Rahul Rana
 * @since 08-Sept-2022
 */
@Data
public class DeviceSetting {
    private boolean              acceptAlerts           = true;
    private int                  adbTimeout             = 30;
    private ApplicationSetting   application;
    private Map<String, Object>  capabilities;
    private boolean              clearFiles             = true;
    private boolean              clearLogs              = true;
    private boolean              fullReset;
    private boolean              ignoreUnimportantViews = true;
    private String               name;
    private boolean              noReset;
    private OS                   os                     = ANDROID;
    private int                  serverInstallTimeout   = 30;
    private int                  serverLaunchTimeout    = 30;
    private SwipeSetting         swipe                  = new SwipeSetting ();
    private int                  systemPort             = 8200;
    private DeviceType           type                   = VIRTUAL;
    private int                  typingSpeed            = 60;
    private String               uniqueId;
    private String               version;
    private VideoSetting         video                  = new VideoSetting ();
    private VirtualDeviceSetting virtualDevice          = new VirtualDeviceSetting ();
    private WDASetting           wda;
}
