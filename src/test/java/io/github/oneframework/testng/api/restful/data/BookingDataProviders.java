

package io.github.oneframework.testng.api.restful.data;

import static io.github.oneframework.actions.data.TestDataAction.withData;

import java.util.Iterator;

import io.github.oneframework.actions.interfaces.data.ITestDataAction;
import io.github.oneframework.testng.api.restful.pojo.BookingTestData;
import org.testng.annotations.DataProvider;

/**
 * Contains Data providers for the Tests
 *
 * @author Rahul Rana
 * @since 23-Feb-2024
 */
public final class BookingDataProviders {
    private static final ITestDataAction DATA;

    static {
        DATA = withData ("BookingData").inBlock ("Bookings");
    }

    @DataProvider
    public static Iterator<Object[]> getBookingData () {
        final var rows = DATA.rows ();
        return rows.stream ()
            .map (d -> new Object[] { d })
            .toList ()
            .iterator ();
    }

    @DataProvider
    public static Iterator<Object[]> getBookingDataObject () {
        final var rows = DATA.get (BookingTestData.class);
        return rows.stream ()
            .map (d -> new Object[] { d })
            .toList ()
            .iterator ();
    }

    private BookingDataProviders () {
        // Utility Class.
    }
}
