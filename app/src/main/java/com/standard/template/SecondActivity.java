package com.standard.template;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.standard.library.base.BaseActicity;

public class SecondActivity extends BaseActicity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setAllowFullScreen(false);
        setSteepStatusBar(false);
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_second);
        setTitleString("第二页");
        setTitleColor(R.color.text_white);
        setTitleBackground(R.color.common_orange);
        hideBack();
        setListener();
    }

    public void setListener() {

    }
}
