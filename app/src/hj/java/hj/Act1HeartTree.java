package hj;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.lwr.gift.R;
import com.hanks.htextview.base.HTextView;

/**
 * des:
 *
 * @author liuwenrong
 * @version 1.0, 8/8/2018
 */
public class Act1HeartTree extends AppCompatActivity {

    String wmt = "   180309 18:09加微信好友,初识,慢慢的互相了解 \n \n " +
            "   180311 23：18 第一次听妳语音，很好听的声音，说家乡话也显得很亲切 \n \n " +
            "   180321 21：20 第一次微信语音通话，虽然有时很尬，但和你聊天很开心 \n \n" +
            "   180324 14：24 第一次打电话，好像每次都是妳主动，妳肯定是喜欢我了 哈哈[手动撑腰] [膨胀]  ";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_tree);
        final HTextView type = findViewById(R.id.type);
//        RichText.fromMarkdown(wmt).into(type);
        type.postDelayed(new Runnable() {
            @Override
            public void run() {
                type.animateText(wmt);
            }
        }, 12000);
    }
}
