package com.murphysl.zhihudaily.ui.splash;

import com.murphysl.zhihudaily.bean.SplashImgBean;

import io.reactivex.functions.Consumer;

/**
 * SplashPresenter
 *
 * @author: MurphySL
 * @time: 2017/1/19 12:42
 */


public class SplashPresenter extends SplashContract.Presenter {

    @Override
    void getSplashImg() {
        model.getSplashImg().subscribe(new Consumer<SplashImgBean>() {
            @Override
            public void accept(SplashImgBean splashImgBean) throws Exception {
                view.showImg(splashImgBean.getImg());
            }
        });
    }
}
