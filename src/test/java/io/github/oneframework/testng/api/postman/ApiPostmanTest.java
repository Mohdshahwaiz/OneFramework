

package io.github.oneframework.testng.api.postman;

import static io.github.oneframework.enums.ContentType.FORM_URLENCODED;
import static io.github.oneframework.enums.PlatformType.API;
import static io.github.oneframework.enums.RequestMethod.POST;
import static io.github.oneframework.manager.ParallelSession.clearSession;
import static io.github.oneframework.manager.ParallelSession.createSession;

import io.github.oneframework.actions.api.ApiActions;
import io.github.oneframework.builders.ApiRequest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Test class to test Postman related samples.
 *
 * @author Rahul Rana
 * @since 09-Mar-2023
 */
public class ApiPostmanTest {
    /**
     * Setup API Test.
     */
    @BeforeClass (description = "Setup test class")
    public void setupTestClass () {
        createSession (API, "test_postman");
    }

    /**
     * Clean up Test class.
     */
    @AfterClass (description = "Tear down test class")
    public void tearDownTestClass () {
        clearSession ();
    }

    /**
     * Test form data request body related API request.
     */
    @Test (description = "Test Form body POST request")
    public void testFormBodyRequest () {
        final var request = ApiRequest.createRequest ()
            .contentType (FORM_URLENCODED)
            .formBody ("strange", "boom")
            .formBody ("test", "abc")
            .method (POST)
            .path ("/post")
            .create ();

        final var response = ApiActions.withRequest (request)
            .execute ();
        response.verifyStatusCode ()
            .isEqualTo (200);
    }
}
