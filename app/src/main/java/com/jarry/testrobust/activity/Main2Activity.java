package com.jarry.testrobust.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jarry.testrobust.R;
import com.meituan.robust.patch.annotaion.Modify;


public class Main2Activity extends AppCompatActivity {
    TextView textView;
    @Override
    @Modify
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = (TextView) findViewById(R.id.text);
        textView.setText(getStr());
    }
    @Modify
    public String getStr() {
        return "这是修复好的。。。。";
//        String str = "0";
//        for (int i = 0; i < 100; i++) {
//            str += i;
//        }
//        return "这是坏的badddd" + str;
    }
}
