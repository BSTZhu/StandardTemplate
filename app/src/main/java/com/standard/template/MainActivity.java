package com.standard.template;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.standard.library.base.BaseActicity;

public class MainActivity extends BaseActicity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setAllowFullScreen(false);
        setSteepStatusBar(true);
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_main);
        setTitleString("首页");
        setTitleColor(R.color.text_white);
        setTitleBackground(R.color.common_orange);
        hideBack();
        setListener();
    }

    public void setListener() {
//        mBinding.btnSure.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                AnimatorUtils.translationY(mBinding.btnSure, 1000, -200);
////                AnimatorUtils.alpha(mBinding.btnSure, 4000, 1.0f, 0.3f, 1.0f);
////                AnimatorUtils.rotationX(mBinding.btnSure, 4000, 0.0f, 360.0f, 0.0f);
////                AnimatorUtils.scaleX(mBinding.btnSure, 4000, 1.0f, 1.5f, 1.0f, 1.5f, 1.0f);
//                showToast("点了我");
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            Thread.sleep(10000);
////                            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
////                            startActivity(intent);
//                            if (!AppUtils.isAppForeground(MainActivity.this)) {
//                                ActivityManager am = (ActivityManager) MainActivity.this.getSystemService(Context.ACTIVITY_SERVICE);
//                                am.moveTaskToFront(getTaskId(), ActivityManager.MOVE_TASK_WITH_HOME);
//                            }
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }).start();
//            }
//        });

    }
}
