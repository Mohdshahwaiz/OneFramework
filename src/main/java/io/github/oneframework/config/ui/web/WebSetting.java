

package io.github.oneframework.config.ui.web;

import static io.github.oneframework.enums.Browser.NONE;
import static io.github.oneframework.enums.Protocol.HTTP;
import static io.github.oneframework.enums.TargetProviders.LOCAL;
import static io.github.oneframework.enums.WindowResizeType.NORMAL;
import static io.github.oneframework.utils.StringUtils.interpolate;

import java.util.List;
import java.util.Map;

import io.github.oneframework.enums.Browser;
import io.github.oneframework.enums.Protocol;
import io.github.oneframework.enums.TargetProviders;
import io.github.oneframework.enums.WindowResizeType;
import lombok.Data;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;

/**
 * Web settings.
 *
 * @author Rahul Rana
 * @since 24-Feb-2022
 */
@Data
public class WebSetting {
    private String              baseUrl;
    private Browser             browser          = NONE;
    private List<String>        browserOptions;
    private Map<String, Object> capabilities;
    private Dimension           customSize       = new Dimension (1920, 1080);
    private boolean             headless         = true;
    private boolean             highlight        = false;
    private String              host;
    private PageLoadStrategy    pageLoadStrategy = PageLoadStrategy.NORMAL;
    private String              password;
    private String              platform;
    private int                 port;
    private Protocol            protocol         = HTTP;
    private WindowResizeType    resize           = NORMAL;
    private TargetProviders     target           = LOCAL;
    private String              userName;
    private String              version          = "stable";

    /**
     * Gets cloud password.
     *
     * @return the cloud password
     */
    public String getPassword () {
        return interpolate (this.password);
    }

    /**
     * Gets cloud user name.
     *
     * @return the cloud username.
     */
    public String getUserName () {
        return interpolate (this.userName);
    }
}
