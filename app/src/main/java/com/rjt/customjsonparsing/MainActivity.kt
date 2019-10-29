package com.rjt.customjsonparsing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofitCliecnt = RetrofitCliecnt()

       val service = retrofitCliecnt.getRetrofitInstance().create(Api::class.java)

        val call = service.getContacts()

        call.enqueue(object : Callback<Contact> {
            override fun onFailure(call: Call<Contact>, t: Throwable) {
                Log.d("contact", "Error ${t.message}")
            }

            override fun onResponse(call: Call<Contact>, response: Response<Contact>) {
                if (!response.isSuccessful){
                    Log.d("contact", "Code" + response.code().toString())
                }

                val result = response.body()
                val mobile = result?.phone?.mobile
                Log.d("contact", "Mobile: ${mobile}")
            }
        } )


    }
}
