

package io.github.oneframework.testng.others;

import static io.github.oneframework.manager.ParallelSession.clearSession;
import static io.github.oneframework.manager.ParallelSession.createSession;

import io.github.oneframework.actions.drivers.NavigateActions;
import io.github.oneframework.enums.PlatformType;
import io.github.oneframework.exception.FrameworkError;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Test class for testing browser navigation class.
 *
 * @author Rahul Rana
 * @since 04-Jan-2024
 */
public class NavigationTest {
    /**
     * Setup test class.
     */
    @BeforeClass
    public void setupClass () {
        createSession (PlatformType.WEB, "test_chrome_no_base_url");
    }

    /**
     * Teardown test class.
     */
    @AfterClass
    public void teardownClass () {
        clearSession ();
    }

    /**
     * Test Empty base URL in config.
     */
    @Test (description = "Test Empty base URL in config", expectedExceptions = FrameworkError.class, expectedExceptionsMessageRegExp = "Base URL is not provided in the config...")
    public void testEmptyBrowserInConfig () {
        NavigateActions.navigate ()
            .toBaseUrl ();
    }
}
