package com.app.portfoliodemo.ui.dashboard.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.updatePadding
import com.app.portfoliodemo.R
import com.app.portfoliodemo.callback.ArticleListItemClickCallback
import com.app.portfoliodemo.model.MyArticlesDataModel
import com.app.portfoliodemo.repository.DataRepository
import com.app.portfoliodemo.ui.article.ArticleActivity
import com.app.portfoliodemo.ui.dashboard.adapter.MyArticlesAdapter
import com.app.portfoliodemo.ui.dashboard.adapter.MyWorkAdapter
import com.app.portfoliodemo.utility.Constants
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import kotlinx.android.synthetic.main.activity_dash_board.*

class DashBoardActivity: AppCompatActivity(), ArticleListItemClickCallback {
    lateinit var myWorkAdapter: MyWorkAdapter
    lateinit var dataRepository: DataRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        setContentView(R.layout.activity_dash_board)

        setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementsUseOverlay = false
        super.onCreate(savedInstanceState)

        dataRepository = DataRepository()
        myWorkAdapter = MyWorkAdapter()
        recycler_view_my_work.adapter = myWorkAdapter

        val controller =
            AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation_from_right)

        recycler_view_my_work.layoutAnimation = controller
        recycler_view_my_work.scheduleLayoutAnimation()

        val myWorkList = dataRepository.getMyWorkList()
        myWorkAdapter.submitList(myWorkList)

        top_layout.setOnApplyWindowInsetsListener { view, windowInsets ->
            top_layout?.updatePadding(top = windowInsets.systemWindowInsetTop)
            windowInsets
        }

        val myArticlesAdapter = MyArticlesAdapter(this)
        recycler_view_articles.adapter = myArticlesAdapter

        recycler_view_articles.layoutAnimation = controller
        recycler_view_articles.scheduleLayoutAnimation()

        val myArticleDataList = dataRepository.getMyArticleDataList()
        myArticlesAdapter.submitList(myArticleDataList)
    }

    override fun onArticleSelected(
        view: View,
        position: Int,
        articlesDataModel: MyArticlesDataModel
    ) {
        val intent = Intent(this, ArticleActivity::class.java)
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
            this, view.findViewById(R.id.image_view_article), view.findViewById<AppCompatImageView>(R.id.image_view_article).transitionName
        )
        intent.putExtra(Constants.ARTICLE_DATA, articlesDataModel)
        startActivity(intent, options.toBundle())
    }
}