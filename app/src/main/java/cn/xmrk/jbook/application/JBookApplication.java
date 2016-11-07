package cn.xmrk.jbook.application;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import cn.xmrk.jbook.helper.FontHelper;
import cn.xmrk.rkandroid.application.RKApplication;
import cn.xmrk.rkandroid.config.IRKConfig;
import okhttp3.OkHttpClient;

/**
 * Created by Au61 on 2016/7/7.
 */
public class JBookApplication extends RKApplication {

    @Override
    public IRKConfig getRKConfig() {

        return new IRKConfig() {
            @Override
            public boolean isDebug() {
                return true;
            }

            @Override
            public String getBaseUrl() {
                return null;
            }

            @Override
            public boolean isLeakWatch() {
                return true;
            }
        };
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initClient();
        FontHelper.loadTypeface();
    }

    /**
     * 配置okhttp的一些参数
     **/
    public void initClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }
}
