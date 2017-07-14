package com.alfishan.mvpsimple.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.alfishan.mvpsimple.customThings.MyProgressDialog;


/**
 * Created by root on 17/4/17.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private MyProgressDialog mProgressDialog;



    public void Init() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProgressDialog = new MyProgressDialog(BaseActivity.this);
        Init();

    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    public void showProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.ShowDialog(null);
        }
        else {
            showToast("showProgress is null");
        }
    }

    @Override
    public void hideProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.hideDialog();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

    }


    @Override
    public void showToast(String errorMessage) {

        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getStringById(int id) {
        return getString(id);
    }

    @Override
    public String getStringById(int id, String param1) {
        return getString(id,param1);
    }

    @Override
    public String getStringById(int id, String param1, String param2) {
        return getString(id,param1,param2);
    }

}
