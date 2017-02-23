package newtitle_huwenshuai.bwei.com.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import adapter.bwei.com.listviewadapter.MyListViewItemAdapter;
import newtitle_huwenshuai.bwei.com.R;

/**
 * 姓名:胡文帅
 * 时间:2017/2/10
 * 邮箱：
 * 备注：我的
 */
public class Fragment_My extends Fragment implements View.OnClickListener{

    private View view;
    private LinearLayout ll_lishi;
    private LinearLayout ll_shoucang;
    private LinearLayout ll_yejian;
    private ImageView my_iv_jiantou;
    private ImageView my_iv_shouji;
    private ImageView my_iv_weixin;
    private ImageView my_iv_qq;
    private ListView lv_my_one;
    private ListView lv_my_two;
    private ListView lv_my_three;
    private String title_one[]={"消息通知"};
    private String title_two[]={"头条商城","京东特供"};
    private String title_three[]={"我要爆料","用户反馈","系统设置"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.activity_fragment_my,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
        onMyClick();
    }

    private void onMyClick() {

    }

    private void initData() {
        lv_my_one.setAdapter(new MyListViewItemAdapter(getActivity(),title_one));
        lv_my_two.setAdapter(new MyListViewItemAdapter(getActivity(),title_two));
        lv_my_three.setAdapter(new MyListViewItemAdapter(getActivity(),title_three));
    }

    private void initView() {
        ll_lishi = (LinearLayout) view.findViewById(R.id.my_ll_lishi);
        ll_shoucang = (LinearLayout) view.findViewById(R.id.my_ll_shoucang);
        ll_yejian = (LinearLayout) view.findViewById(R.id.my_ll_yejian);
        my_iv_jiantou = (ImageView) view.findViewById(R.id.my_iv_jiantou);
        my_iv_shouji = (ImageView) view.findViewById(R.id.my_iv_shouji);
        my_iv_weixin = (ImageView) view.findViewById(R.id.my_iv_weixin);
        my_iv_qq = (ImageView) view.findViewById(R.id.my_iv_qq);
        lv_my_one = (ListView) view.findViewById(R.id.lv_my_one);
        lv_my_two = (ListView) view.findViewById(R.id.lv_my_two);
        lv_my_three = (ListView) view.findViewById(R.id.lv_my_three);
    }

    @Override
    public void onClick(View v) {

    }
}
