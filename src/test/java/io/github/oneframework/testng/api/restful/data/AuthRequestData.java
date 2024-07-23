

package io.github.oneframework.testng.api.restful.data;

import io.github.oneframework.testng.api.restful.pojo.AuthToken;

/**
 * Token builder class
 *
 * @author Rahul Rana
 * @since 28-Feb-2023
 */
public final class AuthRequestData {
    public static AuthToken getTokenData () {
        return AuthToken.builder ()
            .username ("admin")
            .password ("password123")
            .build ();
    }

    private AuthRequestData () {
        // Utility Class.
    }
}
