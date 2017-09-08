package com.gunesmab.javautils;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ObjectValidatorImp implements ObjectValidator {

    @Inject
    public ObjectValidatorImp() {
    }

    @Override
    public <O> O checkNotNull(O object) {
        if (object == null) {
            throw new IllegalStateException("given object can not be null");
        }
        return object;
    }
}
