

package io.github.oneframework.builders;

import java.util.Map;

import io.github.oneframework.enums.ContentType;
import io.github.oneframework.enums.RequestMethod;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

/**
 * Request builder class.
 *
 * @author Rahul Rana
 * @since 04-Mar-2022
 */
@ToString
@Getter
@Builder (builderMethodName = "createRequest", buildMethodName = "create")
public class ApiRequest {
    private String              body;
    private Object              bodyObject;
    private ContentType         contentType;
    @Singular
    private Map<String, String> formBodies;
    @Singular
    private Map<String, String> headers;
    private RequestMethod       method;
    private String              password;
    private String              path;
    @Singular
    private Map<String, String> pathParams;
    @Singular
    private Map<String, String> queryParams;
    private String              userName;
}
