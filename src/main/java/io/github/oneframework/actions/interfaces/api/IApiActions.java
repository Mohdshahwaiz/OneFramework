

package io.github.oneframework.actions.interfaces.api;

import io.github.oneframework.builders.ApiResponse;

/**
 * Execute API
 *
 * @author Rahul Rana
 * @since 18-Feb-2023
 */
public interface IApiActions {
    /**
     * Execute API request
     *
     * @return {@link ApiResponse} from the executed request
     */
    ApiResponse execute ();
}
