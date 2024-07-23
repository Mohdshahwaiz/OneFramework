

package io.github.oneframework.testng.listeners.api;

import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.step;
import static java.text.MessageFormat.format;
import static java.util.Optional.ofNullable;

import io.github.oneframework.actions.interfaces.listeners.api.IApiActionsListener;
import io.github.oneframework.builders.ApiResponse;

/**
 * API Actions listener.
 *
 * @author Rahul Rana
 * @since 06-Apr-2023
 */
public class ApiActionListener implements IApiActionsListener {
    @Override
    public void onExecute (final ApiResponse response) {
        final var request = response.getRequest ();
        step (format ("Executing [{0}] API request", request.getMethod ()));
        addAttachment ("Status Code", Integer.toString (response.getStatusCode ()));
        ofNullable (request.getBody ()).ifPresent (v -> addAttachment ("Request Body", v));
        ofNullable (response.getBody ()).ifPresent (v -> addAttachment ("Response Body", v));
    }
}
