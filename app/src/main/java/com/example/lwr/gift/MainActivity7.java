package com.example.lwr.gift;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity7 extends Activity {

	private final int time = 0;
	private int int_time = 10;
	private Handler handler = new Handler(){

		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case time:

				int_time--;
				Toast.makeText(getApplicationContext(), ""+int_time, 0).show();
				if(int_time == 0){

					Toast.makeText(getApplicationContext(), "算了,我还是不重启了......", 1).show();
					Toast.makeText(getApplicationContext(), getResources().getText(R.string.happy_day2), 1).show();
					handler.sendEmptyMessageDelayed(1, 5000);


				}else{

					handler.sendEmptyMessageDelayed(time, 2000);

				}

				break;

			case 1:


				break;
			}
		};

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main7);
		Toast.makeText(getApplicationContext(), "手机将在10秒后重启,妳阻止不了的,哈哈...", 0).show();
		handler.sendEmptyMessageDelayed(time, 2000);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
