package com.gunesmab.network;

import com.gunesmab.javautils.ObjectValidator;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


public class CallAdapterFactory extends CallAdapter.Factory {

    private final ErrorResponseGenerator errorResponseGenerator;

    private final ObjectValidator objectValidator;

    public CallAdapterFactory(final ErrorResponseGenerator errorResponseGenerator,
                              final ObjectValidator objectValidator) {
        this.objectValidator = objectValidator;
        this.errorResponseGenerator = objectValidator.checkNotNull(errorResponseGenerator);
    }

    @Override
    public CallAdapter<?, ?> get(final Type returnType, final Annotation[] annotations, final Retrofit retrofit) {
        if (getRawType(returnType) != CallResponse.class) {
            return null;
        }
        final Type body = getParameterUpperBound(0, (ParameterizedType) returnType);
        if (!(body instanceof ParameterizedType)) {
            throw new IllegalArgumentException("body must be parameterized");
        }
        return new ApiCallAdapter<>(returnType, objectValidator, errorResponseGenerator);
    }
}
