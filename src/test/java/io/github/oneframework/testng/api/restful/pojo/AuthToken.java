

package io.github.oneframework.testng.api.restful.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Token credential class
 *
 * @author Rahul Rana
 * @since 28-Feb-2023
 */
@Getter
@Builder
@ToString
public class AuthToken {
    private String password;
    private String username;
}
