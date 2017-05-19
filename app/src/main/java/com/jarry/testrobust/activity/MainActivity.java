package com.jarry.testrobust.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jarry.testrobust.R;
import com.meituan.robust.Patch;
import com.meituan.robust.PatchExecutor;
import com.meituan.robust.RobustCallBack;

/**
 * 测试Robust
 */
public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        Button patch = (Button) findViewById(R.id.patch);
        //beigin to patch
        patch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PatchExecutor(getApplicationContext(), new PatchManipulateImp(), new Callback()).start();

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));

            }
        });
    }

    //patch  data report
    class Callback implements RobustCallBack {

        @Override
        public void onPatchListFetched(boolean result, boolean isNet) {
            System.out.println(" robust arrived in onPatchListFetched");
        }

        @Override
        public void onPatchFetched(boolean result, boolean isNet, Patch patch) {
            System.out.println(" robust arrived in onPatchFetched");
        }

        @Override
        public void onPatchApplied(boolean result, Patch patch) {
            System.out.println(" robust arrived in onPatchApplied");

        }

        @Override
        public void logNotify(String log, String where) {
            System.out.println(" robust arrived in logNotify");
        }

        @Override
        public void exceptionNotify(Throwable throwable, String where) {
            System.out.println(" robust arrived in exceptionNotify");
        }
    }

}
