package adapter.bwei.com.listviewadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import newtitle_huwenshuai.bwei.com.R;
import newtitle_huwenshuai.bwei.com.bean.MyBean;

/**
 * 姓名:胡文帅
 * 时间:2017/2/14
 * 邮箱：
 * 备注：
 */
public class MyXlistviewAdapter extends BaseAdapter{

    private int TYPE_1=0;
    private int TYPE_2=1;
    private int TYPE_3=2;
    private Context context;
    private List<MyBean> data=new ArrayList<>();
    private final DisplayImageOptions options;

    public MyXlistviewAdapter(Context context) {
        this.context=context;
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.not_article_loading)
                .build();
    }


    @Override
    public int getItemViewType(int position) {
        MyBean item = getItem(position);
        if(item.getImgextra()==null){
            if(position%4==0){
                return TYPE_1;
            }
            else {
                return TYPE_3;
            }
        }
        else{
            return TYPE_2;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public MyBean getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder1 holder1=null;
        viewHolder2 holder2=null;
        viewHolder3 holder3=null;
        //为空创建
        if(convertView==null){
            if(getItemViewType(position)==TYPE_1){
                holder1=new viewHolder1();
                convertView=convertView.inflate(context, R.layout.item_type_one,null);
                holder1.tv_title= (TextView) convertView.findViewById(R.id.tv_item_type_one_title);
                holder1.tv_source= (TextView) convertView.findViewById(R.id.tv_item_type_one_source);
                holder1.tv_ptime= (TextView) convertView.findViewById(R.id.tv_item_type_one_ptime);
                convertView.setTag(holder1);
            }
            else if(getItemViewType(position)==TYPE_2){
                holder2=new viewHolder2();
                convertView=convertView.inflate(context,R.layout.item_type_two,null);
                holder2.tv_two_title= (TextView) convertView.findViewById(R.id.tv_item_type_two_title);
                holder2.tv_two_source= (TextView) convertView.findViewById(R.id.tv_item_type_two_source);
                holder2.tv_two_ptime= (TextView) convertView.findViewById(R.id.tv_item_type_two_ptime);
                holder2.iv_two_1= (ImageView) convertView.findViewById(R.id.iv_item_type_two_1);
                holder2.iv_two_2= (ImageView) convertView.findViewById(R.id.iv_item_type_two_2);
                holder2.iv_two_3= (ImageView) convertView.findViewById(R.id.iv_item_type_two_3);
                convertView.setTag(holder2);
            }
            else {
                holder3=new viewHolder3();
                convertView=convertView.inflate(context,R.layout.item_type_three,null);
                holder3.tv_three_title= (TextView) convertView.findViewById(R.id.tv_item_type_three_title);
                holder3.tv_three_source= (TextView) convertView.findViewById(R.id.tv_item_type_three_source);
                holder3.tv_three_ptime= (TextView) convertView.findViewById(R.id.tv_item_type_three_ptime);
                holder3.iv_three= (ImageView) convertView.findViewById(R.id.iv_item_type_three);
                convertView.setTag(holder3);
            }

        }
        //不为空复用
        else
        {
            if(getItemViewType(position)==TYPE_1){
                holder1= (viewHolder1) convertView.getTag();
            }
            else if(getItemViewType(position)==TYPE_2){
                holder2= (viewHolder2) convertView.getTag();
            }
            else {
                holder3= (viewHolder3) convertView.getTag();
            }
        }

        //赋值
        if(getItemViewType(position)==TYPE_1){
            holder1.tv_title.setText(getItem(position).getTitle());
            holder1.tv_source.setText(getItem(position).getSource());
            holder1.tv_ptime.setText(getItem(position).getPtime());
        }
        else if(getItemViewType(position)==TYPE_2){
            holder2.tv_two_title.setText(getItem(position).getTitle());
            holder2.tv_two_source.setText(getItem(position).getSource());
            holder2.tv_two_ptime.setText(getItem(position).getPtime());
            ImageLoader.getInstance().displayImage(getItem(position).getImgsrc(),holder2.iv_two_1,options);
            ImageLoader.getInstance().displayImage(getItem(position).getImgextra().get(0).getImgsrc(),holder2.iv_two_2,options);
            ImageLoader.getInstance().displayImage(getItem(position).getImgextra().get(1).getImgsrc(),holder2.iv_two_3,options);
        }
        else {
            holder3.tv_three_title.setText(getItem(position).getTitle());
            holder3.tv_three_source.setText(getItem(position).getSource());
            holder3.tv_three_ptime.setText(getItem(position).getPtime());
            ImageLoader.getInstance().displayImage(getItem(position).getImgsrc(),holder3.iv_three,options);
        }

        return convertView;
    }

    class viewHolder1{

        private TextView tv_title;
        private TextView tv_source;
        private TextView tv_ptime;
    }
    class viewHolder2{

        private TextView tv_two_title;
        private TextView tv_two_source;
        private TextView tv_two_ptime;
        private ImageView iv_two_1;
        private ImageView iv_two_2;
        private ImageView iv_two_3;
    }
    class viewHolder3{

        private TextView tv_three_title;
        private TextView tv_three_source;
        private TextView tv_three_ptime;
        private ImageView iv_three;
    }

    public void addData(List<MyBean> datas, boolean isNeedClear){
        if(datas!=null){
            if(isNeedClear){
                data.clear();
            }
            data.addAll(datas);

        }

    }
}
