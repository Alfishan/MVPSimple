package com.alfishan.mvpsimple.ui.activities.main;


import android.os.Handler;

import com.alfishan.mvpsimple.base.BasePresenter;

/**
 * Created by root on 17/4/17.
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {


    public MainPresenter() {
        super();
    }


    @Override
    public void initPresenter() {

        /***
         * // this code is only for showing off MyPregressbar for just test.. PS : make sure that presenter doesn’t depend on Android classes  */
        getView().showProgress();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getView().initActivity();
                getView().hideProgress();
            }
        },5000);
    }

    @Override
    public void onFabClick() {
        getView().openDemoFrag();
    }
}
