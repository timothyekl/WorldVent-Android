/*
 * WorldVentAndroid
 * Api.kt
 * Created by Michal Bojanowicz on 2020/4/19
 * Copyright (c) 2020. Michal Bojanowicz. All rights reserved
 */

package com.timekl.worldvent.middleware

import retrofit2.Call
import com.timekl.worldvent.models.Bulletin
import retrofit2.http.GET

interface Api {

    @GET("bulletins/index.json")
    fun getBulletin(): Call<Bulletin>

}
