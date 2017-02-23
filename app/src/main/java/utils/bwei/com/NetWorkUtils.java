package utils.bwei.com;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import myinterface.bwei.com.CallbackNewsData;

/**
 * 姓名:胡文帅
 * 时间:2017/2/11
 * 邮箱：
 * 备注：
 */
public class NetWorkUtils {

    //解析数据的方法
    public static <T>void loadDataFromServer(String url, final Class<T> mClass, final CallbackNewsData callbacknewsData){
        x.http().get(new RequestParams(url), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                List<T> newsContents=new ArrayList<>();
                try {
                    JSONObject jsonobject=new JSONObject(result);
                    Iterator<String> keys = jsonobject.keys();
                    while(keys.hasNext()){
                        String next = keys.next();
                        JSONArray jsonArray = jsonobject.optJSONArray(next);
                        for (int i = 0; i <jsonArray.length() ; i++) {
                            JSONObject jsonObject1 = jsonArray.optJSONObject(i);
                            T t = gson.fromJson(jsonObject1.toString(), mClass);
                            newsContents.add(t);
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                callbacknewsData.succer(newsContents);
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
