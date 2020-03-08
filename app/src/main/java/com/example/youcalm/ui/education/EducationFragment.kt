package com.example.youcalm.ui.education

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youcalm.MainActivity
import com.example.youcalm.R
import kotlinx.android.synthetic.main.fragment_education.*
import kotlin.math.log


class EducationFragment : Fragment() {
    private lateinit var articleAdapter: ArticleAdapter
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recyclerView()
        addData()
    }

    private fun recyclerView() {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(activity?.applicationContext)
            val spacingItem = SpacingItem(42)
            addItemDecoration(spacingItem)
            articleAdapter = ArticleAdapter { article: Article ->
                articleClicked(article)
            }
            adapter = articleAdapter
        }
    }

    private fun addData() {
        val data = DataSource.createDataSet()
        articleAdapter.submitList(data)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_education, container, false)
    }

    companion object {
        fun newInstance(): EducationFragment = EducationFragment()
    }

    private fun articleClicked(article: Article) {
        val openURL = Intent(Intent.ACTION_VIEW)
        openURL.data = Uri.parse(article.body)
        startActivity(openURL)
    }

}
