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
public class HeartTreeAct extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_tree);
        final HTextView type = findViewById(R.id.type);
        type.postDelayed(new Runnable() {
            @Override
            public void run() {
                type.animateText(getApplicationContext().getResources().getString(R.string.am));
            }
        }, 12000);
    }
}
