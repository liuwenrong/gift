package anim.tools;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import com.bumptech.glide.request.animation.ViewPropertyAnimation;

/**
 * AnimationSet animationSet = ..
 * 调用以下的配置方法
 * view.startAnimation(animationSet)
 * Created by liuwenrong on 2016/12/15.
 */
public class AnimUtils {

    /**
     * @param animationSet = new AnimationSet(true) //true表示使用Animation的interpolator,false则用自己的
     * @param durationMillis 动画时间
     */
    public static AnimationSet configAlphaAnimationSet(AnimationSet animationSet, long durationMillis){

        //创建一个AlphaAnimation对象,参数从完全透明0到完全不透明1
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);

        //设置执行时间
        alphaAnimation.setDuration(durationMillis);
        alphaAnimation.setRepeatCount(1);

        animationSet.addAnimation(alphaAnimation);

        return animationSet;

    }

    /**
     * 缩放的动画
     * @param animationSet
     * @param durationMillis
     * @return
     */
    public static AnimationSet configScaleAnimationSet(AnimationSet animationSet, long durationMillis){

        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 0.8f, 0, 0.8f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(durationMillis);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;

    }

    public static AnimationSet configTranslateAnimationSet(AnimationSet animationSet, long durationMillis){

//        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.ABSOLUTE, 0f, Animation.ABSOLUTE, 0.5f, Animation.ABSOLUTE, 0f, Animation.ABSOLUTE, 0.5f);
//        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 1.0f, Animation.RELATIVE_TO_PARENT, 1f, Animation.RELATIVE_TO_PARENT, 1f);
//        TranslateAnimation translateAnimation = new TranslateAnimation(-50, 0, 0, 0); //看不到效果
        TranslateAnimation translateAnimation = new TranslateAnimation(0f, 0f, 0f, -80f); //看不到效果
        translateAnimation.setDuration(durationMillis);
        animationSet.addAnimation(translateAnimation);
        return animationSet;

    }

    public static void alphaAnimation(View view, long durationMillis){
        //创建一个AnimationSet对象,参数为Boolean
        //true表示使用Animation的interpolator,false则用自己的
        AnimationSet animationSet = new AnimationSet(true);

        //创建一个AlphaAnimation对象,参数从完全透明0到完全不透明1
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);

        //设置执行时间
        alphaAnimation.setDuration(durationMillis);

        animationSet.addAnimation(alphaAnimation);
        view.startAnimation(animationSet);
    }

    public static AnimationSet configRotateAnimationSet(AnimationSet animationSet, long durationMillis){

        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(durationMillis);
        animationSet.addAnimation(rotateAnimation);
        return animationSet;

    }

    /**
     * 沿Y轴旋转360度,并且透明度和大小根据角度渐变
     * @param view
     * @param durationMillis
     */
    public static void animAlphaRotateYScaleXY(final View view, long durationMillis){
        ObjectAnimator anim = ObjectAnimator
                        .ofFloat(view, "rotationY", 0f, 360f)//X/Y轴旋转一周
                        .setDuration(durationMillis);
                anim.start();
                anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float cVal = (Float) animation.getAnimatedValue() / 360;
                        view.setAlpha(cVal);
                        view.setScaleX(cVal);
                        view.setScaleY(cVal);
                    }
                });
    }
    /**
     * 沿X轴旋转360度,并且透明度和大小根据角度渐变
     * @param view
     * @param durationMillis
     */
    public static void animAlphaRotateXScaleXY(final View view, long durationMillis){
        ObjectAnimator anim = ObjectAnimator
                        .ofFloat(view, "rotationX", 0f, 360f)//X/Y轴旋转一周
                        .setDuration(durationMillis);
                anim.start();
                anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float cVal = (Float) animation.getAnimatedValue() / 360;
                        view.setAlpha(cVal);
                        view.setScaleX(cVal*2);
                        view.setScaleY(cVal*2);
                    }
                });
    }

    public static ViewPropertyAnimation.Animator getAlphaAnimator(final long durationMillis){
        ViewPropertyAnimation.Animator animationObject = new ViewPropertyAnimation.Animator() {
            @Override
            public void animate(View view) {
                // if it's a custom view class, cast it here
                // then find subviews and do the animations
                // here, we just use the entire view for the fade animation
                // 渐显动画
                view.setAlpha( 0f );

                ObjectAnimator fadeAnim = ObjectAnimator.ofFloat( view, "alpha", 0f, 1f );
                fadeAnim.setDuration(durationMillis);
                fadeAnim.start();
            }
        };
        return animationObject;
    }

}
