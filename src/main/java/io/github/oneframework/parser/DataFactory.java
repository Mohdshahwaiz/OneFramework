

package io.github.oneframework.parser;

import static io.github.oneframework.manager.ParallelSession.getSession;

import io.github.oneframework.enums.TestDataSource;

/**
 * Test Data factory.
 *
 * @author Rahul Rana
 * @since 28-Nov-2023
 */
public final class DataFactory {
    /**
     * Get Test data parser.
     *
     * @return {@link IDataParser} instance.
     */
    public static IDataParser getParser () {
        final var setting = getSession ().getSetting ()
            .getData ();
        if (setting.getType () == TestDataSource.EXCEL) {
            return new ExcelParser ();
        }
        return null;
    }

    private DataFactory () {
        // Utility class.
    }
}
