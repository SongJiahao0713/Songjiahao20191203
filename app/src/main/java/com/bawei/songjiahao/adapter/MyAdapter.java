package com.bawei.songjiahao.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.songjiahao.R;
import com.bawei.songjiahao.Utils.NetUtil;
import com.bawei.songjiahao.model.shopBean.ShopBean;

import java.util.List;

/**
 * 时间：2019/12/3 0003
 * 作者：Songjiahao
 * 类的作用：
 */
public class MyAdapter extends BaseAdapter {
    private List<ShopBean.ShopGridDataBean> shopGridData;

    public MyAdapter(List<ShopBean.ShopGridDataBean> shopGridData) {
        this.shopGridData = shopGridData;
    }

    @Override
    public int getCount() {
        return shopGridData.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if (view==null){
            viewHolder=new ViewHolder();
            view=View.inflate(viewGroup.getContext(), R.layout.item,null);
            viewHolder.iv=view.findViewById(R.id.iv);
            viewHolder.tv=view.findViewById(R.id.tv);
            viewHolder.tv1=view.findViewById(R.id.tv1);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.tv.setText(shopGridData.get(i).getTitle());
        viewHolder.tv1.setText(shopGridData.get(i).getPrice());
        String imageurl = shopGridData.get(i).getImageurl();
        NetUtil.getInstance().getPhoto(imageurl,viewHolder.iv);
        return view;
    }
    class ViewHolder{
        ImageView iv;
        TextView tv;
        TextView tv1;
    }
}
