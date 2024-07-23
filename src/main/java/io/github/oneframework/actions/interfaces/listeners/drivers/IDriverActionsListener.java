

package io.github.oneframework.actions.interfaces.listeners.drivers;

import java.time.Duration;

import io.github.oneframework.actions.interfaces.listeners.BoykaListener;

/**
 * Handle all driver actions event.
 *
 * @author Rahul Rana
 * @since 09-Apr-2023
 */
public interface IDriverActionsListener extends BoykaListener {
    /**
     * Handle execute script method.
     *
     * @param script Script to be executed
     * @param args Arguments to be used in the script
     */
    default void onExecuteScript (final String script, final Object... args) {
        // not implemented.
    }

    /**
     * Handle pause method.
     *
     * @param time Time till executions to be paused
     */
    default void onPause (final Duration time) {
        // not implemented.
    }

    /**
     * Handle save logs method.
     */
    default void onSaveLogs () {
        // not implemented.
    }

    /**
     * Handle wait until method.
     */
    default void onWaitUntil () {
        // not implemented.
    }
}
