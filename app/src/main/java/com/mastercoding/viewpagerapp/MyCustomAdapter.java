package com.mastercoding.viewpagerapp;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<TabItem> {
    private ArrayList<TabItem> tabItemArrayList;

    Context context;


    public MyCustomAdapter( Context context,ArrayList<TabItem> tabItemArrayList) {
        super(context, R.layout.tab_content_item, tabItemArrayList);
        this.tabItemArrayList = tabItemArrayList;
        this.context = context;
    }

    private static class MyViewHolder{

        ImageView tabContentItem;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        TabItem tabContentItems = getItem(position);
        MyViewHolder myViewHolder;

        if(convertView == null){
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(
                    R.layout.tab_content_item,
                    parent,
                    false
            );

            myViewHolder.tabContentItem = (ImageView) convertView.findViewById(R.id.tab_content_item);

            convertView.setTag(myViewHolder);

        }else{
            myViewHolder = (MyViewHolder) convertView.getTag();

        }
        Picasso.get().load(tabContentItems.getImageUrl()).into(myViewHolder.tabContentItem);

        return  convertView;
    }
}