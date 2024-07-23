

package io.github.oneframework.testng.api.others;

import static io.github.oneframework.actions.api.ApiActions.withRequest;
import static io.github.oneframework.builders.ApiRequest.createRequest;
import static io.github.oneframework.enums.PlatformType.API;
import static io.github.oneframework.enums.RequestMethod.GET;
import static io.github.oneframework.manager.ParallelSession.clearSession;
import static io.github.oneframework.manager.ParallelSession.createSession;
import static io.github.oneframework.testng.api.restful.requests.BookingRequest.createBooking;
import static io.github.oneframework.testng.api.restful.requests.BookingRequest.getBooking;

import io.github.oneframework.enums.RequestMethod;
import io.github.oneframework.exception.FrameworkError;
import io.github.oneframework.testng.api.restful.data.BookingRequestData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * Other API related tests
 *
 * @author Rahul Rana
 * @since 27-Aug-2022
 */
public class ApiTests {
    @AfterMethod
    public void tearDownMethod () {
        clearSession ();
    }

    @Test (description = "Test Empty path param")
    public void testEmptyPathParam () {
        createSession (API, "test_restfulbooker");
        final var request = getBooking (null);
        final var response = withRequest (request).execute ();

        response.verifyStatusCode ()
            .isEqualTo (200);
    }

    /**
     * Tests invalid config key.
     */
    @Test (description = "Test Invalid API config key", expectedExceptions = FrameworkError.class)
    public void testInvalidApiConfigKey () {
        createSession (API, "test_req");
        final var userRequest = createRequest ().method (GET)
            .path ("/users/${userId}")
            .pathParam ("userId", "2")
            .create ();
        withRequest (userRequest).execute ();
    }

    @Test
    public void testNullHeader () {
        createSession (API, "test_restfulbooker");
        final var request = createRequest ().method (RequestMethod.POST)
            .header ("Accept", "application/json")
            .header ("Content-Type", null)
            .path ("/booking")
            .bodyObject (createBooking (BookingRequestData.getBookingData ()))
            .create ();

        final var response = withRequest (request).execute ();
        response.verifyStatusCode ()
            .isEqualTo (500);
    }
}
