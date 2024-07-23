

package io.github.oneframework.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * UI execution speed.
 *
 * @author Rahul Rana
 * @since 27-Mar-2024
 */
@AllArgsConstructor
@Getter
public enum Speed {
    /**
     * Fast speed with no delay.
     */
    FAST (100),
    /**
     * Normal means, with delay of 200ms between each action.
     */
    NORMAL (500),
    /**
     * Slow means, with delay of 500ms between each action.
     */
    SLOW (1000);

    private final int delay;
}
