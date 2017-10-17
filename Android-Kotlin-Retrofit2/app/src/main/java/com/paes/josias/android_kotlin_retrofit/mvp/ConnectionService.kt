package com.paes.josias.android_kotlin_retrofit.mvp

import android.content.Context
import com.paes.josias.android_kotlin_retrofit.R
import com.paes.josias.android_kotlin_retrofit.models.AsyncCallback
import com.paes.josias.android_kotlin_retrofit.models.Post
import com.paes.josias.android_kotlin_retrofit.util.Constants
import com.paes.josias.android_kotlin_retrofit.util.SessionConnection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Josias on 30/08/2017.
 */
class ConnectionService() {

    fun requestPostGet(postId:Int, context:Context, callback: AsyncCallback) {
        val retrofit = Retrofit.Builder()
                .baseUrl(Constants.URL_ROOT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(SessionConnection::class.java)

        var auth = service.requestPostsGet(postId)

        auth.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>?) {
                response?.let {
                    response.body()?.let {

                        val result = response.body()

                        var str =
                        "postId:${result?.postId}\n" +
                        "id:${result?.id}\n" +
                        "title:${result?.title}\n" +
                        "body:${result?.body} "

                        callback.onSuccess(str)

                    }
                }
            }
            override fun onFailure(call: Call<Post>, t: Throwable) {
                //.result(context.getString(R.string.error))
            }
        })
    }

    fun sendNewPost(post:Post, context: Context, callback: AsyncCallback) {
        val retrofit = Retrofit.Builder()
                .baseUrl(Constants.URL_ROOT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(SessionConnection::class.java)

        var auth = service.sendNewPost(post)

        auth.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>?) {
                response?.let {
                    response.body()?.let {
                        val result = response.body()

                        var str =
                                "postId:${result?.postId}\n" +
                                        "id:${result?.id}\n" +
                                        "title:${result?.title}\n" +
                                        "body:${result?.body} "

                        callback.onSuccess(str)

                    }
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                callback.onFailure(context.getString(R.string.error))
            }
        })
    }

}