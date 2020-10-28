package com.devtimchentw.kotlin_news.data

import android.app.Application
import com.devtimchentw.kotlin_news.model.News

/**
 *  author: Tim Chen
 *  time  : 2020/10/28
 *  desc  :
 */
class NewsRepository private constructor(application: Application) {

    private val newsRemoteDataSource: NewsRemoteDataSource = NewsRemoteDataSource

    companion object {
        private var INSTANCE: NewsRepository? = null

        fun getRepository(app: Application): NewsRepository {
            return INSTANCE ?: synchronized(this) {
                NewsRepository(app).also {
                    INSTANCE = it
                }
            }
        }
    }

    suspend fun fetchNewsList(): List<News> {
        return newsRemoteDataSource.fetchRemoteNewsList()
    }
}