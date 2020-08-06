package com.monofire.newsapp.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.monofire.newsapp.repository.NewsRepository

class NewsViewModelProviderFactory(val app:Application,val newsRespository: NewsRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(app,newsRespository) as T
    }
}