package com.rjt.customjsonparsing

import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("contacts/")
    fun getContacts(): Call<Contact>
}