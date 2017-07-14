package com.alfishan.mvpsimple.base;

/**
 * Created by root on 17/4/17.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public abstract class BaseFragment extends Fragment implements BaseView {

    private BaseActivity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            this.activity = (BaseActivity) context;

        }
    }

    public BaseActivity getBaseActivity() {
        return activity;
    }

    @Override
    public void onDetach() {
        activity = null;
        super.onDetach();
    }

    @Override
    public String getStringById(int id) {
        return getString(id);
    }

    @Override
    public String getStringById(int id, String param1) {
           return activity.getStringById(id,param1);
    }

    @Override
    public String getStringById(int id, String param1, String param2) {
        return activity.getStringById(id,param1,param2);
    }

    @Override
    public void showProgress() {
        if (activity != null) {
            activity.showProgress();
        }
    }

    @Override
    public void hideProgress() {
        if (activity != null) {
            activity.hideProgress();
        }
    }

    @Override
    public void showToast(String errorMessage) {
        if (activity != null) {
            activity.showToast(errorMessage);
        }
    }
}
