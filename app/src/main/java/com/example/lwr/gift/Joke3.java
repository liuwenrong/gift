package com.example.lwr.gift;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class Joke3 extends Activity {

	WebView mWebView;
	ProgressBar pb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.joke3);
		/*mWebView = (WebView)findViewById(R.id.webView);
		pb = (ProgressBar) findViewById(R.id.pb);
		mWebView.loadUrl("http://tieba.baidu.com/p/4877821287");
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
//		WebSettings settings = mWebView.getSettings();
//		settings.setJavaScriptEnabled(true);
		// 优先缓存
//		mWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

		Toast.makeText(getApplicationContext(), "正在加载,请稍候...", Toast.LENGTH_SHORT).show();
		mWebView.setWebChromeClient(new WebChromeClient(){
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				// TODO Auto-generated method stub
				if (newProgress == 100) {
					// 网页加载完成
					pb.setVisibility(View.GONE);
				} else {
					// 加载中
					pb.setProgress(newProgress);
				}

			}
		});*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

/*	@Override
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
	}*/

}
