package com.yixincaipiao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.VolleyError;
import com.yixincaipiao.base.BaseActivity;
import com.yixincaipiao.network.Http;
import com.yixincaipiao.network.NetRequest;
import com.yixincaipiao.utils.L;

public class MainActivity extends BaseActivity {

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }

    @Override
    protected void getData() {
        String myUrl = "";

        Http.aSyncGet(this, null, myUrl, null, new NetRequest.NetRequestListener() {
            @Override
            public void onAccessComplete(boolean success, String object, VolleyError error, String flag) {
                L.i("data   " + object);
            }
        });
    }

}
