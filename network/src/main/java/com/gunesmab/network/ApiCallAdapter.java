package com.gunesmab.network;

import com.gunesmab.javautils.ObjectValidator;
import retrofit2.Call;
import retrofit2.CallAdapter;

import java.lang.reflect.Type;


class ApiCallAdapter<Body> implements CallAdapter<Body, CallResponse<Body>> {

    private final Type responseType;

    private ObjectValidator objectValidator;

    private ErrorResponseGenerator errorResponseGenerator;

    ApiCallAdapter(final Type responseType,
                   final ObjectValidator objectValidator,
                   final ErrorResponseGenerator errorResponseGenerator) {
        this.objectValidator = objectValidator;
        this.errorResponseGenerator = objectValidator.checkNotNull(errorResponseGenerator);
        this.responseType = objectValidator.checkNotNull(responseType);
    }

    @Override
    public Type responseType() {
        return responseType;
    }

    @Override
    public CallResponse<Body> adapt(final Call<Body> call) {
        return new CallResponseImp<>(objectValidator.checkNotNull(call), objectValidator, errorResponseGenerator);
    }
}
