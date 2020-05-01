package com.example.guideview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_target1, tv_target2;
    GuideOneDialog guideOneDialog;
    GuideTwoDialog guideTwoDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_target1 = findViewById(R.id.tv_target1);
        tv_target2 = findViewById(R.id.tv_target2);
        guideTwoDialog=new GuideTwoDialog(MainActivity.this,tv_target2);
        guideOneDialog = new GuideOneDialog(MainActivity.this, tv_target1, new GuideOneDialog.OnClickListener() {
            @Override
            public void onDismiss() {
                guideTwoDialog.show();
            }
        });
        guideOneDialog.show();
    }

}
