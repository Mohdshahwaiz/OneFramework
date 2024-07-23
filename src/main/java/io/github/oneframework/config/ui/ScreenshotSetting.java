

package io.github.oneframework.config.ui;

import lombok.Data;

/**
 * Screenshot setting.
 *
 * @author Rahul Rana
 * @since 13-Jul-2022
 */
@Data
public class ScreenshotSetting {
    private boolean enabled   = false;
    private String  extension = "png";
    private String  path      = "./screenshots";
    private String  prefix    = "SCR";
}
