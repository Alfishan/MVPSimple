package com.alfishan.mvpsimple.ui.activities.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.alfishan.mvpsimple.R;
import com.alfishan.mvpsimple.base.BaseActivity;
import com.alfishan.mvpsimple.ui.fragments.demo.DemoFragment;

public class MainActivity extends BaseActivity implements MainContract.View {


    MainPresenter mPresenter;
    FragmentManager fragmentManager;
    FrameLayout mFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mPresenter = new MainPresenter();
        mPresenter.attachView(this);
        mPresenter.initPresenter();

    }

    @Override
    public void initActivity() {
        fragmentManager = getSupportFragmentManager();
        mFrameLayout = (FrameLayout) findViewById(R.id.fragment_container);
        Snackbar.make(mFrameLayout, "Please Click FAB to open Demo Fragment", Snackbar.LENGTH_INDEFINITE).show();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onFabClick();
            }
        });
    }

    @Override
    public void openDemoFrag() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment currentFragment = fragmentManager.findFragmentById(R.id.fragment_container);

        if (currentFragment == null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK)
                    .replace(R.id.fragment_container, DemoFragment.getIntance(), DemoFragment.MyTAG)
                    .addToBackStack(DemoFragment.MyTAG).commit();
        } else if (currentFragment.getTag().equals(DemoFragment.MyTAG)) {
            showToast("Demo Fragment is already showing!!!!");

        }
    }


    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }
}
