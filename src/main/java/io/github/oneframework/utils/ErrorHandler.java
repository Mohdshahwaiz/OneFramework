

package io.github.oneframework.utils;

import static java.text.MessageFormat.format;
import static java.util.Objects.isNull;
import static org.apache.logging.log4j.LogManager.getLogger;

import java.util.ArrayList;

import io.github.oneframework.enums.Message;
import io.github.oneframework.exception.FrameworkError;
import org.apache.logging.log4j.Logger;

/**
 * Error handler utility class.
 *
 * @author Rahul Rana
 * @since 24-Jul-2022
 */
public final class ErrorHandler {
    private static final Logger LOGGER = getLogger ();

    /**
     * Handles the exceptions, prints the stack trace and throws wrapped Error.
     *
     * @param message Error message.
     * @param cause Error cause.
     * @param args Error message arguments.
     */
    public static void handleAndThrow (final Message message, final Throwable cause, final Object... args) {
        var throwable = cause;
        final var stack = new ArrayList<> ();
        stack.add (format ("Error occurred: ({0})", throwable.getClass ()
            .getName ()));
        final var stackTrace = "\tat {0}: {1} Line Number: {2}";
        do {
            if (stack.size () > 1) {
                stack.add (format ("Caused by: ({0})", throwable.getClass ()));
            }
            stack.add (format ("Message: {0}", throwable.getMessage ()));
            for (final var trace : cause.getStackTrace ()) {
                stack.add (format (stackTrace, trace.getClassName (), trace.getMethodName (), trace.getLineNumber ()));
            }
            throwable = throwable.getCause ();
        } while (!isNull (throwable));
        stack.forEach (LOGGER::error);
        throw new FrameworkError (format (message.getMessageText (), args), cause);
    }

    /**
     * Throws framework error with provided message.
     *
     * @param message Error message
     * @param args message args
     */
    public static void throwError (final Message message, final Object... args) {
        final var messageText = format (message.getMessageText (), args);
        LOGGER.error (messageText);
        throw new FrameworkError (messageText);
    }

    private ErrorHandler () {
        // Utility class.
    }
}
