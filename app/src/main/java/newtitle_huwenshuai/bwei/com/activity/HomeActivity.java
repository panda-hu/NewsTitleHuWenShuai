package newtitle_huwenshuai.bwei.com.activity;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import newtitle_huwenshuai.bwei.com.fragment.Fragment_Follow;
import newtitle_huwenshuai.bwei.com.fragment.Fragment_Home;
import newtitle_huwenshuai.bwei.com.fragment.Fragment_My;
import newtitle_huwenshuai.bwei.com.fragment.Fragment_Video;

import newtitle_huwenshuai.bwei.com.R;

/**
 * 姓名:胡文帅
 * 时间:2017/2/16
 * 邮箱：
 * 备注：
 */

public class HomeActivity extends FragmentActivity implements View.OnClickListener{

    private FrameLayout fl;
    private LinearLayout ll;
    private LinearLayout ll_home;
    private LinearLayout ll_video;
    private LinearLayout ll_follow;
    private LinearLayout ll_my;
    private TextView tv_home;
    private TextView tv_video;
    private TextView tv_follow;
    private TextView tv_my;
    private ImageView iv_home;
    private ImageView iv_video;
    private ImageView iv_follow;
    private ImageView iv_my;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        //初始化控件
        initView();
        tv_home.setTextColor(Color.RED);
        iv_home.setImageResource(R.mipmap.b_newhome_tabbar_press);
        //添加Fragment布局
        addFragment(new Fragment_Home());

    }

    private void initView() {

        fl = (FrameLayout) findViewById(R.id.fl);
        //最外层
        ll = (LinearLayout) findViewById(R.id.ll);
        //四个按钮层
        ll_home = (LinearLayout) findViewById(R.id.ll_home);
        ll_video = (LinearLayout) findViewById(R.id.ll_video);
        ll_follow = (LinearLayout) findViewById(R.id.ll_follow);
        ll_my = (LinearLayout) findViewById(R.id.ll_my);
        //四个按钮下的文字
        tv_home = (TextView) findViewById(R.id.tv_home);
        tv_video = (TextView) findViewById(R.id.tv_video);
        tv_follow = (TextView) findViewById(R.id.tv_follow);
        tv_my = (TextView) findViewById(R.id.tv_my);
        //四个按钮的图片
        iv_home = (ImageView) findViewById(R.id.iv_home);
        iv_video = (ImageView) findViewById(R.id.iv_video);
        iv_follow = (ImageView) findViewById(R.id.iv_follow);
        iv_my = (ImageView) findViewById(R.id.iv_my);
        ll_home.setOnClickListener(this);
        ll_video.setOnClickListener(this);
        ll_follow.setOnClickListener(this);
        ll_my.setOnClickListener(this);
    }

    private void addFragment(Fragment fragment) {

        //管理类
        FragmentManager fm = getSupportFragmentManager();
        //开启一个事务
        FragmentTransaction replace = fm.beginTransaction().replace(R.id.fl, fragment);
        //提交事务
        replace.commit();
    }

    //点击监听

    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.ll_home:
                addFragment(new Fragment_Home());
                tv_home.setTextColor(Color.RED);
                tv_video.setTextColor(Color.BLACK);
                tv_follow.setTextColor(Color.BLACK);
                tv_my.setTextColor(Color.BLACK);
                iv_home.setImageResource(R.mipmap.b_newhome_tabbar_press);
                iv_video.setImageResource(R.mipmap.b_newvideo_tabbar);
                iv_follow.setImageResource(R.mipmap.b_newcare_tabbar);
                iv_my.setImageResource(R.mipmap.b_newnologin_tabbar);
                break;

            case R.id.ll_video:
                addFragment(new Fragment_Video());
                tv_home.setTextColor(Color.BLACK);
                tv_video.setTextColor(Color.RED);
                tv_follow.setTextColor(Color.BLACK);
                tv_my.setTextColor(Color.BLACK);

                iv_home.setImageResource(R.mipmap.b_newhome_tabbar);
                iv_video.setImageResource(R.mipmap.b_newvideo_tabbar_press);
                iv_follow.setImageResource(R.mipmap.b_newcare_tabbar);
                iv_my.setImageResource(R.mipmap.b_newnologin_tabbar);
                break;

            case R.id.ll_follow:
                addFragment(new Fragment_Follow());
                tv_home.setTextColor(Color.BLACK);
                tv_video.setTextColor(Color.BLACK);
                tv_follow.setTextColor(Color.RED);
                tv_my.setTextColor(Color.BLACK);

                iv_home.setImageResource(R.mipmap.b_newhome_tabbar);
                iv_video.setImageResource(R.mipmap.b_newvideo_tabbar);
                iv_follow.setImageResource(R.mipmap.b_newcare_tabbar_press);
                iv_my.setImageResource(R.mipmap.b_newnologin_tabbar);
                break;

            case R.id.ll_my:
                addFragment(new Fragment_My());
                tv_home.setTextColor(Color.BLACK);
                tv_video.setTextColor(Color.BLACK);
                tv_follow.setTextColor(Color.BLACK);
                tv_my.setTextColor(Color.RED);

                iv_home.setImageResource(R.mipmap.b_newhome_tabbar);
                iv_video.setImageResource(R.mipmap.b_newvideo_tabbar);
                iv_follow.setImageResource(R.mipmap.b_newcare_tabbar);
                iv_my.setImageResource(R.mipmap.b_newnologin_tabbar_press);
                break;
        }
    }

    //再按退出
    private long exitTime = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() ==
                KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                Toast.makeText(getApplicationContext(), "再按一次退出程序",
                        Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
