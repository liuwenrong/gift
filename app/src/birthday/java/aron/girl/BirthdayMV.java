package aron.girl;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.lwr.gift.R;

import aron.Utils.ELogger;

public class BirthdayMV extends Activity {

	WebView mWebView;
	ProgressBar pb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.birthday_mv4);
		mWebView = (WebView)findViewById(R.id.webView);
		pb = (ProgressBar) findViewById(R.id.pb);
		mWebView.loadUrl("http://v.douyin.com/jcEj6j/");
//		mWebView.loadUrl("http://m.neihanshequ.com/share/group/52396792357/?iid=6141659324&app=joke_essay");// 内涵段子 不可用了
		mWebView.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
				//返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
/*				view.loadUrl(request.getUrl().toString());
				return true;*/
				return false;
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
				ELogger.d("onProgressChanged----------liuwenrong--2019/4/23--: newPro = " + newProgress);
				if (newProgress == 100) {
					// 网页加载完成
					pb.setVisibility(View.GONE);
				} else {
					// 加载中
					pb.setProgress(newProgress);
				}

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}



}
