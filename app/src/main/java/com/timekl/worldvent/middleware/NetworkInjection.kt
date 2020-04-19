/*
 * WorldVentAndroid
 * NetworkInjection.kt
 * Created by Michal Bojanowicz on 2020/4/19
 * Copyright (c) 2020. Michal Bojanowicz. All rights reserved
 */

package com.timekl.worldvent.middleware

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkInjection {

    fun provideApi(baseUrl: String): Api = provideRetrofit(baseUrl).create(Api::class.java)

    private fun provideRetrofit(baseUrl: String): Retrofit {
        val client: OkHttpClient
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        client = OkHttpClient.Builder().build() //.addInterceptor(interceptor).build() // disable logging
        val gson = GsonBuilder()
            .setLenient()
            .create()
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }
}