package com.standard.library.base;

import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.standard.library.R;

public abstract class BaseActicity extends AppCompatActivity {

    /**
     * 日志输出标志
     **/
    protected final String TAG = this.getClass().getSimpleName();

    private RelativeLayout rl_title;
    private TextView tv_title;
    private ImageView iv_back;
    private FrameLayout fl_container;
    private LinearLayout ll_base;
    private ViewGroup mContentView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base);
        mContentView = (ViewGroup) findViewById(android.R.id.content);
        //初始化base控件
        initBaseView(mContentView);
    }

    @Override
    public void setContentView(int layoutResID) {
        if (ll_base != null) {
            View view = LayoutInflater.from(this).inflate(layoutResID, ll_base, false);
            fl_container.setId(android.R.id.content);
            mContentView.setId(View.NO_ID);
            fl_container.removeAllViews();
            fl_container.addView(view);
        }
    }

    private void initBaseView(View view) {
        ll_base = (LinearLayout) view.findViewById(R.id.ll_base);
        rl_title = (RelativeLayout) view.findViewById(R.id.rl_title);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        iv_back = (ImageView) view.findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        fl_container = (FrameLayout) view.findViewById(R.id.fl_container);
    }

    /**
     * [沉浸状态栏]
     */
    private void steepStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    protected void showBack() {
        iv_back.setVisibility(View.VISIBLE);
    }

    protected void hideBack() {
        iv_back.setVisibility(View.GONE);
    }

    protected void setTitleString(String title) {
        tv_title.setText(title);
    }

    public void setTitleColor(int id) {
        if (tv_title != null)
            tv_title.setTextColor(getResources().getColor(id));
    }

    protected void setTitleId(int id) {
        setTitleString(getString(id));
    }

    protected void setOnBackClickListener(View.OnClickListener listener) {
        iv_back.setOnClickListener(listener);
    }

    protected void setNoTitle() {
        if (ll_base != null)
            ll_base.setVisibility(View.GONE);
    }

    public void setTitleBackground(int id) {
        if (rl_title != null) {
            rl_title.setBackgroundColor(getResources().getColor(id));
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }

    /**
     * [简化Toast]
     *
     * @param msg
     */
    protected void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * [简化Toast]
     *
     * @param msg
     */
    protected void showToast(int msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * [是否允许全屏]
     *
     * @param allowFullScreen
     */
    public void setAllowFullScreen(boolean allowFullScreen) {
        //是否允许全屏
        if (allowFullScreen) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
    }

    /**
     * [是否设置沉浸状态栏]
     *
     * @param isSetStatusBar
     */
    public void setSteepStatusBar(boolean isSetStatusBar) {
        //是否沉浸状态栏
        if (isSetStatusBar) {
            steepStatusBar();
        }
    }

    /**
     * [是否允许屏幕旋转]
     *
     * @param isAllowScreenRotate
     */
    public void setScreenRoate(boolean isAllowScreenRotate) {
        //是否允许屏幕旋转
        if (!isAllowScreenRotate) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }
}
