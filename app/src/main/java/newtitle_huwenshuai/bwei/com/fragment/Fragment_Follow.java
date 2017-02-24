package newtitle_huwenshuai.bwei.com.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import newtitle_huwenshuai.bwei.com.R;

/**
 * 姓名:胡文帅
 * 时间:2017/2/10
 * 邮箱：
 * 备注：关注
 */
public class Fragment_Follow extends Fragment{

    private View view;
    private LinearLayout ll_friend;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.activity_fragment_follow,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ll_friend = (LinearLayout) view.findViewById(R.id.follow_ll_friend);
    }
}
