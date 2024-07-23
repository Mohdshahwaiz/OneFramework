

package io.github.oneframework.testng.api.restful.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Booking data class.
 *
 * @author Rahul Rana
 * @since 28-Feb-2023
 */
@Getter
@Builder
@ToString
public class BookingData {
    private String       additionalneeds;
    private BookingDates bookingdates;
    private boolean      depositpaid;
    private String       firstname;
    private String       lastname;
    private int          totalprice;
}
