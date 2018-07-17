package com.standard.template;

import android.animation.ObjectAnimator;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.standard.library.base.BaseActicity;
import com.standard.library.utils.AnimatorUtils;
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
        setTitleColor(R.color.text_white);
        setTitleBackground(R.color.common_orange);
        hideBack();
        setListener();
    }

    public void setListener() {
        mBinding.btnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorUtils.translationX(mBinding.btnSure, 4000, 0f, 200f, 0f, -200f, 0f);
                AnimatorUtils.alpha(mBinding.btnSure, 4000, 1.0f, 0.3f, 1.0f);
                AnimatorUtils.rotationX(mBinding.btnSure, 4000, 0.0f, 360.0f, 0.0f);
                AnimatorUtils.scaleX(mBinding.btnSure, 4000, 1.0f, 1.5f, 1.0f, 1.5f, 1.0f);
                showToast("点了我");
            }
        });
    }
}
