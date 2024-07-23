

package io.github.oneframework.enums;

import static io.github.oneframework.enums.Protocol.HTTP;
import static io.github.oneframework.enums.Protocol.HTTPS;
import static org.apache.commons.lang3.StringUtils.EMPTY;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Supported cloud providers.
 *
 * @author Rahul Rana
 * @since 24-Feb-2022
 */
@Getter
@AllArgsConstructor
public enum TargetProviders {
    /**
     * BrowserStack.
     */
    SAUCE_LAB ("ondemand.eu-central-1.saucelabs.com", "sauce", HTTPS),
    /**
     * BrowserStack.
     */
    BROWSER_STACK ("hub-cloud.browserstack.com", "bstack", HTTPS),
    /**
     * Lambda Test for Mobile.
     */
    LAMBDA_TEST_MOBILE ("mobile-hub.lambdatest.com", "lt", HTTPS),
    /**
     * Lambda Test for Web.
     */
    LAMBDA_TEST_WEB ("hub.lambdatest.com", "lt", HTTPS),
    /**
     * None.
     */
    LOCAL ("127.0.0.1", EMPTY, HTTP);

    private final String   host;
    private final String   prefix;
    private final Protocol protocol;
}
