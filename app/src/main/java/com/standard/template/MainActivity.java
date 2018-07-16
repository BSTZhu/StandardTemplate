package com.standard.template;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.standard.library.base.BaseActicity;

public class MainActivity extends BaseActicity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAllowFullScreen(true);
        setSteepStatusBar(true);
        setScreenRoate(true);
    }

    @Override
    public void initPrams(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void doBusiness(Context mContext) {

    }
}
