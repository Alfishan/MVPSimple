package com.alfishan.mvpsimple.ui.activities.main;


import com.alfishan.mvpsimple.base.BaseView;

/**
 * Created by root on 17/4/17.
 */

public class MainContract {


    public interface Presenter {
        void initPresenter();
        void onFabClick();

    }

    public interface View extends BaseView {
        void initActivity();
        void openDemoFrag();

    }
}
