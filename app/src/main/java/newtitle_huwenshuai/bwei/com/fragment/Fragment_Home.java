package newtitle_huwenshuai.bwei.com.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import adapter.bwei.com.fragmentadapter.MyHomeTitleFragmentAdapter;
import newtitle_huwenshuai.bwei.com.R;
import titleFragment.bwei.com.HomeTitleFragment;

/**
 * 姓名:胡文帅
 * 时间:2017/2/10
 * 邮箱：
 * 备注：首页
 */
public class Fragment_Home extends Fragment{

    private View view;

    //title名称数组
    private String[] title={"推荐","社会","电影","娱乐","数码","教育","游戏","科技","财经"};
    private String[] id={"T1348647909107","T1348648037603","T1348648650048","T1348648517839","T1348649776727","T1348654225495","T1348654151579","T1348649580692","T1348648756099"};
    private TabLayout tl;
    private ViewPager vp;
    private List<Fragment> list;
    private ImageButton ib;

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
        MyHomeTitleFragmentAdapter mhtHomeAdapter= new MyHomeTitleFragmentAdapter(getChildFragmentManager(),this,list,title);
        vp.setAdapter(mhtHomeAdapter);
        tl.setTabMode(TabLayout.MODE_SCROLLABLE);
        tl.setupWithViewPager(vp);
    }

    //加载布局
    private void initView() {
        tl = (TabLayout) view.findViewById(R.id.home_tablayout_title);
        vp = (ViewPager) view.findViewById(R.id.fragment_home_vp);
        ib = (ImageButton) view.findViewById(R.id.home_tablayout_add);
        ib.getBackground().setAlpha(248);
    }

    //加载数据
    private void initData() {
        list = new ArrayList<>();
        for (int i=0; i<title.length; i++)
        {
            HomeTitleFragment tf=new HomeTitleFragment();
            Bundle bundle=new Bundle();
            bundle.putString("id",id[i]);
            tf.setArguments(bundle);
            list.add(tf);
        }
    }


}
