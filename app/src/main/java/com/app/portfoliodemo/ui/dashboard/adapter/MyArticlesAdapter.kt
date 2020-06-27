package com.app.portfoliodemo.ui.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.portfoliodemo.R
import com.app.portfoliodemo.callback.ArticleListItemClickCallback
import com.app.portfoliodemo.model.DiffUtilMyArticlesDataModel
import com.app.portfoliodemo.model.MyArticlesDataModel
import kotlinx.android.synthetic.main.list_item_my_articles.view.*

class MyArticlesAdapter(private val articleCallback: ArticleListItemClickCallback) : ListAdapter<MyArticlesDataModel, MyArticlesViewHolder>(DiffUtilMyArticlesDataModel()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyArticlesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_my_articles, parent, false)
        return MyArticlesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyArticlesViewHolder, position: Int) {
        holder.bind(getItem(position), articleCallback)
    }
}

class MyArticlesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(
        item: MyArticlesDataModel?,
        articleCallback: ArticleListItemClickCallback
    ) {
        if (item != null) {
            itemView.image_view_article.setImageResource(item.articleImage)
            itemView.text_view_title.text = item.articleTitle
            itemView.text_view_sub_title.text = item.articleContent

            itemView.text_view_title.isSelected = true

            itemView.container_layout.setOnClickListener {
                articleCallback.onArticleSelected(itemView.container_layout, adapterPosition, item)
            }
        }
    }
}