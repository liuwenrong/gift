package com.example.lwr.gift;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import anim.CircularAnim;

public class MainActivity extends AppCompatActivity {
    private TextView tv_time;
    private TextView hint;
    private ImageView ivClick;
    private MediaPlayer mp;//mediaPlayer对象
    private final int time = 0;

    private Handler handler = new Handler(){

        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case time:

                    String str_time = tv_time.getText().toString().trim();
                    int int_time = Integer.parseInt(str_time);
                    int_time--;
                    tv_time.setText(""+int_time);
                    if(int_time == 0){

                        Toast.makeText(getApplicationContext(), "哈哈哈哈哈哈...妳真的等了60s", 0).show();
                        handler.sendEmptyMessageDelayed(1, 5000);


                    }else{

                        handler.sendEmptyMessageDelayed(time, 1000);
                        if(int_time == 59) {
                            CircularAnim.show(ivClick).triggerView(hint).go();
                        }

                    }

                    break;

                case 1:

                    Toast.makeText(getApplicationContext(), "其实点击图片就可以跳转了...", 0).show();
                    goBirthday();

                    break;
            }
        };

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_time = (TextView) findViewById(R.id.tv_time);
        hint = (TextView) findViewById(R.id.hint);
        ivClick = (ImageView) findViewById(R.id.iv_click);

        handler.sendEmptyMessageDelayed(time, 1000);
//        CircularAnim.hide(tv_time).go();

//        mp=MediaPlayer.create(MainActivity.this, R.raw.beike);//创建mediaplayer对象
//        play();

    }
    private void play(){
        try{
//            mp.reset();
//            mp=MediaPlayer.create(MainActivity.this, R.raw.sound);//重新设置要播放的音频
            mp.start();//开始播放
            hint.setText("正在播放音频...");
//            play.setEnabled(false);
//            pause.setEnabled(true);
//            stop.setEnabled(true);
        }catch(Exception e){
            e.printStackTrace();//输出异常信息
        }
    }
    private void goCc1_2(){

        Intent intent = new Intent(this, PicMusic2cc.class);
        startActivity(intent);

    }

    private void goBirthday(){
        CircularAnim.fullActivity(MainActivity.this, hint)
                .colorOrImageRes(R.color.colorPrimary)
                .go(new CircularAnim.OnAnimationEndListener() {
                    @Override
                    public void onAnimationEnd() {
                        startActivity(new Intent(MainActivity.this, BirthdayMV4.class));
                    }
                });
//        Intent intent = new Intent(this, BirthdayMV4.class);
//        startActivity(intent);

    }

    public void onClick4Main(View v){

        switch (v.getId()) {
            case R.id.iv_click:
                goBirthday();
                break;
            case R.id.hint:
                CircularAnim.hide(ivClick).triggerView(v).go();
                break;
            case R.id.tv_time:
                CircularAnim.show(ivClick).triggerView(v).go();
                break;

            default:
                break;
        }

    }

    @Override
    protected void onDestroy() {
        if(mp.isPlaying()){
            mp.stop();
        }
        mp.release();//释放资源
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
