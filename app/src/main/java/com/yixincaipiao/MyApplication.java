package com.yixincaipiao;

import android.app.Application;

import com.yixincaipiao.common.CommonConfig;
import com.yixincaipiao.imageloader.CheckImageLoaderConfiguration;
import com.yixincaipiao.network.NetRequest;

/**
 * Created by zyh on 2017/4/17.
 */

public class MyApplication extends Application {
    private static MyApplication mApplication;

    public static MyApplication Instance() {
        return mApplication;
    }

    public MyApplication() {
        mApplication = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        new CommonConfig(this); // 配置类
        new NetRequest(this); // 网络请求类
        // 初始化ImageLoader
        CheckImageLoaderConfiguration.checkImageLoaderConfiguration(this);
    }
}
