package com.example.lwr.gift;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PicMusic2cc extends Activity {

	private TextView tv_click_5, tv_click_2, tv_click_1, tv_click_0;
	private ImageView iv_cc;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_cc1_2);
		tv_click_5 = (TextView) findViewById(R.id.tv_click_5);
		tv_click_2 = (TextView) findViewById(R.id.tv_click_2);
		tv_click_1 = (TextView) findViewById(R.id.tv_click_1);
		tv_click_0 = (TextView) findViewById(R.id.tv_click_0);
		iv_cc = (ImageView) findViewById(R.id.image_view);
	}


	public void onClick4cc1_2(View v){

		switch (v.getId()) {
		case R.id.tv_click_5:

			Toast.makeText(getApplicationContext(), "�򵥵���", 0).show();
			tv_click_2.setVisibility(View.VISIBLE);

			break;

		case R.id.tv_click_2:

			Toast.makeText(getApplicationContext(), "����СС�Ĺذ�", 0).show();
			tv_click_1.setVisibility(View.VISIBLE);
			tv_click_0.setVisibility(View.VISIBLE);

			break;
		case R.id.tv_click_1:
			
			Toast.makeText(getApplicationContext(), "�������Ċ�", 0).show();
			iv_cc.setVisibility(View.VISIBLE);
			iv_cc.setImageResource(R.drawable.cc_1);
			
			break;
		case R.id.tv_click_0:
			
			Toast.makeText(getApplicationContext(), "�������Ċ�", 0).show();
			iv_cc.setImageResource(R.drawable.cc_0);
			
			break;
		default:
			break;
		}


	}

}
