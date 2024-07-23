

package io.github.oneframework.config.ui.mobile.device;

import static io.github.oneframework.enums.ApplicationType.NATIVE;

import io.github.oneframework.enums.ApplicationType;
import io.github.oneframework.enums.Browser;
import lombok.Data;

/**
 * Application specific settings.
 *
 * @author Rahul Rana
 * @since 13-Sept-2022
 */
@Data
public class ApplicationSetting {
    private String          baseUrl;
    private Browser         browser;
    private String          bundleId;
    private int             chromeDriverPort;
    private boolean         external;
    private int             installTimeout = 30;
    private String          path;
    private ApplicationType type           = NATIVE;
    private String          waitActivity;
    private int             waitTimeout    = 30;
}
