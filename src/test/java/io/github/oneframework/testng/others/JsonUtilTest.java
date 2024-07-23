

package io.github.oneframework.testng.others;

import static com.google.common.truth.Truth.assertWithMessage;
import static io.github.oneframework.utils.JsonUtil.fromFile;
import static java.lang.System.getProperty;

import java.nio.file.Path;

import io.github.oneframework.config.FrameworkSetting;
import io.github.oneframework.exception.FrameworkError;
import io.github.oneframework.utils.JsonUtil;
import org.testng.annotations.Test;

/**
 * @author Faisal Khatri
 * @since 8/22/2022
 */
public class JsonUtilTest {
    /**
     * This method verifies the Error when file is not found.
     */
    @Test (expectedExceptions = FrameworkError.class)
    public void testFromFile () {
        final var configPath = Path.of (getProperty ("user.dir"), "one-config.json")
            .toString ();
        fromFile (configPath, FrameworkSetting.class);
    }

    /**
     * This method verifies the output of JSON util toString() method.
     */
    @Test
    public void testToString () {
        assertWithMessage ("JsonUtil").that (JsonUtil.toString ("Created"))
            .isEqualTo ("Created");
    }
}
