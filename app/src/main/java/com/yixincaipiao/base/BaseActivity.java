package com.yixincaipiao.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.yixincaipiao.R;
import com.yixincaipiao.utils.L;
import com.yixincaipiao.utils.SystemBarTintManager;

/**
 * Created by Administrator on 2017/4/24.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        L.i("当前界面" + getClass().getName());
        initView();
        initStatusBarStyle();//默认使用浸入式状态栏
    }

    protected abstract void initView();

    protected abstract void getData();


    /**
     * 功能描述： 是使用设置状态栏颜色<br>
     * 创建者： jack<br>
     * 创建日期：2015年7月13日<br>
     *
     * @return
     */
    public boolean isUseTopBarColor() {
        return true;
    }

    /**
     * 功能描述：是否设置根视图的顶边距 <br>
     * 创建者： jack<br>
     * 创建日期：2015年7月15日<br>
     *
     * @return
     */
    public boolean isSetTopPaddding() {
        return true;
    }

    /**
     * 功能描述： 获取顶部状态栏颜色<br>
     * 创建者： jack<br>
     * 创建日期：2015年7月15日<br>
     *
     * @return
     */
    public int getTopBarColor() {
        return R.color.colorPrimary;//
    }

    protected int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public void initStatusBarStyle() {
        // 4.4+ 设置状态栏透明、设置状态栏的资源文件、在布局中做适配
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            if (isUseTopBarColor()) {
                SystemBarTintManager sbt = new SystemBarTintManager(this);
                sbt.setStatusBarTintEnabled(true);
                sbt.setStatusBarTintDrawable(getResources().getDrawable(getTopBarColor()));
            }
            if (isSetTopPaddding()) {
                getWindow().getDecorView().findViewById(android.R.id.content).setPadding(0, getStatusBarHeight(), 0, 0);
            }
        }
    }
}
