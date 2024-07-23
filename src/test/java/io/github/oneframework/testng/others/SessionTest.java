

package io.github.oneframework.testng.others;

import static io.github.oneframework.manager.ParallelSession.clearAllSessions;
import static io.github.oneframework.manager.ParallelSession.clearSession;
import static io.github.oneframework.manager.ParallelSession.createSession;

import io.github.oneframework.enums.PlatformType;
import io.github.oneframework.exception.FrameworkError;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * Test class for testing Parallel Session class.
 *
 * @author Rahul Rana
 * @since 18-Oct-2023
 */
public class SessionTest {
    private static final String PERSONA = "SessionTest";

    /**
     * Clear any open sessions.
     */
    @AfterMethod
    public void teardownMethod () {
        clearAllSessions ();
    }

    /**
     * Test duplicate clear session.
     */
    @Test (description = "Test duplicate clear session", expectedExceptions = FrameworkError.class)
    public void testDuplicateClearSession () {
        createSession (PERSONA, PlatformType.WEB, "test_local_chrome");
        clearSession ();
        clearSession ();
    }

    /**
     * Test Duplicate Session creation.
     */
    @Test (description = "Test Duplicate Session creation", expectedExceptions = FrameworkError.class, expectedExceptionsMessageRegExp = "Session is already created for .SessionTest. persona...")
    public void testDuplicateSessionCreation () {
        createSession (PERSONA, PlatformType.WEB, "test_local_chrome");
        createSession (PERSONA, PlatformType.WEB, "test_local_chrome");
        clearSession ();
    }

    /**
     * Test session creation with Null persona.
     */
    @Test (description = "Test session creation with Null persona", expectedExceptions = FrameworkError.class, expectedExceptionsMessageRegExp = "Session Persona cannot be empty or null...")
    public void testSessionCreationWithNullPersona () {
        createSession (null, PlatformType.WEB, "test_local_chrome");
    }
}
