package com.alfishan.mvpsimple.ui.fragments.demo;


import android.os.Handler;

import com.alfishan.mvpsimple.base.BasePresenter;

/**
 * Created by root on 17/4/17.
 */

public class DemoFragPresenter extends BasePresenter<DemoFragContract.View> implements DemoFragContract.Presenter {


    public DemoFragPresenter() {
        super();
    }


    @Override
    public void onGreetingClicks() {
        getView().updateGreetings("Hey Man How Are You ?");
    }

    @Override
    public void initPresenter() {
        /***
         * // this code is only for showing off MyPregressbar for just test.. PS : make sure that presenter doesn’t depend on Android classes  */
        getView().showProgress();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getView().hideProgress();
                getView().initView();

            }
        },5000);
    }
}

