package com.example.demoretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.demoretrofit.data.ApiSingleton
import com.example.demoretrofit.data.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    ApiSingleton.create().getUser().enqueue(object : Callback<List<User>> {
        override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
            val listUser = response.body() ?: emptyList()
            val user = listUser.joinToString()
            findViewById<TextView>(R.id.text_users).text = user
        }

        override fun onFailure(call: Call<List<User>>, t: Throwable) {
            Log.e("TAG", "onFailure: ", t)
        }

    })
    }
}