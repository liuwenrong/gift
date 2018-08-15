package roger.am;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lwr.gift.R;
import com.roger.BaseActivity;

import cn.pedant.SweetAlert.SweetAlertDialog;
import roger.utils.loader.GlideImageLoader;

/**
 * des:
 *
 * @author liuwenrong
 * @version 1.0, 8/9/2018
 */
public class Act9DialogLove extends BaseActivity {

    public SweetAlertDialog mDialog;
    Button mBtnNo;
    String[] contents = {"我妈会游泳", "保大", "工资上交", "房产证写妳的名字", "家务全包", "买买买", "护犊子", "宠妳", "不跟妳吵架,会撒娇,会卖萌", "生气我哄", "媳妇儿不可能错", "答应我吧", "答应我吧"};
    int index = 0;
    ImageView mIvGif;
    public Button mBtnOk;
    //    String mPath = "http://upload-images.jianshu.io/upload_images/1367153-ec52114ac51941f6.gif?imageMogr2/auto-orient/strip%7CimageView2/2/w/1080/q/50"; // 撩小姐姐git

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.act_dialog_love);
        mBtnOk = findViewById(R.id.btn_ok);
        mBtnNo = findViewById(R.id.btn_no);

        mIvGif = findViewById(R.id.iv_gif);
        new GlideImageLoader().displayImage(getContext(), R.mipmap.ic_xiaojiejie, mIvGif);

        mBtnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (index >= contents.length) {
                    index = 0;
                }

                mDialog = new SweetAlertDialog(getContext())
                            .setTitleText("ar咩");

                mDialog.setContentText(contents[index++]).show();

            }
        });

        mBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDialog = new SweetAlertDialog(getContext())
                        .setTitleText("挖槽!").setContentText("真的吗,真的答应了咩?")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                        mDialog = new SweetAlertDialog(getContext())
                                .setTitleText("真开心")
                                .setContentText("记得微信找我聊天,别让我等太久")
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                                       // 跳转gif2
                                        startActivity(new Intent(getContext(), Act9Gif2.class));
                                    }
                                });
                        mDialog.show();

                    }
                });

                mDialog.show();
            }
        });
    }
}
