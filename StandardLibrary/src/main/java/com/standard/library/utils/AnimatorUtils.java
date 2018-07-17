package com.standard.library.utils;

import android.animation.ObjectAnimator;
import android.view.View;

public class AnimatorUtils {

    public static ObjectAnimator translationX(View target, long duration, float... values) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "translationX", values);
        animator.setDuration(duration).start();
        return animator;
    }

    public static ObjectAnimator translationY(View target, long duration, float... values) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "translationY", values);
        animator.setDuration(duration).start();
        return animator;
    }

    public static ObjectAnimator scaleX(View target, long duration, float... values) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "scaleX", values);
        animator.setDuration(duration).start();
        return animator;
    }

    public static ObjectAnimator scaleY(View target, long duration, float... values) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "scaleY", values);
        animator.setDuration(duration).start();
        return animator;
    }

    public static ObjectAnimator rotationX(View target, long duration, float... values) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "rotationX", values);
        animator.setDuration(duration).start();
        return animator;
    }

    public static ObjectAnimator rotationY(View target, long duration, float... values) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "rotationY", values);
        animator.setDuration(duration).start();
        return animator;
    }

    public static ObjectAnimator alpha(View target, long duration, float... values) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "alpha", values);
        animator.setDuration(duration).start();
        return animator;
    }
}
