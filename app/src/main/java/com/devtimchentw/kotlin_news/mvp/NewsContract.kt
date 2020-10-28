package com.devtimchentw.kotlin_news.mvp

import com.devtimchentw.kotlin_news.model.News

/**
 *  author: Tim Chen
 *  time  : 2020/10/28
 *  desc  :
 */
class NewsContract {
    interface View {
        fun onLoading()
        fun onDataReceive(list: List<News>)
        fun onFailed()
    }

    interface Presenter {
        fun fetchNewsData()
    }
}