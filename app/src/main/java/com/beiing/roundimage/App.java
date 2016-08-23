package com.beiing.roundimage;

import android.app.Application;

import org.xutils.x;

/**
 * Created by chenliu on 2016/8/22 0022<br/>.
 * 描述：
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
