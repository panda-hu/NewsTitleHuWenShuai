package newtitle_huwenshuai.bwei.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import newtitle_huwenshuai.bwei.com.R;

/**
 * 姓名:胡文帅
 * 时间:2017/2/17
 * 邮箱：
 * 备注：
 */

public class WebViewActivity extends Activity{

    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        wv = (WebView) findViewById(R.id.wv);
        wv.setWebViewClient(new WebViewClient());
        wv.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        wv.getSettings().setJavaScriptEnabled(true);
        Bundle bundle = getIntent().getExtras();
        String url = bundle.getString("url");
        if(url!=null){
            wv.loadUrl(url);
        }

    }
}
