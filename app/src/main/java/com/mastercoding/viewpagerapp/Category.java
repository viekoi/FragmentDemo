package com.mastercoding.viewpagerapp;

import java.util.ArrayList;

public class Category {

    String name;
    ArrayList<TabItem> categoryList = new ArrayList<TabItem>();

    public Category(String name, ArrayList<TabItem> categoryList ) {
        this.name = name;
        this.categoryList = categoryList;
    }

    public String getName() {
        return name;
    }

    public ArrayList<TabItem> getCategoryList() {
        return categoryList;
    }


}
