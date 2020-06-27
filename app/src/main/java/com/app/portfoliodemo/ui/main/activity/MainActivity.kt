package com.app.portfoliodemo.ui.main.activity

import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.app.portfoliodemo.R
import com.app.portfoliodemo.ui.dashboard.activity.DashBoardActivity
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementsUseOverlay = false
        setContentView(R.layout.activity_main)
        super.onCreate(savedInstanceState)

        button_get_started.setOnClickListener {
            val intent = Intent(this, DashBoardActivity::class.java)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this, button_get_started, button_get_started.transitionName
            )
            startActivity(intent, options.toBundle())
        }
    }
}