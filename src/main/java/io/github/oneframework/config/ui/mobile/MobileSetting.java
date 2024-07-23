

package io.github.oneframework.config.ui.mobile;

import io.github.oneframework.config.ui.mobile.device.DeviceSetting;
import io.github.oneframework.config.ui.mobile.server.ServerSetting;
import lombok.Data;

/**
 * Mobile settings.
 *
 * @author Rahul Rana
 * @since 06-Sept-2022
 */
@Data
public class MobileSetting {
    private DeviceSetting device = new DeviceSetting ();
    private ServerSetting server = new ServerSetting ();
}
