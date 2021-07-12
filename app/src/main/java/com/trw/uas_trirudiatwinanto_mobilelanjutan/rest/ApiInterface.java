package com.trw.uas_trirudiatwinanto_mobilelanjutan.rest;


import com.trw.uas_trirudiatwinanto_mobilelanjutan.model.GetUser;
import com.trw.uas_trirudiatwinanto_mobilelanjutan.model.PostPutDelUser;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @GET("users?per_page=50")
    Call<GetUser>getUser();
    @FormUrlEncoded
    @POST("users")
    Call<PostPutDelUser>postUser(@Field("email") String email,
                                 @Field("first_name") String first_name,
                                 @Field("last_name") String last_name);

    @FormUrlEncoded
    @PUT("users")
    Call<PostPutDelUser>putUser(@Field("email") String email,
                                @Field("first_name") String first_name,
                                @Field("last_name") String last_name);

    @FormUrlEncoded
    @HTTP(method="DELETE", path = "users?per_page=50", hasBody = true)
    Call<PostPutDelUser>deleteUser(@Field("id") String id);
}
