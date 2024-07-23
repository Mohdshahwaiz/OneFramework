

package io.github.oneframework.testng.others;

import static io.github.oneframework.enums.Message.TEST_ERROR;

import java.io.IOException;

import io.github.oneframework.exception.FrameworkError;
import io.github.oneframework.utils.ErrorHandler;
import org.testng.annotations.Test;

/**
 * Error handling test.
 *
 * @author Rahul Rana
 * @since 28-Jul-2022
 */
public class ErrorHandlingTest {
    /**
     * Test error handling.
     */
    @Test (expectedExceptions = FrameworkError.class, expectedExceptionsMessageRegExp = "Test error...")
    public void testFrameworkError () {
        ErrorHandler.handleAndThrow (TEST_ERROR, new IOException ("File not found"));
    }
}
