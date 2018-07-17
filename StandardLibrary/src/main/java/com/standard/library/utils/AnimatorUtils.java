package com.standard.library.utils;

import android.animation.ObjectAnimator;
import android.view.View;

public class AnimatorUtils {

    /**
     * 横向移动
     *
     * @param target   需要动画的控件
     * @param duration 动画时间
     * @param values   动画移动的区间 例：0f,100f,200f,-100f
     * @return ObjectAnimator对象
     */
    public static ObjectAnimator translationX(View target, long duration, float... values) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "translationX", values);
        animator.setDuration(duration).start();
        return animator;
    }

    /**
     * 纵向移动
     *
     * @param target   需要动画的控件
     * @param duration 动画时间
     * @param values   动画移动的区间 例：0f,100f,200f,-100f
     * @return ObjectAnimator对象
     */
    public static ObjectAnimator translationY(View target, long duration, float... values) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "translationY", values);
        animator.setDuration(duration).start();
        return animator;
    }

    /**
     * X轴缩放
     *
     * @param target   需要动画的控件
     * @param duration 动画时间
     * @param values   动画缩放的区间 例：1.0f, 1.5f, 0.5f
     * @return ObjectAnimator对象
     */
    public static ObjectAnimator scaleX(View target, long duration, float... values) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "scaleX", values);
        animator.setDuration(duration).start();
        return animator;
    }

    /**
     * Y轴缩放
     *
     * @param target   需要动画的控件
     * @param duration 动画时间
     * @param values   动画缩放的区间 例：1.0f, 1.5f, 0.5f
     * @return ObjectAnimator对象
     */
    public static ObjectAnimator scaleY(View target, long duration, float... values) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "scaleY", values);
        animator.setDuration(duration).start();
        return animator;
    }

    /**
     * X轴旋转
     *
     * @param target   需要动画的控件
     * @param duration 动画时间
     * @param values   动画旋转的区间 例：0.0f, 90.0f, 180.0f,360.0f
     * @return ObjectAnimator对象
     */
    public static ObjectAnimator rotationX(View target, long duration, float... values) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "rotationX", values);
        animator.setDuration(duration).start();
        return animator;
    }

    /**
     * Y轴旋转
     *
     * @param target   需要动画的控件
     * @param duration 动画时间
     * @param values   动画旋转的区间 例：0.0f, 90.0f, 180.0f,360.0f
     * @return ObjectAnimator对象
     */
    public static ObjectAnimator rotationY(View target, long duration, float... values) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "rotationY", values);
        animator.setDuration(duration).start();
        return animator;
    }

    /**
     * 透明度
     *
     * @param target   需要动画的控件
     * @param duration 动画时间
     * @param values   动画移动的区间 例：0.1f, 0.3f, 0.5f,1.0f
     * @return ObjectAnimator对象
     */
    public static ObjectAnimator alpha(View target, long duration, float... values) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "alpha", values);
        animator.setDuration(duration).start();
        return animator;
    }
}
