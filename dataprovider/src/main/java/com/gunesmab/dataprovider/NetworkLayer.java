package com.gunesmab.dataprovider;


import com.gunesmab.javautils.ObjectValidatorImp;
import com.gunesmab.network.CallAdapterFactory;
import com.gunesmab.network.ErrorResponseGeneratorImp;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class NetworkLayer {

    private static final String EXTRA_PARAMETER_API_VALUE = "7b5b71c5dc1c1c3e7184ca7ed2082055";
    private static final String EXTRA_PARAMETER_API_KEY = "api_key";
    private static final String BASE_URL = "https://api.themoviedb.org/3";

    public static void init() {
        final TheMovieDpService service = getService();
    }

    private static TheMovieDpService getService() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(getCallAdapter())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build()
                .create(TheMovieDpService.class);
    }

    private static CallAdapter.Factory getCallAdapter() {
        return new CallAdapterFactory(new ErrorResponseGeneratorImp(), new ObjectValidatorImp());
    }

    private static OkHttpClient getClient() {
        return new OkHttpClient.Builder().addInterceptor(new DefaultInterceptorImpl()).build();
    }

    private static final class DefaultInterceptorImpl implements Interceptor {

        private DefaultInterceptorImpl() {
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            final Request requestOriginal = chain.request();
            final HttpUrl originalHttpUrl = requestOriginal.url();

            final HttpUrl url = originalHttpUrl.newBuilder()
                    .addQueryParameter(EXTRA_PARAMETER_API_KEY, EXTRA_PARAMETER_API_VALUE)
                    .build();

            return chain.proceed(requestOriginal.newBuilder().url(url).build());
        }
    }
}
