

package io.github.oneframework.testng.api.restful.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Booking dates class
 *
 * @author Rahul Rana
 * @since 28-Feb-2023
 */
@Getter
@Builder
@ToString
public class BookingDates {
    private String checkin;
    private String checkout;
}
