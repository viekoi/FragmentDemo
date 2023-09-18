package com.mastercoding.viewpagerapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;





public class MainActivity extends AppCompatActivity {
    ViewPager2 viewpager;
    MyViewPagerAdapter myAdapter;
    TabLayout tabLayout;


    ArrayList<TabItem> flowers = new ArrayList<TabItem>();
    ArrayList<TabItem> animals = new ArrayList<TabItem>();

    ArrayList<Category> categoryArrayList = new ArrayList<Category>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);



        myAdapter = new MyViewPagerAdapter(
                getSupportFragmentManager(),
                getLifecycle()
        );

        flowers.add(new TabItem("https://chaucayxuatkhau.com/wp-content/uploads/2021/09/hoa-hong-nhung.jpg"));
        flowers.add(new TabItem("https://upload.wikimedia.org/wikipedia/commons/f/fc/Sunflower_2009_07_25_4436.jpg"));
        animals.add(new TabItem("https://cdn.tgdd.vn/Files/2021/04/18/1344308/tim-hieu-giong-cho-alaska-nguon-goc-dac-diem-cach-nuoi-bang-gia-202104181204283055.jpg"));
        animals.add(new TabItem("https://cdn.tgdd.vn/Files/2021/04/16/1343844/cam-nang-cho-shiba-nguon-goc-dac-diem-cach-nuoi-gia-ban-202206041145265445.jpg"));
        // Adding Fragments to the list in the Adapter Class
//        myAdapter.addFragment(new TabContent(flowers,"flowers"));
//        myAdapter.addFragment(new TabContent(animals,"animals"));

        categoryArrayList.add(new Category("animals",animals));
        categoryArrayList.add(new Category("flowers",flowers));

        for (Category category:categoryArrayList
             ) {
            myAdapter.addFragment(new TabContent(category.getName(),category.getCategoryList()));
        }

        // Set the orientation in ViewPager2
        viewpager = findViewById(R.id.viewPager2);
        viewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        // Connecting the Adapter with ViewPager2
        viewpager.setAdapter(myAdapter);



        // Connecting TabLayout with ViewPager
        new TabLayoutMediator(
                tabLayout,
                viewpager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText(categoryArrayList.get(position).name);

                    }
                }
        ).attach();



    }
}