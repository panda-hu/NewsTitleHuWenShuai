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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
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
    private LinearLayout ll_home, ll_video, ll_follow,ll_my;
    private TextView tv_home,tv_video,tv_follow,tv_my;
    private ImageView iv_home,iv_video,iv_follow,iv_my;
    private List<ImageView> list_iv=new ArrayList<>();
    private List<TextView> list_tv=new ArrayList<>();
    private int Image_press[]={R.mipmap.b_newhome_tabbar_press,R.mipmap.b_newvideo_tabbar_press,R.mipmap.b_newcare_tabbar_press,R.mipmap.b_newnologin_tabbar_press};
    private int Image[]={R.mipmap.b_newhome_tabbar,R.mipmap.b_newvideo_tabbar,R.mipmap.b_newcare_tabbar,R.mipmap.b_newnologin_tabbar};
    private FragmentManager fm;
    private FragmentTransaction transaction;
    private Fragment_Home fg_home;
    private Fragment_Video fg_video;
    private Fragment_Follow fg_follow;
    private Fragment_My fg_my;
    private Fragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        //初始化控件
        initView();
        if(fg_home==null){
            fg_home=new Fragment_Home();
        }
        addFragment(fg_home);
        reviseColor(0);
    }

    private void initView() {
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

        addContent();

    }

    private void addFragment(Fragment fg) {
        //得到管理类
        fm= getSupportFragmentManager();
        //开启事务
        transaction = fm.beginTransaction();
        //赋值
        if(fragment!=null){
            transaction.hide(fragment);
        }
        if(!fg.isAdded()){
            transaction.add(R.id.fl,fg);
        }
        transaction.show(fg);
        transaction.commit();
        fragment=fg;
    }

    private void addContent() {
        //添加到集合里
        list_iv.add(iv_home);
        list_iv.add(iv_video);
        list_iv.add(iv_follow);
        list_iv.add(iv_my);

        list_tv.add(tv_home);
        list_tv.add(tv_video);
        list_tv.add(tv_follow);
        list_tv.add(tv_my);
        ll_home.setOnClickListener(this);
        ll_video.setOnClickListener(this);
        ll_follow.setOnClickListener(this);
        ll_my.setOnClickListener(this);
    }

    //修改控件颜色的方法
    private void reviseColor(int num) {
        for (int i = 0; i <4; i++) {
            if(i==num){
                list_iv.get(i).setBackgroundResource(Image_press[i]);
                list_tv.get(i).setTextColor(Color.RED);
            }
            else{
                list_iv.get(i).setBackgroundResource(Image[i]);
                list_tv.get(i).setTextColor(Color.BLACK);
            }
        }
    }

    //点击监听
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.ll_home:
                if (fg_home == null) {
                    fg_home = new Fragment_Home();
                }
                addFragment(fg_home);
                reviseColor(0);
                break;

            case  R.id.ll_video:
                if (fg_video == null) {
                    fg_video = new Fragment_Video();
                }
                addFragment(fg_video);
                reviseColor(1);
                break;

            case  R.id.ll_follow:
                if (fg_follow == null) {
                    fg_follow = new Fragment_Follow();
                }
                addFragment(fg_follow);
                reviseColor(2);
                break;

            case  R.id.ll_my:
                if (fg_my == null) {
                    fg_my = new Fragment_My();
                }
                addFragment(fg_my);
                JCVideoPlayer.releaseAllVideos();
                reviseColor(3);
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
