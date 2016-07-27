package com.example.lsx.shanping;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button mUtilsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUtilsButton= (Button) findViewById(R.id.activity_main_button);
        mUtilsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpUtils http = new HttpUtils();
                http.send(HttpRequest.HttpMethod.GET,
                        "http://tapi.test.tuoguibao.com/basicapi.php?ac=1002&mobile=18562172800&password=123456",
                        new RequestCallBack<String>(){
                            @Override
                            public void onLoading(long total, long current, boolean isUploading) {
                               // testTextView.setText(current + "/" + total);
                                Log.d(TAG, "onLoading: 加载是否成功");
                            }

                            @Override
                            public void onSuccess(ResponseInfo<String> responseInfo) {
                                //textView.setText(responseInfo.result);
                                Log.i("jasonTag", responseInfo.result);
                            }

                            @Override
                            public void onStart() {
                            }

                            @Override
                            public void onFailure(HttpException error, String msg) {
                                Log.i("jasonTag", "网络连接失败");
                            }
                        });

            }
        });

    }
}
