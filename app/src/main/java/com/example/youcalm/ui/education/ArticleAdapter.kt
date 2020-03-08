package com.example.youcalm.ui.education

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.youcalm.R
import kotlinx.android.synthetic.main.article.view.*

class ArticleAdapter constructor(private val clickListener: (Article) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var articles: List<Article> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.article,
                parent,
                false
            )
        )

    }


    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ArticleViewHolder -> {
                holder.bind(articles[position], clickListener)
            }
        }
    }

    fun submitList(articlesList: List<Article>) {
        articles = articlesList
    }
}

class ArticleViewHolder constructor(
    private val articleView: View
) : RecyclerView.ViewHolder(articleView) {
    private val articleImage: ImageView = articleView.article_image
    private val articleTitle: TextView = articleView.article_title
    private val articleLink: TextView = articleView.article_link
    fun bind(article: Article, clickListener: (Article) -> Unit) {
        articleView.setOnClickListener { clickListener(article) }
        articleTitle.text = article.title
        articleLink.text = article.link
        val requestOptions = RequestOptions().placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
        Glide.with(itemView.context).applyDefaultRequestOptions(requestOptions).load(article.image)
            .into(articleImage)
    }
}



