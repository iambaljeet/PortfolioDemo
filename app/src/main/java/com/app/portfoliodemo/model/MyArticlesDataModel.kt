package com.app.portfoliodemo.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.DiffUtil
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MyArticlesDataModel(
    val articleId: Int,
    val articleTitle: String,
    val articleContent: String,
    @DrawableRes val articleImage: Int
): Parcelable

class DiffUtilMyArticlesDataModel: DiffUtil.ItemCallback<MyArticlesDataModel>() {
    override fun areItemsTheSame(oldItem: MyArticlesDataModel, newItem: MyArticlesDataModel): Boolean {
        return newItem.articleId == oldItem.articleId
    }

    override fun areContentsTheSame(oldItem: MyArticlesDataModel, newItem: MyArticlesDataModel): Boolean {
        return newItem == oldItem
    }
}