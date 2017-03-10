package com.example.johanoanton.silentkill;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by johan_lunds on 2017-03-10.
 */

public interface BackendApiService {
    @POST("/auth/sign_in")
    Call<LoginResponse> login(@Query("email") String email, @Query("password") String password);
}
