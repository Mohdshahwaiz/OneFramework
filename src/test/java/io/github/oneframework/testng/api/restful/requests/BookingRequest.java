

package io.github.oneframework.testng.api.restful.requests;

import static io.github.oneframework.builders.ApiRequest.createRequest;
import static io.github.oneframework.testng.api.restful.data.AuthRequestData.getTokenData;
import static java.text.MessageFormat.format;

import io.github.oneframework.actions.api.ApiActions;
import io.github.oneframework.builders.ApiRequest;
import io.github.oneframework.enums.RequestMethod;
import io.github.oneframework.testng.api.restful.pojo.BookingData;

/**
 * Booking request class
 *
 * @author Rahul Rana
 * @since 28-Feb-2023
 */
public final class BookingRequest {
    public static ApiRequest createBooking (final BookingData requestBody) {
        return createRequest ().method (RequestMethod.POST)
            .header ("Accept", "application/json")
            .path ("/booking")
            .bodyObject (requestBody)
            .create ();
    }

    public static ApiRequest deleteBooking (final String id) {
        return createRequest ().method (RequestMethod.DELETE)
            .header ("Content-Type", "application/json")
            .header ("Cookie", format ("token={0}", generateToken ()))
            .path ("/booking/${id}")
            .pathParam ("id", id)
            .create ();
    }

    public static ApiRequest getBooking (final String id) {
        return createRequest ().method (RequestMethod.GET)
            .header ("Accept", "application/json")
            .path ("/booking/${id}")
            .pathParam ("id", id)
            .create ();
    }

    public static ApiRequest updateBooking (final String id, final BookingData requestBody) {
        return createRequest ().method (RequestMethod.PUT)
            .header ("Accept", "application/json")
            .header ("Cookie", format ("token={0}", generateToken ()))
            .path ("/booking/${id}")
            .bodyObject (requestBody)
            .pathParam ("id", id)
            .create ();
    }

    public static ApiRequest updatePartialBooking (final String id, final BookingData requestBody) {
        return createRequest ().method (RequestMethod.PATCH)
            .header ("Accept", "application/json")
            .header ("Cookie", format ("token={0}", generateToken ()))
            .path ("/booking/${id}")
            .bodyObject (requestBody)
            .pathParam ("id", id)
            .create ();
    }

    private static String generateToken () {
        final var generateTokenRequest = createRequest ().header ("Accept", "application/json")
            .method (RequestMethod.POST)
            .path ("/auth")
            .bodyObject (getTokenData ())
            .create ();

        final var response = ApiActions.withRequest (generateTokenRequest)
            .execute ();
        return response.getResponseData ("token");
    }

    private BookingRequest () {
        // Utility Class.
    }
}
