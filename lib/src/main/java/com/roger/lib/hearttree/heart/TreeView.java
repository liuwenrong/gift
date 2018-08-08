package com.roger.lib.hearttree.heart;


import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by John on 2017/8/26.
 */

public class TreeView extends View {
    private static Tree tree;

    public TreeView(Context context) {
        super(context);
    }

    public TreeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //如果有自定义属性的话，需要添加：
    public TreeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (tree == null) {
            tree = new Tree(getWidth(), getHeight());
        }
        tree.draw(canvas);

        // 这个函数只是标记view为invalidate状态，并不会马上触发重绘；
        // 标记invalidate状态后，下一个绘制周期(约16s), 会回调onDraw()；
        // 故此，要想动画平滑流畅，tree.draw(canvas)需在16s内完成。
        postInvalidate();
    }
}
