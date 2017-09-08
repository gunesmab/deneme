package com.gunesmab.network;


import retrofit2.Response;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ErrorResponseGeneratorImp implements ErrorResponseGenerator {

    @Inject
    public ErrorResponseGeneratorImp() {
    }

    @Override
    public ErrorResponse generate(Response response) {
        if (response.errorBody() == null) {
            return ErrorResponseEmptyImp.create();
        }

        return null;
    }
}
