package com.alfishan.mvpsimple.customThings;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.Nullable;

public class MyProgressDialog {
    public static final String MSG_LOGIN = "Logging in. please wait...";
    public static final String MSG_REGISTER = "Registering. please wait...";
    public static final String MSG_WAIT = "Please wait...";
    private Context mContext;
    private ProgressDialog mProgressDialog;


    public MyProgressDialog() {
    }

    public MyProgressDialog(Context context) {
        mContext = context;
        mProgressDialog = new ProgressDialog(mContext);
    }

    public void ShowDialog(@Nullable String Msg) {
        if (Msg == null) {
            Msg = MSG_WAIT;
        }

        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(mContext);
            mProgressDialog.setCancelable(false);
        }
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
        mProgressDialog.setMessage(Msg);
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
    }

    public void hideDialog() {
        if (mProgressDialog != null) {

            if (mProgressDialog.isShowing())
                mProgressDialog.dismiss();
        }

    }
}
