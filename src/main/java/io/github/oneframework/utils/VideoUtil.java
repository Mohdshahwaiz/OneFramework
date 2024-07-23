

package io.github.oneframework.utils;

import static io.github.oneframework.enums.Message.ERROR_SAVING_VIDEO;
import static io.github.oneframework.manager.ParallelSession.getSession;
import static java.text.MessageFormat.format;
import static org.apache.commons.io.FileUtils.writeByteArrayToFile;
import static org.apache.logging.log4j.LogManager.getLogger;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;

import io.github.oneframework.config.ui.mobile.device.VideoSetting;
import org.apache.logging.log4j.Logger;

/**
 * Video related util methods.
 *
 * @author Rahul Rana
 * @since 14-Oct-2023
 */
public final class VideoUtil {
    private static final Logger LOG = getLogger ();

    /**
     * Save Mobile video content to file.
     *
     * @param content Video content
     */
    public static void saveVideo (final String content) {
        final var decode = Base64.getDecoder ()
            .decode (content);
        final var setting = getSession ().getMobileSetting ()
            .getDevice ()
            .getVideo ();
        saveVideo (decode, setting);
    }

    private static void saveVideo (final byte[] decode, final VideoSetting setting) {
        try {
            final var path = setting.getPath ();
            final var prefix = setting.getPrefix ();
            final var date = new SimpleDateFormat ("yyyyMMdd-HHmmss");
            final var timeStamp = date.format (Calendar.getInstance ()
                .getTime ());
            final var fileName = format ("{0}/{1}-{2}.{3}", path, prefix, timeStamp, "mp4");
            LOG.info ("Saving video recording to [{}] path...", fileName);
            writeByteArrayToFile (new File (fileName), decode);
        } catch (final IOException e) {
            ErrorHandler.handleAndThrow (ERROR_SAVING_VIDEO, e);
        }
    }

    private VideoUtil () {
        // Util class.
    }
}
