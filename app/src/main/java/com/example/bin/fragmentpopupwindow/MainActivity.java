package com.example.bin.fragmentpopupwindow;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MainActivity extends AppCompatActivity {

    private FragmentMusic music = new FragmentMusic();
    private FragmentFavorite favorite = new FragmentFavorite();
    private FragmentFriends friends = new FragmentFriends();
    private Fragment[] fragments = {music, favorite, friends};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        BottomNavigationViewEx bottomView = (BottomNavigationViewEx) findViewById(R.id.design_bottom_sheet);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager(), fragments));
        bottomView.setupWithViewPager(viewPager); //底部菜单栏与viewpager关联
    }

    private class MyAdapter extends FragmentPagerAdapter {

        private Fragment[] fragments;

        MyAdapter(FragmentManager fm, Fragment[] fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

    }
}
