package com.app.portfoliodemo.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.DiffUtil
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MyWorkDataModel(
    val projectId: Int,
    val projectTitle: String,
    @DrawableRes val projectImage: Int
): Parcelable

class DiffUtilMyWorkDataModel: DiffUtil.ItemCallback<MyWorkDataModel>() {
    override fun areItemsTheSame(oldItem: MyWorkDataModel, newItem: MyWorkDataModel): Boolean {
        return newItem.projectId == oldItem.projectId
    }

    override fun areContentsTheSame(oldItem: MyWorkDataModel, newItem: MyWorkDataModel): Boolean {
        return newItem == oldItem
    }
}