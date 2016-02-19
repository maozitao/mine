package com.mytest.mao.joke_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LayoutListItemAdapter<T> extends BaseAdapter {

    private List<T> objects = new ArrayList<T>();

    private Context context;
    private LayoutInflater layoutInflater;

    public LayoutListItemAdapter(Context context,List<T> list) {
        this.context = context;
        objects = list;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public T getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.layout_list_item, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.picIv = (ImageView) convertView.findViewById(R.id.pic_iv);
            viewHolder.authorTv = (TextView) convertView.findViewById(R.id.author_tv);
            viewHolder.contentTv = (TextView) convertView.findViewById(R.id.content_tv);

            convertView.setTag(viewHolder);
        }
        initializeViews((T)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(T object, ViewHolder holder) {
        //TODO implement
    }

    protected class ViewHolder {
        private ImageView picIv;
    private TextView authorTv;
    private TextView contentTv;
    }
}
