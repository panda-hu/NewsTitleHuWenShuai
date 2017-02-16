package utils.bwei.com;

import android.content.Context;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import myinterface.bwei.com.CallbackData;

/**
 * 姓名:胡文帅
 * 时间:2017/2/11
 * 邮箱：
 * 备注：
 */
public class NetWorkUtils {

    //解析数据的方法
    public static <T>void loadDataFromServer(String url, final Class<T> mClass, final CallbackData callbackData){
        x.http().get(new RequestParams(url), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                final T t = gson.fromJson(result, mClass);
                //谁初始化的,就调用谁的
                callbackData.succer(t);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    //判断网络类型的方法
    public static boolean getType(Context context){
        if(context!=null){

        }
        return false;
    }

}
