package com.example.lsx.shanping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Welcome.this, MainActivity.class);
                //从启动动画ui跳转到主ui
                startActivity(intent);
                finish(); // 结束启动动画界面
            }
        }, 2000); //启动动画持续3秒钟
    }
}
