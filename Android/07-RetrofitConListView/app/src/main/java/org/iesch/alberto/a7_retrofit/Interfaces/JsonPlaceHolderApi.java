package org.iesch.alberto.a7_retrofit.Interfaces;

import org.iesch.alberto.a7_retrofit.Models.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Posts>> getPost();
}
