

package io.github.oneframework.actions.interfaces.listeners.data;

import io.github.oneframework.actions.interfaces.listeners.BoykaListener;

/**
 * Test Data action listener.
 *
 * @author Rahul Rana
 * @since 28-Nov-2023
 */
public interface ITestDataActionsListener extends BoykaListener {
    /**
     * Handle `get` method from TestDataAction
     *
     * @param dataClass Test data class
     * @param <T> Type of test data class
     */
    default <T> void onGet (final Class<T> dataClass) {
        // not implemented
    }

    /**
     * Handle row method from TestDataAction
     *
     * @param index Row index
     */
    default void onRow (final int index) {
        // not implemented
    }

    /**
     * Handle row method from TestDataAction
     */
    default void onRows () {
        // not implemented
    }
}
