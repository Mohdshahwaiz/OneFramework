

package io.github.oneframework.config.ui.mobile.server;

import io.github.oneframework.enums.LogLevel;
import lombok.Data;

/**
 * Mobile logging settings.
 *
 * @author Rahul Rana
 * @since 21-Sept-2023
 */
@Data
public class LogSetting {
    private boolean  debugSpacing;
    private LogLevel level = LogLevel.INFO;
    private boolean  localTimezone;
    private boolean  timestamp;
}
