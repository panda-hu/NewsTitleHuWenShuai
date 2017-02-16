package utils.bwei.com;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;

/**
 * 姓名:胡文帅
 * 时间:2017/2/11
 * 邮箱：
 * 备注：
 */
public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(configuration);
        x.Ext.init(this);
    }
}
