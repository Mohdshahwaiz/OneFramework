

package io.github.oneframework.config.ui;

import lombok.Data;

/**
 * Playback setting.
 *
 * @author Rahul Rana
 * @since 17-Feb-2022
 */
@Data
public class TimeoutSetting {
    private int explicitWait    = 10;
    private int highlightDelay  = 100;
    private int implicitWait    = 1;
    private int pageLoadTimeout = 30;
    private int scriptTimeout   = 10;
}
