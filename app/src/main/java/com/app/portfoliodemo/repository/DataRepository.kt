package com.app.portfoliodemo.repository

import com.app.portfoliodemo.R
import com.app.portfoliodemo.app.MyApplication.Companion.appContext
import com.app.portfoliodemo.model.MyArticlesDataModel
import com.app.portfoliodemo.model.MyWorkDataModel

class DataRepository {
    fun getMyWorkList(): ArrayList<MyWorkDataModel> {
        val myWorks = arrayListOf<MyWorkDataModel>()
        myWorks.add(MyWorkDataModel(1, "Test 1", R.drawable.my_work_image_1))
        myWorks.add(MyWorkDataModel(2, "Test 2", R.drawable.my_work_image_2))
        myWorks.add(MyWorkDataModel(3, "Test 3", R.drawable.my_work_image_3))
        myWorks.add(MyWorkDataModel(4, "Test 4", R.drawable.my_work_image_4))
        myWorks.add(MyWorkDataModel(5, "Test 5", R.drawable.my_work_image_5))
        return myWorks
    }

    fun getMyArticleDataList(): ArrayList<MyArticlesDataModel> {
        val articleList = arrayListOf<MyArticlesDataModel>()
        articleList.add(MyArticlesDataModel(articleId = 1, articleImage = R.drawable.my_work_image_6,
            articleTitle = appContext.getString(R.string.dummy_title_1), articleContent = appContext.getString(R.string.lorem_ipsum)))
        articleList.add(MyArticlesDataModel(articleId = 2, articleImage = R.drawable.my_work_image_7,
            articleTitle = appContext.getString(R.string.dummy_title_2), articleContent = appContext.getString(R.string.lorem_ipsum)))
        articleList.add(MyArticlesDataModel(articleId = 3, articleImage = R.drawable.my_work_image_8,
            articleTitle = appContext.getString(R.string.dummy_title_3), articleContent = appContext.getString(R.string.lorem_ipsum)))
        articleList.add(MyArticlesDataModel(articleId = 4, articleImage = R.drawable.my_work_image_9,
            articleTitle = appContext.getString(R.string.dummy_title_4), articleContent = appContext.getString(R.string.lorem_ipsum)))
        articleList.add(MyArticlesDataModel(articleId = 5, articleImage = R.drawable.my_work_image_10,
            articleTitle = appContext.getString(R.string.dummy_title_5), articleContent = appContext.getString(R.string.lorem_ipsum)))
        return articleList
    }
}