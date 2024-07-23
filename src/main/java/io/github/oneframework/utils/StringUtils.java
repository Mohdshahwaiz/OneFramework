

package io.github.oneframework.utils;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static org.apache.commons.text.StringSubstitutor.createInterpolator;
import static org.apache.logging.log4j.LogManager.getLogger;

import java.util.Map;

import org.apache.commons.text.StringSubstitutor;
import org.apache.logging.log4j.Logger;

/**
 * String utils.
 *
 * @author Rahul Rana
 * @since 24-Feb-2022
 */
public final class StringUtils {
    private static final Logger LOGGER = getLogger ();

    /**
     * Replace all the variables in the given string with the values from the specified map.
     *
     * @param value String to be interpolated
     * @param valuesMap Map of values to lookup for variables
     *
     * @return Interpolated string
     */
    public static String interpolate (final String value, final Map<String, String> valuesMap) {
        LOGGER.traceEntry ("Interpolating string: {}", value);
        var result = value;
        if (value.contains ("${")) {
            final var substitute = new StringSubstitutor (valuesMap);
            substitute.setEnableSubstitutionInVariables (true);
            result = substitute.replace (value);
        }
        LOGGER.traceExit ();
        return result;
    }

    /**
     * Replace all variables in the given string with the values from system environment variables, system properties,
     * etc.
     *
     * @param value String to be interpolated
     *
     * @return Interpolated string
     */
    public static String interpolate (final String value) {
        LOGGER.traceEntry ("Interpolating string: {}", value);
        var result = value;
        if (isNotEmpty (value) && value.startsWith ("${")) {
            final var substitute = createInterpolator ();
            substitute.setEnableSubstitutionInVariables (true);
            result = substitute.replace (value);
        }
        LOGGER.traceExit ();
        return result;
    }

    private StringUtils () {
        // Utility class
    }
}
