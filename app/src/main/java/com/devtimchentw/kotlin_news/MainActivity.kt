package com.devtimchentw.kotlin_news

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.devtimchentw.kotlin_news.model.News
import com.devtimchentw.kotlin_news.mvp.NewsContract
import com.devtimchentw.kotlin_news.mvp.NewsPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NewsContract.View {

    private var presenter: NewsPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = NewsPresenter(this, application)
        presenter?.fetchNewsData()
    }

    override fun onLoading() {
        Toast.makeText(this, "下載中", Toast.LENGTH_LONG).show()
        tv_result.text = "下載中"
    }

    override fun onDataReceive(list: List<News>) {
        runOnUiThread {
            tv_result.text = "資料下載完成, 共 ${list.size} 筆資料, 第一筆資料的標題為 ${list[0].title}"
        }
    }

    override fun onFailed() {
        Toast.makeText(this, "下載失敗", Toast.LENGTH_LONG).show()
        tv_result.text = "下載失敗"
    }
}