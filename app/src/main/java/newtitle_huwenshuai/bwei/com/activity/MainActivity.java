package newtitle_huwenshuai.bwei.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import newtitle_huwenshuai.bwei.com.R;

/**
 * 姓名:胡文帅
 * 时间:2017/2/16
 * 邮箱：
 * 备注：加载页
 */

public class MainActivity extends Activity{


    private ImageView iv;

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Intent intent=new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv_welcome);
        handler.sendEmptyMessageDelayed(0,3000);
    }
}
