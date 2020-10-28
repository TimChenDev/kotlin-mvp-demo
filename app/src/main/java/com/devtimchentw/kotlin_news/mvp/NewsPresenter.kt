package com.devtimchentw.kotlin_news.mvp

import android.app.Application
import com.devtimchentw.kotlin_news.data.NewsRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 *  author: Tim Chen
 *  time  : 2020/10/28
 *  desc  :
 */
class NewsPresenter(private val mView: NewsContract.View, application: Application) :
    NewsContract.Presenter {

    private val newsRepository = NewsRepository.getRepository(application)

    override fun fetchNewsData() {

        mView.onLoading()

        GlobalScope.launch {
            // use repository ask news data
            val list = newsRepository.fetchNewsList()
            if (list.isNotEmpty()) {
                mView.onDataReceive(list)
            } else {
                mView.onFailed()
            }
        }
    }

}