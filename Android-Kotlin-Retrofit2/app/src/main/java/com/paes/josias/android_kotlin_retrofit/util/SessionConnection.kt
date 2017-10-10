package com.paes.josias.android_kotlin_retrofit.util

import com.paes.josias.android_kotlin_retrofit.models.Post
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Created by Josias on 30/08/2017.
 */
interface SessionConnection {

    @GET("posts/{id}")
    fun requestPostsGet(@Path("id")id:Int):Call<Post>

    @POST("posts")
    fun sendNewPost(@Body post:Post):Call<Post>

}