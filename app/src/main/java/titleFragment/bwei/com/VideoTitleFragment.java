package titleFragment.bwei.com;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

import adapter.bwei.com.listviewadapter.MyVideoListViewAdapter;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import myinterface.bwei.com.CallbackNewsData;
import newtitle_huwenshuai.bwei.com.R;
import newtitle_huwenshuai.bwei.com.bean.MyVideoBean;
import utils.bwei.com.ApplicationConstants;
import utils.bwei.com.NetWorkUtils;

/**
 * 姓名:胡文帅
 * 时间:2017/2/12
 * 邮箱：
 * 备注：video界面TabLayout所用Fragment
 */
public class VideoTitleFragment extends Fragment implements PullToRefreshListView.OnRefreshListener2,CallbackNewsData<MyVideoBean>{

    private View view;
    private String id;
    private boolean isNeedClear=false;
    private MyVideoListViewAdapter videoAdapter;
    private PullToRefreshListView ptrlv_video;
    private int start=1;
    private int end=10;
    private String url;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.video_title_fragment,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        id = bundle.getString("video_id");
        initView();
        initData();
        url = ApplicationConstants.getVideoUrl(id,start,end);
        NetWorkUtils.loadDataFromServer(url,MyVideoBean.class,this);
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    private void initView() {
        ptrlv_video = (PullToRefreshListView) view.findViewById(R.id.video_fragment_PullToRefreshListView);
        ptrlv_video.setMode(PullToRefreshBase.Mode.BOTH);
        ptrlv_video.setOnRefreshListener(this);
    }

    private void initData() {
        videoAdapter = new MyVideoListViewAdapter(getActivity());
        ptrlv_video.setAdapter(videoAdapter);
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        isNeedClear=true;
        start=1;
        end=10;
        url = ApplicationConstants.getVideoUrl(id,start,end);
        NetWorkUtils.loadDataFromServer(url,MyVideoBean.class,this);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        isNeedClear=false;
        start+=10;
        end+=10;
        url = ApplicationConstants.getVideoUrl(id,start,end);
        NetWorkUtils.loadDataFromServer(url,MyVideoBean.class,this);
    }

    @Override
    public void succer(List<MyVideoBean> myVideoBeen) {
        videoAdapter.addData(myVideoBeen,isNeedClear);
        videoAdapter.notifyDataSetChanged();
        ptrlv_video.onRefreshComplete();
    }
}
