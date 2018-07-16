package com.standard.template;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.standard.library.base.BaseActicity;

public class MainActivity extends BaseActicity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_main);

        setAllowFullScreen(true);
        setSteepStatusBar(true);
        setScreenRoate(true);
    }

    @Override
    public void initPrams(Bundle bundle) {

    }

    @Override
    public void setListener() {

    }
}
