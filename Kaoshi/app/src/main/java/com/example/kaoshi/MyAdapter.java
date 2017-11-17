package com.example.kaoshi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 齐天大圣 on 2017/9/15.
 */
public class MyAdapter extends BaseAdapter {
    private ArrayList<String> list;
    private Context con;

    public MyAdapter(ArrayList<String> list, Context con) {
        this.list = list;
        this.con = con;
    }

    @Override
    public int getCount() {
        return list.size();
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
        ViewHolder v=null;
        if(view==null){
            v= new ViewHolder();
            view=LayoutInflater.from(con).inflate(R.layout.activity_adapter,null);
            v.name= (TextView) view.findViewById(R.id.name);
            view.setTag(v);
        }else{

            v= (ViewHolder) view.getTag();
        }
        v.name.setText(list.get(i));

        return view;
    }
    class ViewHolder{
        TextView name;
    }

}
