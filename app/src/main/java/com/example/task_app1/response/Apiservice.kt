package com.example.task_app1.response

import com.example.task_app1.model.Model
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://simple-node-app-nkd.herokuapp.com"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(BASE_URL).build()


abstract class Apiservice {
    @GET(".")
    abstract fun getAllData(): Call<List<Model>>

}

    object Api {
        val retrofitService: Apiservice by lazy{retrofit.create(Apiservice::class.java)}
    }
   