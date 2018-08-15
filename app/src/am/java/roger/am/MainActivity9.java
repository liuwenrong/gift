package roger.am;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.example.lwr.gift.R;
import com.hanks.htextview.base.AnimationListener;
import com.hanks.htextview.base.HTextView;

/**
 * des: So Cool 画心形图
 *
 * @author liuwenrong
 * @version 1.0, 8/6/2018
 */
public class MainActivity9 extends Activity {

    HTextView mType, mFade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9ar);
        Toast.makeText(getApplicationContext(), "嘿嘿,真的啥也没有了,"+getResources().getString(R.string.happy_day2)+"有妳的日子我也很开心", Toast.LENGTH_LONG).show();
        mType = findViewById(R.id.type);
//		mType.setOnClickListener(new ClickListener());
        mType.setAnimationListener(new SimpleAnimationListener(MainActivity9.this));
        mFade = findViewById(R.id.fade);
        mFade.setAnimationListener(new SimpleAnimationListener(this));

        mHTvs = new HTextView[]{mType, mFade};
        mHTvs[index].animateText(sentences[index]);
        index ++;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    HTextView[] mHTvs;

    String[] sentences = {"16年11月25号20点,当时代表JV参加足球训练,161203足球比赛,这可能是我们第一次见面,我记得你和廖思维在观战聊天",
            "Design is not just",
            "what it looks like and feels like.",
            "Design is how it works. \n- Steve Jobs",
            "Older people",
            "sit down and ask,",
            "'What is it?'",
            "but the boy asks,",
            "'What can I do with it?'. \n- Steve Jobs",
            "Swift",
            "Objective-C",
            "iPhone",
            "iPad",
            "Mac Mini", "MacBook Pro", "Mac Pro", "爱老婆", "老婆和女儿"};
    int index = 0;

    class ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v instanceof HTextView) {
                if (index + 1 >= sentences.length) {
                    index = 0;
                }
                ((HTextView) v).animateText(sentences[index++]);
            }
        }
    }

    class SimpleAnimationListener implements AnimationListener {

        private Context context;

        public SimpleAnimationListener(Context context) {
            this.context = context;
        }
        @Override
        public void onAnimationEnd(HTextView hTextView) {
//			Toast.makeText(context, "Animation finished", Toast.LENGTH_SHORT).show();
//			mType.performClick();
            if (index + 1 >= sentences.length) {
                index = 0;
            }
            mHTvs[index % (mHTvs.length)].animateText(sentences[index]);
            index ++;
        }
    }

}

