package adapter.bwei.com.fragmentadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import newtitle_huwenshuai.bwei.com.fragment.Fragment_Home;

/**
 * 姓名:胡文帅
 * 时间:2017/2/12
 * 邮箱：
 * 备注：
 */
public class MyHomeTitleFragmentAdapter extends FragmentPagerAdapter{


    private final FragmentManager childFragmentManager;
    private final Fragment_Home fragment_home;
    private final List<Fragment> list;
    private final String[] title;

    public MyHomeTitleFragmentAdapter(FragmentManager childFragmentManager, Fragment_Home fragment_home, List<Fragment> list, String[] title) {
        super(childFragmentManager);

        this.childFragmentManager = childFragmentManager;
        this.fragment_home = fragment_home;
        this.list = list;
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
