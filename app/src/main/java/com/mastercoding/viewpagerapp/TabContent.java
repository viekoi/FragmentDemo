package com.mastercoding.viewpagerapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class TabContent extends Fragment {

    GridView gridList;
    MyCustomAdapter myCustomAdapter;
    private ArrayList<TabItem> tabItemArrayList;

    String categoryName;

    public TabContent(String categoryName,ArrayList<TabItem> tabItemArrayList) {

        this.categoryName = categoryName;
        this.tabItemArrayList = tabItemArrayList;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_tab_content, container, false);
        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gridList = view.findViewById(R.id.gridview);
        myCustomAdapter = new MyCustomAdapter(getActivity(),tabItemArrayList);
        gridList.setAdapter(myCustomAdapter);

    }
}