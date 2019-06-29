package com.aarrowsignspinners.myaudits;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by salaz on 2/8/2016.
 */
public class MainFragmentPagerAdapter extends FragmentPagerAdapter {

    public static MyScheduleFragment sMyScheduleFragment = new MyScheduleFragment();
    public static MyAuditsFragment sMyAuditsFragment = new MyAuditsFragment();
    public static MySpinnersFragment sMySpinnersFragment = new MySpinnersFragment();

    public MainFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return sMyScheduleFragment.newInstance(position);
            case 1:
                return sMyAuditsFragment.newInstance(position);
            case 2:
                return sMySpinnersFragment.newInstance(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Schedule";
            case 1:
                return "Audits";
            case 2:
                return "Spinners";
        }
        return null;
    }
}
