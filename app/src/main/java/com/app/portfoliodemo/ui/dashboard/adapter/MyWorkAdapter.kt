package com.app.portfoliodemo.ui.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.portfoliodemo.R
import com.app.portfoliodemo.model.DiffUtilMyWorkDataModel
import com.app.portfoliodemo.model.MyWorkDataModel
import kotlinx.android.synthetic.main.list_item_my_work_layout.view.*

class MyWorkAdapter: ListAdapter<MyWorkDataModel, MyWorkViewHolder>(DiffUtilMyWorkDataModel()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyWorkViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_my_work_layout, parent, false)
        return MyWorkViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyWorkViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class MyWorkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: MyWorkDataModel?) {
        if (item != null) {
            itemView.image_view_project_image.setImageResource(item.projectImage)
        }
    }
}