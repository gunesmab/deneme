package com.gunesmab.javautils;

/**
 * A generic generator interface to generate output object via given input.
 *
 * @param <I> input object generic type.
 * @param <O> output object generic type.
 */
public interface Generator<I, O> {

    /**
     * Create a new object is type O via given input object.
     *
     * @param input to create output object.
     * @return output object.
     */
    O generate(I input);
}
