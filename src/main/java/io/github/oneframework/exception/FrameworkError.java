

package io.github.oneframework.exception;

/**
 * Common Framework specific Error.
 *
 * @author Rahul Rana
 * @since 17-Feb-2022
 */
public class FrameworkError extends Error {
    /**
     * Framework Error with only message.
     *
     * @param message Error message
     */
    public FrameworkError (final String message) {
        super (message);
    }

    /**
     * Framework Error with message and cause.
     *
     * @param message Error message
     * @param cause Error cause
     */
    public FrameworkError (final String message, final Throwable cause) {
        super (message, cause);
    }
}
