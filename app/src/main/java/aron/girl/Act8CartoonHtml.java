package aron.girl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.example.lwr.gift.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * des:
 * @author liuwenrong
 * @version 1.0, 8/8/2018
 */
public class Act8CartoonHtml extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*        setContentView(R.layout.act2_markdown);
        startActivity(new Intent(this, ActGuide.class));
        TextView tvMarkdown = findViewById(R.id.tv_markdown);
//        String md = "file:///android_asset/wmt.md";
*//*        InputStream inputStream = null;
        try {
            inputStream = getAssets().open("cartoon.md");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String md = readTextFile(inputStream);
        RichText.fromMarkdown(md).into(tvMarkdown);*//*

//        RichText.from(url).into(tvMarkdown);

        InputStream inputStream = null;
        try {
            inputStream = getAssets().open("cartoon.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String html = readTextFile(inputStream);
        RichText.fromHtml(html).into(tvMarkdown);*/


        setContentView(R.layout.activity_browser);
        WebView mWebView = (WebView) findViewById(R.id.webView);
//        initWeb();
        mWebView.loadUrl("file:////android_asset/cartoon.html");

    }

    private String readTextFile(InputStream inputStream) {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];

        int len;

        try {

            while ((len = inputStream.read(buf)) != -1) {

                outputStream.write(buf, 0, len);

            }

            outputStream.close();

            inputStream.close();

        } catch (IOException e) {

        }

        return outputStream.toString();

    }
}
