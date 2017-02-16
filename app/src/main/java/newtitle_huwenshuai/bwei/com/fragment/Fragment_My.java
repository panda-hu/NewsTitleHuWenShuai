package newtitle_huwenshuai.bwei.com.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import newtitle_huwenshuai.bwei.com.R;

/**
 * 姓名:胡文帅
 * 时间:2017/2/10
 * 邮箱：
 * 备注：我的
 */
public class Fragment_My extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return View.inflate(getActivity(), R.layout.activity_fragment_my,null);
    }
}
