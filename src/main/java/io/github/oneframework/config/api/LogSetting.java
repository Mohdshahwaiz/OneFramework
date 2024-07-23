

package io.github.oneframework.config.api;

import lombok.Data;

/**
 * Appium server log settings.
 *
 * @author Rahul Rana
 * @since 07-Sept-2022
 */
@Data
public class LogSetting {
    private boolean enable   = true;
    private boolean request  = true;
    private boolean response = true;
}
