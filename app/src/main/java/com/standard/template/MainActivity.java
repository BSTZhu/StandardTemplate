package com.standard.template;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.standard.library.base.BaseActicity;
import com.standard.template.databinding.ActivityMainBinding;

public class MainActivity extends BaseActicity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setAllowFullScreen(false);
        setSteepStatusBar(true);
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setTitleString("首页");
        setTitleColor(R.color.common_orange);
        hideBack();
    }

    @Override
    public void setListener() {

    }
}
