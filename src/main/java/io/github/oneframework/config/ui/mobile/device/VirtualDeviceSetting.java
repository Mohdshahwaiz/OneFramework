

package io.github.oneframework.config.ui.mobile.device;

import lombok.Data;

/**
 * Virtual device specific settings
 *
 * @author Rahul Rana
 * @since 13-Sept-2022
 */
@Data
public class VirtualDeviceSetting {
    private boolean connectKeyboard = true;
    private boolean headless        = false;
    private int     launchTimeout   = 120;
    private String  name;
    private int     readyTimeout    = 60;
}
