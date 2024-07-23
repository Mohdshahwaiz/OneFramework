

package io.github.oneframework.utils;

import static io.github.oneframework.enums.Message.CONFIG_KEY_NOT_FOUND;
import static io.github.oneframework.utils.JsonUtil.fromFile;
import static java.lang.String.join;
import static java.lang.System.getProperty;
import static java.lang.System.getenv;
import static java.util.Objects.isNull;
import static java.util.Optional.ofNullable;
import static org.apache.logging.log4j.LogManager.getLogger;

import java.nio.file.Path;
import java.util.Map;

import io.github.oneframework.config.FrameworkSetting;
import org.apache.logging.log4j.Logger;

/**
 * Utility class to ready config JSON file.
 *
 * @author Rahul Rana
 * @since 17-Feb-2022
 */
public final class SettingUtils {
    private static final Logger LOGGER = getLogger ();

    private static FrameworkSetting frameworkSetting;

    /**
     * Gets the settings object from Map.
     *
     * @param settings Settings Map
     * @param key Setting key
     * @param <T> Setting object type
     *
     * @return Setting object
     */
    public static <T> T getSetting (final Map<String, T> settings, final String key) {
        LOGGER.traceEntry ("Key: {}", key);
        if (!settings.containsKey (key)) {
            final var keys = join (", ", settings.keySet ());
            ErrorHandler.throwError (CONFIG_KEY_NOT_FOUND, key, keys);
        }
        return LOGGER.traceExit (settings.get (key));
    }

    /**
     * Loads the config JSON file only once.
     *
     * @return {@link FrameworkSetting}
     */
    public static FrameworkSetting loadSetting () {
        LOGGER.traceEntry ();
        if (isNull (frameworkSetting)) {
            final var defaultPath = Path.of (getProperty ("user.dir"), "src/test/resources")
                .toString ();
            final var configDirectory = ofNullable (getenv ("ONE_CONFIG_PATH")).orElse (
                ofNullable (getProperty ("one.config.path")).orElse (defaultPath));
            final var configPath = Path.of (configDirectory, "one-config.json")
                .toString ();
            frameworkSetting = fromFile (configPath, FrameworkSetting.class);
        }
        return LOGGER.traceExit (frameworkSetting);
    }

    private SettingUtils () {
        // Util class
    }
}
