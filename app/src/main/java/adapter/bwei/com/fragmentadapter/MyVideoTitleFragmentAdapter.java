package adapter.bwei.com.fragmentadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import newtitle_huwenshuai.bwei.com.fragment.Fragment_Home;
import newtitle_huwenshuai.bwei.com.fragment.Fragment_Video;

/**
 * 姓名:胡文帅
 * 时间:2017/2/12
 * 邮箱：
 * 备注：
 */
public class MyVideoTitleFragmentAdapter extends FragmentPagerAdapter{


    private final FragmentManager fm;
    private final Fragment_Video fragment_video;
    private final List<Fragment> list;
    private final String[] title;

    public MyVideoTitleFragmentAdapter(FragmentManager fm, Fragment_Video fragment_video, List<Fragment> list, String[] title) {
        super(fm);
        this.fm = fm;
        this.fragment_video = fragment_video;
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
