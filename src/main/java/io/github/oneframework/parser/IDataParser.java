

package io.github.oneframework.parser;

import java.util.List;

/**
 * Process data from different sources.
 *
 * @author Rahul Rana
 * @since 28-Nov-2023
 */
public interface IDataParser {
    /**
     * Parse data from source to class object.
     *
     * @param fileName Test data file name
     * @param blockName Test data block name
     * @param dataType Class data type.
     * @param <T> Type of data.
     *
     * @return Data object.
     */
    <T> List<T> parse (String fileName, String blockName, Class<T> dataType);

    /**
     * Parse data from source and get list of data.
     *
     * @param fileName Test data file name
     * @param blockName Test data block name
     *
     * @return List of test data.
     */
    List<Object[]> parse (String fileName, String blockName);
}
