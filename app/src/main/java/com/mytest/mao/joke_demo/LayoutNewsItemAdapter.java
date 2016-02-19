package com.mytest.mao.joke_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LayoutNewsItemAdapter<T> extends BaseAdapter {

    private List<T> objects = new ArrayList<T>();

    private Context context;
    private LayoutInflater layoutInflater;

    public LayoutNewsItemAdapter(Context context,List<T> listDatas) {
        this.context = context;
        objects = listDatas;
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
            convertView = layoutInflater.inflate(R.layout.layout_news_item, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.tvNews = (TextView) convertView.findViewById(R.id.tvNews);

            convertView.setTag(viewHolder);
        }
        initializeViews((T)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(T object, ViewHolder holder) {
        //TODO implement
        holder.tvNews.setText(object.toString());
    }

    protected class ViewHolder {
        private TextView tvNews;
    }
}
