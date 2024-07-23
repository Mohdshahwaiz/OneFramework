

package io.github.oneframework.config.ui;

import java.util.List;

import lombok.Data;

/**
 * Appium server log settings.
 *
 * @author Rahul Rana
 * @since 07-Sept-2022
 */
@Data
public class LogSetting {
    private boolean      enable = true;
    private List<String> excludeLogs;
    private String       path   = "./logs";
}
