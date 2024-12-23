package com.echoclsaa.fastool.extension.context;

/**
 * The Lifecycle
 *
 * @author clsaa
 */
public interface Lifecycle {

    /**
     * Initialize the component before {@link #start() start}
     *
     * @throws IllegalStateException
     */
    void initialize() throws IllegalStateException;

    /**
     * Start the component
     *
     * @throws IllegalStateException
     */
    void start() throws IllegalStateException;

    /**
     * Destroy the component
     *
     * @throws IllegalStateException
     */
    void destroy() throws IllegalStateException;
}
