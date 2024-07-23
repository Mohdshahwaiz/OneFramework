

package io.github.oneframework.config.ui.mobile.device;

import static io.appium.java_client.ios.IOSStartScreenRecordingOptions.VideoQuality.MEDIUM;

import io.appium.java_client.ios.IOSStartScreenRecordingOptions.VideoQuality;
import lombok.Data;

/**
 * iOS specific video recording settings.
 *
 * @author Rahul Rana
 * @since 16-Oct-2023
 */
@Data
public class IOSVideoSetting {
    private String       codec   = "mpeg4";
    private int          fps     = 10;
    private VideoQuality quality = MEDIUM;
}
