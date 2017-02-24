package titleFragment.bwei.com;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

import adapter.bwei.com.listviewadapter.MyHomeListViewAdapter;
import myinterface.bwei.com.CallbackNewsData;
import newtitle_huwenshuai.bwei.com.R;
import newtitle_huwenshuai.bwei.com.activity.WebViewActivity;
import newtitle_huwenshuai.bwei.com.bean.MyBean;
import utils.bwei.com.ApplicationConstants;
import utils.bwei.com.NetWorkUtils;

/**
 * 姓名:胡文帅
 * 时间:2017/2/12
 * 邮箱：
 * 备注：home界面TabLayout所用Fragment
 */
public class HomeTitleFragment extends Fragment implements PullToRefreshListView.OnRefreshListener2,CallbackNewsData<MyBean> {

    private View view;
    private PullToRefreshListView ptrlv;
    private String url;
    private MyHomeListViewAdapter mxlvAdapter;
    private boolean isNeedClear=false;
    private String id;
    private int start=0;
    private int end=20;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.home_title_fragment,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        id = bundle.getString("id");
        initView();
        initData();
        url = ApplicationConstants.getUrl(id,start,end);
        NetWorkUtils.loadDataFromServer(url,MyBean.class,this);
    }

    private void initData() {
        mxlvAdapter = new MyHomeListViewAdapter(getActivity());
        ptrlv.setAdapter(mxlvAdapter);
    }

    private void initView() {
        ptrlv = (PullToRefreshListView) view.findViewById(R.id.home_fragment_PullToRefreshListView);
        ptrlv.setMode(PullToRefreshBase.Mode.BOTH);
        ptrlv.setOnRefreshListener(this);
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        //下拉
        isNeedClear=true;
        start=0;
        end=20;
        url=ApplicationConstants.getUrl(id,start,end);
        NetWorkUtils.loadDataFromServer(url, MyBean.class, this);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        //上拉
        isNeedClear=false;
        start+=20;
        end+=20;
        url=ApplicationConstants.getUrl(id,start,end);
        NetWorkUtils.loadDataFromServer(url, MyBean.class, this);
    }

    @Override
    public void succer(final List<MyBean> mybean) {

        mxlvAdapter.addData(mybean,isNeedClear);
        mxlvAdapter.notifyDataSetChanged();
        ptrlv.onRefreshComplete();
        ptrlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), WebViewActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("url",mybean.get(position-1).getUrl());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
