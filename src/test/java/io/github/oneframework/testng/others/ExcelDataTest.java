

package io.github.oneframework.testng.others;

import static com.google.common.truth.Truth.assertWithMessage;
import static io.github.oneframework.actions.data.TestDataAction.withData;

import org.testng.annotations.Test;

/**
 * Test excel data handling.
 *
 * @author Rahul Rana
 * @since 7-Dec-2023
 */
public class ExcelDataTest {
    /**
     * Test if all the data from Excel sheet is read correctly.
     */
    @Test
    public void testExcelData () {
        final String bookingFirstName = withData ("TestData").inBlock ("Bookings")
            .row (0)
            .cell ("FirstName");
        assertWithMessage ("Booking First Name").that (bookingFirstName)
            .isEqualTo ("Wasiq");

        final String employeeFirstName = withData ("TestData").inBlock ("Employees")
            .row (0)
            .cell ("FirstName");
        assertWithMessage ("Employee Rows Count").that (employeeFirstName)
            .isEqualTo ("Wasiq");
    }

    /**
     * Test if all the data from Excel sheet row is read correctly.
     */
    @Test
    public void testExcelDataColumnCount () {
        final var bookingCols = withData ("TestData").inBlock ("Bookings")
            .row (0)
            .cells ();
        assertWithMessage ("Booking Column Count").that (bookingCols.size ())
            .isEqualTo (8);

        final var employeeCols = withData ("TestData").inBlock ("Employees")
            .row (0)
            .cells ();
        assertWithMessage ("Employee Column Count").that (employeeCols.size ())
            .isEqualTo (7);
    }

    /**
     * Test if all the data from Excel sheet is read correctly.
     */
    @Test
    public void testExcelDataCount () {
        final var bookingRows = withData ("TestData").inBlock ("Bookings")
            .rows ();
        assertWithMessage ("Booking Rows Count").that (bookingRows.size ())
            .isEqualTo (2);

        final var employeeRows = withData ("TestData").inBlock ("Employees")
            .rows ();
        assertWithMessage ("Employee Rows Count").that (employeeRows.size ())
            .isEqualTo (3);
    }
}
