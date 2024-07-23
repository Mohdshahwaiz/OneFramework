

package io.github.oneframework.builders;

import static io.github.oneframework.manager.ParallelSession.getSession;

import java.util.function.Predicate;

import io.github.oneframework.enums.ApplicationType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * UI application locator.
 *
 * @author Rahul Rana
 * @since 25-Feb-2022
 */
@ToString
@Getter
@Builder (builderMethodName = "buildLocator")
public class Locator {
    private By                    android;
    private Predicate<WebElement> filter;
    private int                   index;
    private By                    ios;
    @NotNull
    private String                name;
    private Locator               parent;
    private By                    web;

    /**
     * Gets the platform specific locator
     *
     * @return Locator for the element
     */
    public By getLocator () {
        return switch (getSession ().getPlatformType ()) {
            case ANDROID -> getMobileOrWebLocator (this.android);
            case IOS -> getMobileOrWebLocator (this.ios);
            default -> this.web;
        };
    }

    private By getMobileOrWebLocator (final By locator) {
        if (getSession ().getMobileSetting ()
            .getDevice ()
            .getApplication ()
            .getType () == ApplicationType.WEB) {
            return this.web;
        }
        return locator;
    }
}
