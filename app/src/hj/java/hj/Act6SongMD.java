package hj;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.lwr.gift.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * des:
 *
 * @author liuwenrong
 * @version 1.0, 8/8/2018
 */
public class Act6SongMD extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act2_markdown);
        startActivity(new Intent(this, ActGuide.class));

//        Toast.makeText(getApplicationContext(), "哈哈,这里啥也没有......", Toast.LENGTH_LONG).show();

        TextView tvMarkdown = findViewById(R.id.tv_markdown);
//        String md = "file:///android_asset/wmt.md";
        tvMarkdown.setText("哈哈,这里啥也没有......");
        InputStream inputStream = null;
/*        try {
            inputStream = getAssets().open("song_mv.md");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String md = readTextFile(inputStream);

        RichText.fromMarkdown(md).into(tvMarkdown);*/
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
