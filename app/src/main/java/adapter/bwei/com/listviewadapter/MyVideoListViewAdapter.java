package adapter.bwei.com.listviewadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import newtitle_huwenshuai.bwei.com.R;
import newtitle_huwenshuai.bwei.com.bean.MyVideoBean;

/**
 * 姓名:胡文帅
 * 时间:2017/2/21
 * 邮箱：
 * 备注：
 */

public class MyVideoListViewAdapter extends BaseAdapter{

    private List<MyVideoBean> videoData=new ArrayList<>();
    private Context context;
    public MyVideoListViewAdapter(Context context) {
        this.context=context;
    }

    @Override
    public int getCount() {
        return videoData.size();
    }

    @Override
    public Object getItem(int position) {
        return videoData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder holder=null;
        if(convertView==null){
            holder=new viewHolder();
            convertView=convertView.inflate(context,R.layout.item_video,null);
            holder.jcvp= (JCVideoPlayer) convertView.findViewById(R.id.jiecao_video);
            convertView.setTag(holder);
        }
        else{
            holder= (viewHolder) convertView.getTag();
        }

        holder.jcvp.setUp(videoData.get(position).getMp4_url(),videoData.get(position).getTitle());
        holder.jcvp.ivThumb.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageLoader.getInstance().displayImage(videoData.get(position).getTopicImg(),holder.jcvp.ivThumb);
        return convertView;

    }

    class viewHolder{
        JCVideoPlayer  jcvp;
    }


    public void addData(List<MyVideoBean> videobean, boolean isNeedClear){
        if(videobean!=null){
            if(isNeedClear){
                videoData.clear();
            }
            videoData.addAll(videobean);
        }
    }
}
