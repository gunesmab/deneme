package com.gunesmab.network;


import com.gunesmab.javautils.ObjectValidator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.lang.ref.WeakReference;
import java.util.Observable;

public class CallResponseImp<Body> extends Observable implements CallResponse<Body> {

    private Response<Body> response;

    private Throwable throwable;

    private ObjectValidator objectValidator;

    private ErrorResponseGenerator errorResponseGenerator;

    private Call<Body> call;


    CallResponseImp(final Call<Body> call,
                    final ObjectValidator objectValidator,
                    final ErrorResponseGenerator errorResponseGenerator) {
        this.objectValidator = objectValidator;
        this.errorResponseGenerator = errorResponseGenerator;
        this.call = objectValidator.checkNotNull(call);
        call.enqueue(new RetrofitCallBack<>(this));
    }



    @Override
    public Body getResponse() {
        return response.body();
    }

    @Override
    public ErrorResponse getErrorResponse() {
        return errorResponseGenerator.generate(response);
    }

    @Override
    public void cancel() {
        if (call != null) {
            call.cancel();
        }
    }

    void setResponse(final Response<Body> response) {
        this.response = response;
        call = null;
    }

    void setThrowable(final Throwable throwable) {
        this.throwable = throwable;
        call = null;
    }

    private static class RetrofitCallBack<Body> implements Callback<Body> {

        private WeakReference<CallResponseImp<Body>> responseImpWeakReference;

        public RetrofitCallBack(final CallResponseImp<Body> responseImp) {
            this.responseImpWeakReference = new WeakReference<>(responseImp);
        }

        @Override
        public void onResponse(Call<Body> call, retrofit2.Response<Body> response) {
            if (responseImpWeakReference.get() != null) {
                responseImpWeakReference.get().setResponse(response);
            }
        }

        @Override
        public void onFailure(Call<Body> call, Throwable throwable) {
            if (responseImpWeakReference.get() != null) {
                responseImpWeakReference.get().setThrowable(throwable);
            }
        }
    }
}
