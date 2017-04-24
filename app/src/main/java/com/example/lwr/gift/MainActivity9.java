package com.example.lwr.gift;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity9 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main9);
		Toast.makeText(getApplicationContext(), "嘿嘿,真的啥也没有了,"+getResources().getString(R.string.happy_day2)+"有妳的日子我也很开心", 1).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void animRun(final View view){
		ObjectAnimator anim = ObjectAnimator
				.ofFloat(view, "rotationY", 0f, 360f)//X/Y轴旋转一周
				.setDuration(2500);
		anim.start();
		anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
		{
			@Override
			public void onAnimationUpdate(ValueAnimator animation)
			{
				float cVal = (Float) animation.getAnimatedValue()/360;
				view.setAlpha(cVal);
				view.setScaleX(cVal);
				view.setScaleY(cVal);
			}
		});
	}

}
