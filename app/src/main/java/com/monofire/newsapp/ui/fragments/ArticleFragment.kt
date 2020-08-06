package com.monofire.newsapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.monofire.newsapp.R
import com.monofire.newsapp.models.Article
import com.monofire.newsapp.ui.NewsActivity
import com.monofire.newsapp.ui.NewsViewModel
import kotlinx.android.synthetic.main.fragment_article.*
import java.io.Serializable

class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var viewModel: NewsViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel

        if (arguments != null) {
            val argss: ArticleFragmentArgs = ArticleFragmentArgs.fromBundle(requireArguments())
            val article = argss.article
            webView.apply {
                webViewClient = WebViewClient()
                loadUrl(article!!.url)
            }
            fab.setOnClickListener {
                viewModel.saveArticle(article!!)
                Snackbar.make(view,"Article saved succesfully",Snackbar.LENGTH_SHORT).show()
            }
        }


    }
}