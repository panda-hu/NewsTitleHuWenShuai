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
    private String[] video_title={"热点","精品","搞笑","娱乐"};
    private String[] video_id={"V9LG4B3A0","V9LG4CHOR","V9LG4E6VR","00850FRB"};
    private TabLayout video_tl;
    private ViewPager video_vp;
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
        MyVideoTitleFragmentAdapter mvtAdapter=new MyVideoTitleFragmentAdapter(getFragmentManager(),this, list, video_title);
        video_vp.setAdapter(mvtAdapter);
        video_tl.setTabMode(TabLayout.MODE_SCROLLABLE);
        video_tl.setupWithViewPager(video_vp);
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < video_title.length; i++) {
            VideoTitleFragment vtf=new VideoTitleFragment();
            Bundle bundle=new Bundle();
            bundle.putString("video_id",video_id[i]);
            vtf.setArguments(bundle);
            list.add(vtf);
        }
    }

    private void initView() {
        video_tl = (TabLayout) view.findViewById(R.id.video_tablayout_title);
        video_vp = (ViewPager) view.findViewById(R.id.fragment_video_vp);
    }
}
