

package io.github.oneframework.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Request Content Types.
 *
 * @author Rahul Rana
 * @since 04-Mar-2022
 */
@AllArgsConstructor
@Getter
public enum ContentType {
    /**
     * Application/x-www-form-urlencoded.
     */
    FORM_URLENCODED ("application/x-www-form-urlencoded"),
    /**
     * Application/json.
     */
    JSON ("application/json"),
    /**
     * Multipart/form-data.
     */
    MULTIPART_FORM_DATA ("multipart/form-data"),
    /**
     * Plain text.
     */
    PLAIN_TEXT ("text/plain");

    private final String type;
}
