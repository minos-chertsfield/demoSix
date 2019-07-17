package com.yuntang.juney.demoone.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

import com.yuntang.juney.demoone.R;
import com.yuntang.juney.demoone.fragment.DiscoverFragment;
import com.yuntang.juney.demoone.fragment.MineFragment;
import com.yuntang.juney.demoone.fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {


    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<Fragment> fragments;    //碎片集合
    private List<String> titles;     //标题集合



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {      //初始化组件

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);


        fragments = new ArrayList<>();     //碎片集合初始化
        fragments.add(new MineFragment());     //添加碎片
        fragments.add(new DiscoverFragment());
        fragments.add(new VideoFragment());

        titles = new ArrayList<>();
        titles.add("我的");
        titles.add("发现");
        titles.add("视频");


        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }
        });

        viewPager.setOffscreenPageLimit(2);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(this);


    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {    //选中Tab

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {     //未选中Tab

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {     //再次选中Tab

    }
}
