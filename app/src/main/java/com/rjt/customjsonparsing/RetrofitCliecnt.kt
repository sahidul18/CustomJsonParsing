package com.rjt.customjsonparsing

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitCliecnt {

    var retrofit: Retrofit? = null

    val BASE_URL = "https://api.androidhive.info/"

    public fun getRetrofitInstance():Retrofit{

        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofit!!
    }


}