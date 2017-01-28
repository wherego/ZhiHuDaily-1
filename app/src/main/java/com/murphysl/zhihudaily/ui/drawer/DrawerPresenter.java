package com.murphysl.zhihudaily.ui.drawer;

import com.murphysl.zhihudaily.bean.ThemesBean;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * DrawerPresenter
 *
 * @author: MurphySL
 * @time: 2017/1/28 18:15
 */


public class DrawerPresenter extends DrawerContract.Presenter {
    @Override
    void getThemes() {
        rx.add(model.getThemes().subscribe(
                new Consumer<ThemesBean>() {
                    @Override
                    public void accept(ThemesBean themesBean) throws Exception {
                        view.showThemes(themesBean);
                    }
                },
                new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.onRequestError(throwable.toString());
                    }
                },
                new Action() {
                    @Override
                    public void run() throws Exception {
                        view.onRequestEnd();
                    }
                }
        ));
    }
}