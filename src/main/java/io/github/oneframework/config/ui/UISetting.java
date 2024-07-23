

package io.github.oneframework.config.ui;

import static io.github.oneframework.utils.SettingUtils.getSetting;

import java.util.Map;

import io.github.oneframework.config.ui.mobile.MobileSetting;
import io.github.oneframework.config.ui.web.WebSetting;
import lombok.Data;

/**
 * @author Rahul Rana
 * @since 17-Feb-2022
 */
@Data
public class UISetting {
    private DelaySetting               delay      = new DelaySetting ();
    private LogSetting                 logging    = new LogSetting ();
    private Map<String, MobileSetting> mobile;
    private ScreenshotSetting          screenshot = new ScreenshotSetting ();
    private TimeoutSetting             timeout    = new TimeoutSetting ();
    private Map<String, WebSetting>    web;

    /**
     * Get Mobile settings.
     *
     * @param key config key for mobile
     *
     * @return the {@link MobileSetting}
     */
    public MobileSetting getMobileSetting (final String key) {
        return getSetting (this.mobile, key);
    }

    /**
     * Gets the web setting.
     *
     * @param key the config key for Web
     *
     * @return the {@link WebSetting}
     */
    public WebSetting getWebSetting (final String key) {
        return getSetting (this.web, key);
    }
}
