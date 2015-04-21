package com.candy.knowyourtaste.mainactivity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.candy.knowyourtaste.R;

/**
 * Created by maqiang on 2015/4/18.
 */
public class DrawerListAdapter extends BaseAdapter {

    private int[] titles=new int[]{R.string.recommend,
            R.string.social,
            R.string.setting};

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return titles[position];
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        if(convertView==null) {
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_activity_main_drawer_list_layout,parent,false);
        }
        TextView mTextView=(TextView)convertView.findViewById(R.id.activity_main_drawer_listView_fragment_text);
        mTextView.setText(titles[position]);
        return convertView;
    }
}
