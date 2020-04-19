/*
 * WorldVentAndroid
 * NetworkClient.kt
 * Created by Michal Bojanowicz on 2020/4/19
 * Copyright (c) 2020. Michal Bojanowicz. All rights reserved
 */

package com.timekl.worldvent.middleware

import android.util.Log
import com.timekl.worldvent.models.Bulletin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkClient(val api: Api) {

    private val TAG = "NetworkClient"

    fun getBulletinJSON(handler: (response: Bulletin?) -> Unit) {
        api.getBulletin()
            .enqueue(object: Callback<Bulletin> {
                override fun onResponse(call: Call<Bulletin>, response: Response<Bulletin>) {
                    if (!response.isSuccessful) {
                        Log.e(TAG, "response not successful ${response.message()}")
                    }
                    handler(response.body())
                }

                override fun onFailure(call: Call<Bulletin>, t: Throwable) {
                    Log.e(TAG, "onFailure $t")
                    handler(null)
                }
            })
    }
}