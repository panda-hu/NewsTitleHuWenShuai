package adapter.bwei.com.listviewadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import newtitle_huwenshuai.bwei.com.R;
import newtitle_huwenshuai.bwei.com.bean.MyBean;

/**
 * 姓名:胡文帅
 * 时间:2017/2/14
 * 邮箱：
 * 备注：
 */
public class MyXlistviewAdapter extends BaseAdapter{

    private Context context;
    private List<MyBean.Result.Data> data=new ArrayList<>();
    public MyXlistviewAdapter(Context context) {
        this.context=context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
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
            convertView=convertView.inflate(context, R.layout.item_type_one,null);
            holder.tv= (TextView) convertView.findViewById(R.id.tv_item_type_one_title);
            convertView.setTag(holder);
        }
        else
        {
            holder= (viewHolder) convertView.getTag();
        }
        holder.tv.setText(data.get(position).content);
        return convertView;
    }

    class viewHolder{
        private TextView tv;
    }

    public void addData(List<MyBean.Result.Data> datas, boolean isNeedClear){
        if(datas!=null){
            if(isNeedClear){
                data.clear();
            }
            data.addAll(datas);

        }

    }
}
