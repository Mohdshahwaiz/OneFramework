

package io.github.oneframework.actions.interfaces.listeners.api;

import io.github.oneframework.actions.interfaces.listeners.BoykaListener;
import io.github.oneframework.builders.ApiResponse;

/**
 * API Actions listener.
 *
 * @author Rahul Rana
 * @since 06-Apr-2023
 */
public interface IApiActionsListener extends BoykaListener {
    /**
     * Handle API `execute` method.
     *
     * @param response {@link ApiResponse} instance
     */
    default void onExecute (final ApiResponse response) {
        // not implemented
    }
}
