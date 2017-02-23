package adapter.bwei.com.listviewadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import newtitle_huwenshuai.bwei.com.R;

/**
 * 姓名:胡文帅
 * 时间:2017/2/22
 * 邮箱：
 * 备注：
 */

public class MyListViewItemAdapter extends BaseAdapter{

    private Context context;
    private String [] title;
    public MyListViewItemAdapter(Context context,String [] title) {
        this.context=context;
        this.title=title;
    }

    @Override
    public int getCount() {
        return title.length;
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
            convertView=convertView.inflate(context, R.layout.my_listview_item,null);
            holder.tv= (TextView) convertView.findViewById(R.id.my_listview_item_tv);
            convertView.setTag(holder);
        }
        else {
            holder= (viewHolder) convertView.getTag();
        }
        holder.tv.setText(title[position]);
        return convertView;
    }
    class viewHolder{
        TextView tv;
    }
}
