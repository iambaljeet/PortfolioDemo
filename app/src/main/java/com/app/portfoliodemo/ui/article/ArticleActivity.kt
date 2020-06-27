package com.app.portfoliodemo.ui.article

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.updateLayoutParams
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.app.portfoliodemo.R
import com.app.portfoliodemo.model.MyArticlesDataModel
import com.app.portfoliodemo.utility.Constants
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.transition.platform.MaterialArcMotion
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import kotlinx.android.synthetic.main.activity_article.*

class ArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        setContentView(R.layout.activity_article)

        val articlesDataModel: MyArticlesDataModel? = intent?.extras?.getParcelable(Constants.ARTICLE_DATA)

        setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementEnterTransition = buildTransformation()
        window.sharedElementReturnTransition = buildTransformation()
        window.sharedElementExitTransition = buildTransformation()
        super.onCreate(savedInstanceState)

        container_layout.setOnApplyWindowInsetsListener { view, windowInsets ->
            toolbar_main.updateLayoutParams<CollapsingToolbarLayout.LayoutParams> {
                topMargin = windowInsets.systemWindowInsetTop
            }
            windowInsets
        }

        if (articlesDataModel != null) {
            image_view_article_image.setImageResource(articlesDataModel.articleImage)
            text_view_title.text = articlesDataModel.articleTitle
            text_view_sub_title.text = articlesDataModel.articleContent
        }
    }

    private fun buildTransformation() =
        MaterialContainerTransform().apply {
            addTarget(image_view_article_image)
            setAllContainerColors(ContextCompat.getColor(this@ArticleActivity, R.color.colorWhite))
            duration = 800
            pathMotion = MaterialArcMotion()
            interpolator = FastOutSlowInInterpolator()
            fadeMode = MaterialContainerTransform.FADE_MODE_IN
        }
}