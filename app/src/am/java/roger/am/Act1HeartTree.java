package roger.am;

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

    String am = "   16年11月25号20点,当时代表JV参加足球训练,161203足球比赛,这可能是我印象中我们第一次见面,我记得你和廖思维在观战聊天\n\n" +
            "   170118公司年会上,妳帅气炫酷的舞蹈让我路人转粉\n\n" +
            "   170304公司组织了东西冲穿越后来改成了真人CS\n\n" +
            "   171114那天妳生日,我们几个小伙伴去轰趴,吃零食,打麻将,玩小游戏,唱歌,玩的特别开心\n\n" +
            "   171125公司组织去清远,那天晚上妳,瑶瑶,毛毛还有WC我们一起打牌吃零食\n\n" +
            "   171202我们去了深圳湾野炊,当时大家买的零食,只有带了自己亲手煲的汤,真是个心灵手巧的小菇凉,打牌玩游戏,妳输了,亲了我一下,一脸的口水,我被占便宜了\n\n" +
            "   171225圣诞节交换礼物\n\n" +
            "   180303去了万驰家和毛毛家撸猫\n\n" +
            "   180311我们和万驰瑶瑶去了黑暗中对话,很有意义的活动,你们都是我最信任的小伙伴\n\n" +
            "   180317我们和毛毛去逛了宜家\n\n" +
            "   180501劳动节你去了人妖国,还给我们带来了海苔\n\n" +
            "   180513我们几个去了Ins展\n\n" +
            "   180722-30妳调休去了俄罗斯,给我们带来了巧克力";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_tree);
        final HTextView type = findViewById(R.id.type);
//        RichText.fromMarkdown(am).into(type);
        type.postDelayed(new Runnable() {
            @Override
            public void run() {
                type.animateText(am);
            }
        }, 12000);
    }
}
