package newtitle_huwenshuai.bwei.com;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import adapter.bwei.com.MyTitleFragmentAdapter;
import titleFragment.bwei.com.TitleFragment;

/**
 * 姓名:胡文帅
 * 时间:2017/2/10
 * 邮箱：
 * 备注：首页
 */
public class Fragment_Home extends Fragment{

    private View view;

    //title名称数组
    private String[] title={"推荐","热点","阳光宽频","北京","社会","娱乐","问答","图片"};
    private TabLayout tl;
    private ViewPager vp;
    private List<Fragment> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.activity_fragment_home,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
        initData();
        MyTitleFragmentAdapter mtfAdapter= new MyTitleFragmentAdapter(getChildFragmentManager(),this,list,title);
        vp.setAdapter(mtfAdapter);
        tl.setTabMode(TabLayout.MODE_SCROLLABLE);
        tl.setupWithViewPager(vp);
    }

    //加载布局
    private void initView() {
        tl = (TabLayout) view.findViewById(R.id.tablayout_title);
        vp = (ViewPager) view.findViewById(R.id.fragment_home_vp);
    }

    //加载数据
    private void initData() {
        list = new ArrayList<>();
        for (int i=0; i<title.length; i++)
        {
            TitleFragment tf=new TitleFragment();
            list.add(tf);
        }
    }


}
