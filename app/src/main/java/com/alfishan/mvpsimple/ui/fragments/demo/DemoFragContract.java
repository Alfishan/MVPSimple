package com.alfishan.mvpsimple.ui.fragments.demo;


import com.alfishan.mvpsimple.base.BaseView;

/**
 * Created by root on 17/4/17.
 */

public class DemoFragContract {

    public interface Presenter{
        void initPresenter();
        void onGreetingClicks();


    }

    public interface View extends BaseView {
        void initView();
        void updateGreetings(String msg);
    }
}
