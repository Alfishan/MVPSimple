package com.alfishan.mvpsimple.ui.fragments.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alfishan.mvpsimple.R;
import com.alfishan.mvpsimple.base.BaseFragment;


public class DemoFragment extends BaseFragment implements DemoFragContract.View {


    public static String MyTAG="DemoFrag";

    View mView;
    TextView mTextView;
    DemoFragPresenter mPresenter;
    public DemoFragment() {
    }

    public static Fragment getIntance(){
        return new DemoFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         mView =inflater.inflate(R.layout.fragment_demo, container, false);
        mPresenter=new DemoFragPresenter();
        mPresenter.attachView(this);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.initPresenter();
    }

    @Override
    public void updateGreetings(String msg) {
        if (mTextView != null) {
            mTextView.setText(msg);
        }
    }

    @Override
    public void initView() {
        mTextView=(TextView) mView.findViewById(R.id.tv_greetings);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onGreetingClicks();
            }
        });
    }

    @Override
    public void onDestroyView() {
        mPresenter.detachView();
        super.onDestroyView();
    }

}
