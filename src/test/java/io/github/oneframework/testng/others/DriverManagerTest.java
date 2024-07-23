

package io.github.oneframework.testng.others;

import static io.github.oneframework.enums.PlatformType.WEB;
import static io.github.oneframework.manager.ParallelSession.clearSession;
import static io.github.oneframework.manager.ParallelSession.createSession;

import io.github.oneframework.exception.FrameworkError;
import org.testng.annotations.Test;

/**
 * Test class for testing Driver manager class.
 *
 * @author Rahul Rana
 * @since 29-Jul-2022
 */
public class DriverManagerTest {
    private static final String PERSONA = "DriverManagerTest";

    /**
     * Test method to verify empty browser in config.
     */
    @Test (description = "Test Web empty browser in config", expectedExceptions = FrameworkError.class, expectedExceptionsMessageRegExp = "Browser type cannot be empty in the config...")
    public void testEmptyBrowserInConfig () {
        try {
            createSession (PERSONA, WEB, "test_local_empty_browser");
        } finally {
            clearSession ();
        }
    }

    /**
     * Test method to verify invalid config key.
     */
    @Test (description = "Test Web invalid config key", expectedExceptions = FrameworkError.class)
    public void testInvalidWebConfigKey () {
        try {
            createSession (PERSONA, WEB, "test_lambda_test_no_pa");
        } finally {
            clearSession ();
        }
    }

    /**
     * Test method to verify none browser.
     */
    @Test (description = "Test None Browser", expectedExceptions = FrameworkError.class, expectedExceptionsMessageRegExp = "NONE Browser type is not allowed for Web platform...")
    public void testNoneBrowser () {
        try {
            createSession (PERSONA, WEB, "test_local_none_browser");
        } finally {
            clearSession ();
        }
    }

    /**
     * Test method to verify empty browser in config.
     */
    @Test (description = "Test Web null browser in config", expectedExceptions = FrameworkError.class, expectedExceptionsMessageRegExp = "NONE Browser type is not allowed for Web platform...")
    public void testNullBrowserInConfig () {
        try {
            createSession (PERSONA, WEB, "test_local_null_browser");
        } finally {
            clearSession ();
        }
    }

    /**
     * Test method to verify null cloud Host.
     */
    @Test (description = "Test Null cloud Host", expectedExceptions = FrameworkError.class, expectedExceptionsMessageRegExp = "Host name is required for remote driver execution...")
    public void testNullCloudHost () {
        try {
            createSession (PERSONA, WEB, "test_lambda_test_no_host");
        } finally {
            clearSession ();
        }
    }

    /**
     * Test method to verify null cloud password.
     */
    @Test (description = "Test Null cloud password", expectedExceptions = FrameworkError.class, expectedExceptionsMessageRegExp = "Password is required for cloud execution...")
    public void testNullCloudPassword () {
        try {
            createSession (PERSONA, WEB, "test_lambda_test_no_password");
        } finally {
            clearSession ();
        }
    }

    /**
     * Test method to verify null cloud username.
     */
    @Test (description = "Test Null cloud username", expectedExceptions = FrameworkError.class, expectedExceptionsMessageRegExp = "User name is required for cloud execution...")
    public void testNullCloudUsername () {
        try {
            createSession (PERSONA, WEB, "test_lambda_test_no_username");
        } finally {
            clearSession ();
        }
    }
}
