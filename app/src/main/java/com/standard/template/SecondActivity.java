package com.standard.template;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.standard.library.base.BaseActicity;
import com.standard.library.utils.AnimatorUtils;
import com.standard.template.databinding.ActivityMainBinding;

public class SecondActivity extends BaseActicity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setAllowFullScreen(false);
        setSteepStatusBar(false);
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setTitleString("第二页");
        setTitleColor(R.color.text_white);
        setTitleBackground(R.color.common_orange);
        hideBack();
        setListener();
        AnimatorUtils.translationY(mBinding.btnSure, 1000, -200);
    }

    public void setListener() {
        mBinding.btnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorUtils.translationY(mBinding.btnSure, 1000, 200);
//                AnimatorUtils.translationY(mBinding.btnSure, 1000, -200);
//                AnimatorUtils.alpha(mBinding.btnSure, 4000, 1.0f, 0.3f, 1.0f);
//                AnimatorUtils.rotationX(mBinding.btnSure, 4000, 0.0f, 360.0f, 0.0f);
//                AnimatorUtils.scaleX(mBinding.btnSure, 4000, 1.0f, 1.5f, 1.0f, 1.5f, 1.0f);
                showToast("点了我");
            }
        });
    }
}
