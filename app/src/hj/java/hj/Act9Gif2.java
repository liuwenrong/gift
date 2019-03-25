package hj;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.example.lwr.gift.R;
import com.roger.BaseActivity;

/**
 * des:
 *
 * @author liuwenrong
 * @version 1.0, 8/9/2018
 */
public class Act9Gif2 extends BaseActivity {

    ImageView mIvGif;
    //    String mPath = "http://upload-images.jianshu.io/upload_images/1367153-ec52114ac51941f6.gif?imageMogr2/auto-orient/strip%7CimageView2/2/w/1080/q/50"; // 撩小姐姐git

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act9_dialog_2_gif);
        startActivity(new android.content.Intent(this, ActGuide.class));
/*        mIvGif = findViewById(R.id.iv_gif);
        new GlideImageLoader().displayImage(getContext(), R.mipmap.ic_love_heart, mIvGif);
        ImageView mIvGif2 = findViewById(R.id.iv_gif2);
        new GlideImageLoader().displayImage(getContext(), R.mipmap.ic_love_you, mIvGif2);*/

    }
}
