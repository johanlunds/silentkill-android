package com.example.johanoanton.silentkill;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by johan_lunds on 2017-03-10.
 */

class LoginActivityPresenter {

    private static final String BASE_URL = "https://silentkill-staging.herokuapp.com";
    private final BackendApiService mService;

    public LoginActivityPresenter() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mService = retrofit.create(BackendApiService.class);
    }

    public void login(String email, String password) {
        // TODO: put this in a Repository class?
        mService.login(email, password).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                // TODO: wrap error responses with some good default parsing
                // TODO: trigger onFailure or something like it on non-2XX
                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    Timber.d("%s", loginResponse.data.username);
                } else {
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
            }
        });
    }
}
