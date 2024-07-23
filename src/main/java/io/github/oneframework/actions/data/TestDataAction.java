

package io.github.oneframework.actions.data;

import static io.github.oneframework.enums.ListenerType.TEST_DATA_ACTION;
import static io.github.oneframework.manager.ParallelSession.getSession;
import static io.github.oneframework.parser.DataFactory.getParser;
import static io.github.oneframework.utils.Validator.checkIndex;
import static java.util.Objects.isNull;
import static java.util.Optional.ofNullable;
import static org.apache.logging.log4j.LogManager.getLogger;

import java.util.List;

import io.github.oneframework.actions.interfaces.data.IDataRow;
import io.github.oneframework.actions.interfaces.data.ITestDataAction;
import io.github.oneframework.actions.interfaces.listeners.data.ITestDataActionsListener;
import io.github.oneframework.parser.IDataParser;
import org.apache.logging.log4j.Logger;

/**
 * Handle test data from different data source.
 *
 * @author Rahul Rana
 * @since 19-Nov-2023
 */
public class TestDataAction implements ITestDataAction {
    private static final Logger LOGGER = getLogger ();

    /**
     * Handle test data.
     *
     * @param fileName Test data file name.
     *
     * @return {@link ITestDataAction} instance.
     */
    public static ITestDataAction withData (final String fileName) {
        return new TestDataAction (fileName);
    }

    private       String                   blockName;
    private       List<Object[]>           dataRow;
    private final String                   fileName;
    private       Object[]                 headers;
    private final ITestDataActionsListener listener;
    private final IDataParser              parser;

    private TestDataAction (final String fileName) {
        this.fileName = fileName;
        this.listener = getSession ().getListener (TEST_DATA_ACTION);
        this.parser = getParser ();
    }

    @Override
    public <T> List<T> get (final Class<T> dataClass) {
        LOGGER.info ("Getting list of Test data object...");
        ofNullable (this.listener).ifPresent (d -> d.onGet (dataClass));
        return this.parser.parse (this.fileName, this.blockName, dataClass);
    }

    @Override
    public ITestDataAction inBlock (final String blockName) {
        this.blockName = blockName;
        return this;
    }

    @Override
    public IDataRow row (final int index) {
        LOGGER.info ("Getting Test data row at [{}] index...", index);
        ofNullable (this.listener).ifPresent (d -> d.onRow (index));
        final var rows = rows ();
        checkIndex (index, rows.size ());
        return rows.get (index);
    }

    @Override
    public List<IDataRow> rows () {
        LOGGER.info ("Getting all Test data rows...");
        ofNullable (this.listener).ifPresent (ITestDataActionsListener::onRows);
        if (isNull (this.dataRow) || this.dataRow.isEmpty ()) {
            this.dataRow = this.parser.parse (this.fileName, this.blockName);
            this.headers = this.dataRow.remove (0);
        }
        return this.dataRow.stream ()
            .map (d -> (IDataRow) new DataRow (this.headers, d))
            .filter (d -> !d.isEmpty ())
            .toList ();
    }
}
