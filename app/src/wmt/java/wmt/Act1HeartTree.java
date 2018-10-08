package wmt;

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

    String wmt = "   18年08月17号,我们因为网易蜗牛读书七夕CP阅读活动而认识\n\n" +
            "   通过妳关联的微博了解到妳,发现妳看书特别认真,做笔记,写书评,很是崇拜\n\n" +
            "   不过网易蜗牛的即时聊天功能做的很差,经常漏消息\n\n" +
            "   我也因此和妳加了微信好友\n\n" +
            "   180922周六我在公寓4楼健身,玩耍,妳找我聊天,聊得很开心\n\n" +
            "   妳突然提议要不要网恋试试,其实我一直挺欣赏喜欢妳\n\n" +
            "   妳这个提议我当然我条件积极的配合咯\n\n" +
            "   180924中秋节那天,妳给我打电话,说实话很开心也有点紧张\n\n" +
            "   我没有表现出很惊喜和很开心让妳有些失望了\n\n" +
            "   181001-1004国庆和朋友玩了4天,期间让妳感到被忽视了,妳心里一定想了很多吧\n\n" +
            "   我挺内疚的,还不太会安慰妳\n\n" +
            "   不过我马上就能飞过去见妳了,好想给妳一个大大的拥抱\n\n" +
            "   想妳做我的怀中猫";

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
