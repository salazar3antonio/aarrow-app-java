package com.aarrowsignspinners.myaudits;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by salaz on 2/8/2016.
 */
public class MyScheduleFragment extends Fragment {

    public static final String ARG_PAGE = "arg_page";
    private int mPage;

    public static MyScheduleFragment newInstance(int section) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, section);
        MyScheduleFragment fragment = new MyScheduleFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myschedule, container, false);
        return view;
    }


}
