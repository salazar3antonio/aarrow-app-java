package com.aarrowsignspinners.myaudits;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.UUID;

/**
 * Created by salaz on 1/28/2016.
 */
public class InformationFragment extends Fragment {

    //a final key needed to store the section int once a newInstance of the fragment is created
    public static final String ARG_PAGE = "arg_page";
    private static final String ARG_AUDIT_ID = "audit_id";
    //mPage will be updated with value of ARG_PAGE when onCreate() of this fragment is called.
    private int mPage;

    private EditText mSpinnerName;
    private EditText mDate;
    private EditText mLocation;
    private EditText mCorner;
    private Button mToastButton;

    private Audit mAudit;

    // we create a public method named newInstance to instantiate the sectuib bynber passed in once
    // a new InformationFragment is created
    public static InformationFragment newInstance(int section, UUID auditId) {
        // new bundle to store the page
        Bundle args = new Bundle();
        //call putInt() on the bundle to story a key-value pair
        args.putInt(ARG_PAGE, section);
        args.putSerializable(ARG_AUDIT_ID, auditId);
        //create a new InformationFragment object
        InformationFragment fragment = new InformationFragment();
        //call setArguments() to store the key-value pair into the InformationFragment Object
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //when onCreate() is called, we update the value of mPage with with the int of ARG_PAGE value
        mPage = getArguments().getInt(ARG_PAGE);
        UUID auditID = (UUID) getArguments().getSerializable(ARG_AUDIT_ID);
        mAudit = AuditList.get(getActivity()).getAudit(auditID);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        //here we need to inflate the fragment layout. the data type is View since it extends from it.
        // then return the view
        View view = inflater.inflate(R.layout.fragment_information, container, false);

        mSpinnerName = (EditText) view.findViewById(R.id.info_name);
        mDate = (EditText) view.findViewById(R.id.info_date);
        mLocation = (EditText) view.findViewById(R.id.info_location);
        mCorner = (EditText) view.findViewById(R.id.info_corner);

        updateAudit();

        mSpinnerName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mAudit.setSpinnerName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mLocation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mAudit.setLocation(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mCorner.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mAudit.setCorner(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;
    }

    public void updateAudit() {
        mSpinnerName.setText(mAudit.getSpinnerName());
        mDate.setText(mAudit.getDate().toString());
        mCorner.setText(mAudit.getCorner());
        mLocation.setText(mAudit.getLocation());
    }

}

