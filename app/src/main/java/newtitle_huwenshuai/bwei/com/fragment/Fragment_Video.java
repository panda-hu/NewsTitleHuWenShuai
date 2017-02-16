package newtitle_huwenshuai.bwei.com.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import adapter.bwei.com.fragmentadapter.MyVideoTitleFragmentAdapter;
import newtitle_huwenshuai.bwei.com.R;
import titleFragment.bwei.com.VideoTitleFragment;

/**
 * 姓名:胡文帅
 * 时间:2017/2/10
 * 邮箱：
 * 备注：视频
 */
public class Fragment_Video extends Fragment{

    private View view;
    private String[] title={"热点","精品","搞笑","娱乐"};
    private TabLayout tl_video;
    private ViewPager vp_video;
    private List<Fragment> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.activity_fragment_video,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
        MyVideoTitleFragmentAdapter mvtAdapter=new MyVideoTitleFragmentAdapter(getFragmentManager(),this, list, title);
        vp_video.setAdapter(mvtAdapter);
        tl_video.setTabMode(TabLayout.MODE_SCROLLABLE);
        tl_video.setupWithViewPager(vp_video);
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            VideoTitleFragment vtf=new VideoTitleFragment();
            list.add(vtf);
        }
    }

    private void initView() {
        tl_video = (TabLayout) view.findViewById(R.id.voideo_tablayout_title);
        vp_video = (ViewPager) view.findViewById(R.id.fragment_video_vp);
    }
}
