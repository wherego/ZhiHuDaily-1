package com.murphysl.zhihudaily.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.murphysl.zhihudaily.Constants;
import com.murphysl.zhihudaily.R;
import com.murphysl.zhihudaily.bean.DetailNews;
import com.murphysl.zhihudaily.mvpframe.base.MVPActivity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * DetailActivity
 *
 * @author: MurphySL
 * @time: 2017/1/30 20:06
 */


public class DetailActivity extends MVPActivity<DetailModel, DetailPresenter> implements DetailContract.View {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.webview)
    WebView webview;
    @BindView(R.id.img_detail)
    ImageView img;
    @BindView(R.id.title_detail)
    TextView titleDetail;
    @BindView(R.id.source_detail)
    TextView sourceDetail;

    private int newsId = -1;

    @Override
    protected void initView() {
        webview = (WebView) findViewById(R.id.webview);
        img = (ImageView) findViewById(R.id.img_detail);
        titleDetail = (TextView) findViewById(R.id.title_detail);
        sourceDetail = (TextView) findViewById(R.id.source_detail);
    }

    @Override
    protected void handleIntent(Intent intent) {
        newsId = intent.getIntExtra(Constants.newsId, 0);
        Snackbar.make(img, "" + newsId, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    protected void initData() {
        if (newsId != -1)
            presenter.getDetailNews(newsId);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_detail;
    }

    @Override
    public void onRequestEnd() {

    }

    @Override
    public void onRequestError(String msg) {

    }

    @Override
    public void showDetailNews(DetailNews detailBean) {
        if (detailBean != null) {
            Picasso.with(this)
                    .load(detailBean.getImage())
                    .fit()
                    .into(img);
            titleDetail.setText(detailBean.getTitle());
            sourceDetail.setText(detailBean.getImage_source());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}