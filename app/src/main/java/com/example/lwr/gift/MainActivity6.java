package com.example.lwr.gift;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity6 extends Activity {

	private TextView tv_1, tv_2;
	private EditText et;

	private Handler handler = new Handler(){

		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 0:

				tv_2.setVisibility(View.VISIBLE);

				break;

			}
		};

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv_1 = (TextView) findViewById(R.id.tv_1);
		tv_2 = (TextView) findViewById(R.id.tv_2);
		et = (EditText) findViewById(R.id.et);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onClick4cc6(View v){

		switch (v.getId()) {
		case R.id.tv_send:

			String tx =  et.getText().toString().trim();

			tv_1.setText(tx);

			if( tx.contains("觽") ){

				tv_1.setVisibility(View.VISIBLE);
				handler.sendEmptyMessageDelayed(0, 1000);


			}


			break;

		default:
			break;
		}

	}

}
