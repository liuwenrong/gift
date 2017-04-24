package com.example.lwr.gift;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class BirthdayMV4 extends Activity {

	WebView mWebView;
	ProgressBar pb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.birthday_mv4);
		/*mWebView = (WebView)findViewById(R.id.webView);
		pb = (ProgressBar) findViewById(R.id.pb);
		mWebView.loadUrl("http://m.neihanshequ.com/share/group/52396792357/?iid=6141659324&app=joke_essay");
		mWebView.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
				// TODO Auto-generated method stub
				//返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
//				view.loadUrl(request.getUrl().toString());
				return true;
			}

		});

		//启用支持javascript
		WebSettings settings = mWebView.getSettings();
		settings.setJavaScriptEnabled(true);
		// 优先缓存
		mWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

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



}
