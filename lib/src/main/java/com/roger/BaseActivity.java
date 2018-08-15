package com.roger;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * des:
 *
 * @author liuwenrong
 * @version 1.0, 8/9/2018
 */
public class BaseActivity extends AppCompatActivity {
    protected Context mContext;
    protected Activity mAct;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mAct = this;
    }
    protected Context getContext() {
        return mContext;
    }
    protected Activity getActivity() {
        return mAct;
    }
}
