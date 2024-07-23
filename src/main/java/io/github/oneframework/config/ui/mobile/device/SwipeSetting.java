

package io.github.oneframework.config.ui.mobile.device;

import static io.github.oneframework.enums.Speed.FAST;

import io.github.oneframework.enums.Speed;
import lombok.Data;

/**
 * Swipe related settings
 *
 * @author Rahul Rana
 * @since 02-Jan-2023
 */
@Data
public class SwipeSetting {
    private int   distance           = 75;
    private int   maxSwipeUntilFound = 5;
    private Speed speed              = FAST;
}
