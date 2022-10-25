package com.example.demoretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.demoretrofit.adapter.ListUserAdapter
import com.example.demoretrofit.data.ApiSingleton
import com.example.demoretrofit.data.User
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    //helll

    var listUser : List<User>? = null
    var listUserAdapter = ListUserAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        callApiGetUsers()
        recyclerView.adapter = listUserAdapter
        //initRecyclerView()
    }

    private fun callApiGetUsers() {
        ApiSingleton.create().getUser().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                listUser = response.body() ?: emptyList()
                listUserAdapter.submitList(listUser)
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.e("TAG", "onFailure: ", t)
            }

        })
    }

    private fun initRecyclerView() {
        listUserAdapter.submitList(listUser)
    }
}