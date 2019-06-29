package com.aarrowsignspinners.myaudits;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import java.util.UUID;

/**
 * Created by salaz on 1/29/2016.
 */
public class    PreparednessFragment extends Fragment {

    //a final key needed to store the section int once a newInstance of the fragment is created
    public static final String ARG_PAGE = "arg_page";
    private static final String ARG_AUDIT_ID = "audit_id";

    //mPage will be updated with value of ARG_PAGE when onCreate() of this fragment is called.
    private int mPage;
    private Audit mAudit;

    private RadioGroup mConfirmationRadio;
    private RadioGroup mArrivalTextRadio;
    private RadioGroup mSISRadio;
    private RadioGroup mOnTimeRadio;
    private RadioGroup mWaterRadio;

    // we create a public method named newInstance to instantiate the arguments passed in once
    // a new InformationFragment is created
    public static PreparednessFragment newInstance(int section, UUID auditID) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, section);
        args.putSerializable(ARG_AUDIT_ID, auditID);
        PreparednessFragment fragment = new PreparednessFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //here we need to inflate the fragment layout. the data type is View since it extends from it.
        // then return the view
        View view = inflater.inflate(R.layout.fragment_preparedness, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mConfirmationRadio = (RadioGroup) view.findViewById(R.id.confirmation_radio);
        mConfirmationRadio.check(mAudit.getConfirmationRadioID());

        mArrivalTextRadio = (RadioGroup) view.findViewById(R.id.arrival_radio);
        mArrivalTextRadio.check(mAudit.getArrivalTextRadioID());

        mSISRadio = (RadioGroup) view.findViewById(R.id.sis_radio);
        mSISRadio.check(mAudit.getSignInSheetRadioID());

        mOnTimeRadio = (RadioGroup) view.findViewById(R.id.ontime_radio);
        mOnTimeRadio.check(mAudit.getOnTimeRadioID());

        mWaterRadio = (RadioGroup) view.findViewById(R.id.water_radio);
        mWaterRadio.check(mAudit.getWaterRadioID());

        mConfirmationRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (mConfirmationRadio.getCheckedRadioButtonId()) {
                    case R.id.conf_yes:
                        mAudit.setConfirmationPoints(4);
                        break;
                    case R.id.conf_no:
                        mAudit.setConfirmationPoints(0);
                        break;
                }
            }
        });

        mArrivalTextRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (mArrivalTextRadio.getCheckedRadioButtonId()) {
                    case R.id.arrival_yes:
                        mAudit.setArrivalTextPoints(4);
                        break;
                    case R.id.arrival_no:
                        mAudit.setArrivalTextPoints(0);
                        break;
                }
            }
        });

        mSISRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (mSISRadio.getCheckedRadioButtonId()) {
                    case R.id.sis_yes:
                        mAudit.setSignInSheetPoints(4);
                        break;
                    case R.id.sis_no:
                        mAudit.setSignInSheetPoints(0);
                        break;
                }
            }
        });

        mOnTimeRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (mOnTimeRadio.getCheckedRadioButtonId()) {
                    case R.id.ontime_yes:
                        mAudit.setOnTimePoints(4);
                        break;
                    case R.id.ontime_no:
                        mAudit.setOnTimePoints(0);
                        break;
                }
            }
        });

        mWaterRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (mWaterRadio.getCheckedRadioButtonId()) {
                    case R.id.water_yes:
                        mAudit.setWaterPoints(4);
                        break;
                    case R.id.water_no:
                        mAudit.setWaterPoints(0);
                        break;
                }
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        mAudit.getTotalPreparednessPoints();
        mAudit.setConfirmationRadioID(mConfirmationRadio.getCheckedRadioButtonId());
        mAudit.setArrivalTextRadioID(mArrivalTextRadio.getCheckedRadioButtonId());
        mAudit.setSignInSheetRadioID(mSISRadio.getCheckedRadioButtonId());
        mAudit.setOnTimeRadioID(mOnTimeRadio.getCheckedRadioButtonId());
        mAudit.setWaterRadioID(mWaterRadio.getCheckedRadioButtonId());
    }

}


