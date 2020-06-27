package com.app.portfoliodemo.callback

import android.view.View
import com.app.portfoliodemo.model.MyArticlesDataModel

interface ArticleListItemClickCallback {
    fun onArticleSelected(view: View, position: Int, articlesDataModel: MyArticlesDataModel)
}