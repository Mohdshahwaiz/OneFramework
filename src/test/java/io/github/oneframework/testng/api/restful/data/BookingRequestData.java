

package io.github.oneframework.testng.api.restful.data;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import io.github.oneframework.testng.api.restful.pojo.BookingData;
import io.github.oneframework.testng.api.restful.pojo.BookingDates;
import net.datafaker.Faker;

/**
 * Booking Data builder class.
 *
 * @author Rahul Rana
 * @since 28-Feb-2023
 */
public final class BookingRequestData {
    private static final Faker FAKER = new Faker ();

    /**
     * Build booking data
     *
     * @return {@link BookingData} instance
     */
    public static BookingData getBookingData () {
        final var formatter = new SimpleDateFormat ("yyyy-MM-dd");
        return BookingData.builder ()
            .firstname (FAKER.name ()
                .firstName ())
            .lastname (FAKER.name ()
                .lastName ())
            .totalprice (FAKER.number ()
                .numberBetween (1, 2000))
            .depositpaid (true)
            .bookingdates (BookingDates.builder ()
                .checkin (formatter.format (FAKER.date ()
                    .past (20, TimeUnit.DAYS)))
                .checkout (formatter.format (FAKER.date ()
                    .future (5, TimeUnit.DAYS)))
                .build ())
            .additionalneeds ("Breakfast")
            .build ();
    }

    /**
     * Build partial booking
     *
     * @return {@link BookingData} instance
     */
    public static BookingData getPartialBookingData () {
        return BookingData.builder ()
            .firstname (FAKER.name ()
                .firstName ())
            .totalprice (FAKER.number ()
                .numberBetween (100, 5000))
            .build ();
    }

    private BookingRequestData () {
        // Utility Class.
    }
}
