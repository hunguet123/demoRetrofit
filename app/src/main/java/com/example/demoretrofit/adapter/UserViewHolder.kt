package com.example.demoretrofit.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.demoretrofit.data.User
import kotlinx.android.synthetic.main.item_view_user.view.*

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var itemData : User? = null

    fun binData(user: User) {
        itemData = user
        itemView.run {
            txtId.text = user.id.toString()
            txtName.text = user.name
            txtUsername.text = user.username
        }
    }

}