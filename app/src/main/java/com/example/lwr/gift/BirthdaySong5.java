package com.example.lwr.gift;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BirthdaySong5 extends Activity {

	WebView mWebView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.birthday_mv4);
		mWebView = (WebView)findViewById(R.id.webView);
		mWebView.loadUrl("http://acsing.kugou.com/sing7/static/staticPub/mobile/PlayScore/views/index.html?sign=8d62b52f889fdf558f51f02f2b7acc16&data=Mjg1NDUyNTQ2&channelId=0");
		mWebView.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				//返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
//				view.loadUrl(url);
				return true;
			}

		});

		//启用支持javascript
		WebSettings settings = mWebView.getSettings();
		settings.setJavaScriptEnabled(true);
		// 优先缓存
		mWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if(keyCode== KeyEvent.KEYCODE_BACK)
		{
			if(mWebView.canGoBack())
			{
				mWebView.goBack();//返回上一页面
				return true;
			}
			else
			{
				System.exit(0);//退出程序
			}
		}
		return super.onKeyDown(keyCode, event);
	}

}
