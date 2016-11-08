package com.example.raazn.loadshedding.GroupTabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by raazn on 15-Oct-16.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {
    private String fragments [] = {"1","2","3","4","5","6","7"};
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Group1();
            case 1:
                return new Group2();
            case 2:
                return new Group3();
            case 3:
                return new Group4();
            case 4:
                return new Group5();
            case 5:
                return new Group6();
            case 6:
                return new Group7();
        }
        return null;
    }

    @Override
    public int getCount() {
        return fragments.length;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return fragments[position];
    }
}
