

package io.github.oneframework.testng.api.ssl;

import static io.github.oneframework.actions.api.ApiActions.withRequest;
import static io.github.oneframework.enums.PlatformType.API;
import static io.github.oneframework.enums.RequestMethod.GET;
import static io.github.oneframework.manager.ParallelSession.clearSession;
import static io.github.oneframework.manager.ParallelSession.createSession;

import io.github.oneframework.builders.ApiRequest;
import org.testng.annotations.Test;

/**
 * Test Bad SSL API.
 *
 * @author Rahul Rana
 * @since 28-Jan-2024
 */
public class ApiSecurityTest {
    /**
     * Test bad host name.
     */
    @Test
    public void testBadHostName () {
        try {
            createSession (API, "test_bad_host_name_wo_verify_hn");
            final var request = ApiRequest.createRequest ()
                .method (GET)
                .create ();
            final var response = withRequest (request).execute ();

            response.verifyStatusCode ()
                .isEqualTo (200);
        } finally {
            clearSession ();
        }
    }

    /**
     * Test Bad SSL API.
     */
    @Test
    public void testBadSsl () {
        try {
            createSession (API, "test_bad_ssl_wo_verify");
            final var request = ApiRequest.createRequest ()
                .method (GET)
                .create ();
            final var response = withRequest (request).execute ();

            response.verifyStatusCode ()
                .isEqualTo (200);
        } finally {
            clearSession ();
        }
    }
}
