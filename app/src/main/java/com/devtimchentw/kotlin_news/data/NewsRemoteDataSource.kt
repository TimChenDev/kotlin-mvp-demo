package com.devtimchentw.kotlin_news.data

import com.devtimchentw.kotlin_news.model.News
import com.devtimchentw.kotlin_news.uilt.httpClientAndroid
import io.ktor.client.request.get

/**
 *  author: Tim Chen
 *  time  : 2020/10/28
 *  desc  :
 */
object NewsRemoteDataSource {

    private const val SERVER_URL = "https://www.sinica.edu.tw"

    /**
     * 進行 http 請求
     */
    suspend fun fetchRemoteNewsList(): List<News> {
        return httpClientAndroid.get("$SERVER_URL/getJsonData.php?id=2")
    }
}