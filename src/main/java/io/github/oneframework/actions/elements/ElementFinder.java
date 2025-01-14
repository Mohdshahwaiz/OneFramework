

package io.github.oneframework.actions.elements;

import static io.github.oneframework.enums.Message.ELEMENT_NOT_FOUND;
import static io.github.oneframework.manager.ParallelSession.getSession;
import static io.github.oneframework.utils.ErrorHandler.handleAndThrow;
import static io.github.oneframework.utils.ErrorHandler.throwError;
import static java.text.MessageFormat.format;
import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;
import static org.apache.logging.log4j.LogManager.getLogger;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import java.util.List;

import io.github.oneframework.builders.Locator;
import io.github.oneframework.enums.WaitStrategy;
import io.github.oneframework.exception.FrameworkError;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Finds element on UI.
 *
 * @author Rahul Rana
 * @since 24-Feb-2022
 */
public final class ElementFinder {
    private static final Logger LOGGER = getLogger ();

    /**
     * Find single element on UI.
     *
     * @param locator {@link Locator} to find element
     * @param waitStrategy {@link WaitStrategy} for finding the element
     *
     * @return {@link WebElement}
     */
    public static WebElement find (final Locator locator, final WaitStrategy waitStrategy) {
        LOGGER.traceEntry ();
        final var elements = finds (locator, waitStrategy);
        if (elements.isEmpty ()) {
            throwError (ELEMENT_NOT_FOUND, locator.getName (), getSession ().getPlatformType ());
        }
        if (!isNull (locator.getFilter ())) {
            return elements.stream ()
                .filter (locator.getFilter ())
                .findFirst ()
                .orElseThrow (() -> new FrameworkError (format (ELEMENT_NOT_FOUND.getMessageText (), locator.getName (),
                    getSession ().getPlatformType ())));
        }
        return elements.get (locator.getIndex ());
    }

    /**
     * Find all elements on UI.
     *
     * @param locator {@link Locator} to find elements
     * @param waitStrategy {@link WaitStrategy} for finding the element
     *
     * @return {@link List} of {@link WebElement}
     */
    public static List<WebElement> finds (final Locator locator, final WaitStrategy waitStrategy) {
        LOGGER.traceEntry ();
        final var driver = getSession ().getDriver ();
        final List<WebElement> elements;
        if (!isNull (locator.getParent ())) {
            final var parent = find (locator.getParent (), waitStrategy);
            elements = finds (driver, parent, locator);
        } else {
            waitForElement (locator, waitStrategy);
            elements = finds (driver, locator);
        }
        return LOGGER.traceExit (elements);
    }

    private static <D extends WebDriver> List<WebElement> finds (final D driver, final WebElement parent,
        final Locator locator) {
        LOGGER.traceEntry ();
        final var platformLocator = locator.getLocator ();
        if (isNull (platformLocator)) {
            throwError (ELEMENT_NOT_FOUND, locator.getName (), getSession ().getPlatformType ());
        }
        return LOGGER.traceExit (!isNull (parent)
                                 ? parent.findElements (locator.getLocator ())
                                 : driver.findElements (locator.getLocator ()));
    }

    private static <D extends WebDriver> List<WebElement> finds (final D driver, final Locator locator) {
        LOGGER.traceEntry ();
        return LOGGER.traceExit (finds (driver, null, locator));
    }

    private static void waitForElement (final Locator locator, final WaitStrategy waitStrategy) {
        try {
            final var wait = getSession ().getWait ();
            if (requireNonNull (waitStrategy, "Wait Strategy is null") == WaitStrategy.CLICKABLE) {
                wait.until (elementToBeClickable (locator.getLocator ()));
            } else {
                wait.until (visibilityOfElementLocated (locator.getLocator ()));
            }
        } catch (final TimeoutException e) {
            handleAndThrow (ELEMENT_NOT_FOUND, e, locator.getName (), getSession ().getPlatformType ());
        }
    }

    private ElementFinder () {
        // Intentionally left blank
    }
}
