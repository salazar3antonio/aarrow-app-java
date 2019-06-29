package com.aarrowsignspinners.myaudits;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;


public class AdvertisingFragment extends Fragment {

    public static final String ARG_PAGE = "arg_page";
    private static final String ARG_AUDIT_ID = "audit_id";


    private int mPage;
    private Audit mAudit;

    private RadioGroup mAAMRadio;
    private RadioGroup mPresentationRadio;
    private RadioGroup mEyeContactRadio;
    private RadioGroup mAwarenessRadio;
    private RadioGroup mSafetyRadio;


    public static AdvertisingFragment newInstance(int section, UUID auditID) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, section);
        args.putSerializable(ARG_AUDIT_ID, auditID);
        AdvertisingFragment fragment = new AdvertisingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
        UUID auditID = (UUID) getArguments().getSerializable(ARG_AUDIT_ID);
        mAudit = AuditList.get(getActivity()).getAudit(auditID);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_advertising, container, false);
        return view;
    }

    ;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAAMRadio = (RadioGroup) view.findViewById(R.id.aam_radio);
        mAAMRadio.check(mAudit.getAAMRadioID());

        mPresentationRadio = (RadioGroup) view.findViewById(R.id.presentation_radio);
        mPresentationRadio.check(mAudit.getPresentationRadioID());

        mEyeContactRadio = (RadioGroup) view.findViewById(R.id.eyecontact_radio);
        mEyeContactRadio.check(mAudit.getEyeContactRadioID());

        mAwarenessRadio = (RadioGroup) view.findViewById(R.id.awareness_radio);
        mAwarenessRadio.check(mAudit.getAwarenessRadioID());

        mSafetyRadio = (RadioGroup) view.findViewById(R.id.safety_radio);
        mSafetyRadio.check(mAudit.getSafetyControlRadioID());


        mAAMRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (mAAMRadio.getCheckedRadioButtonId()) {
                    case R.id.aam_rb5:
                        mAudit.setAAMPoints(5);
                        break;
                    case R.id.aam_rb4:
                        mAudit.setAAMPoints(4);
                        break;
                    case R.id.aam_rb3:
                        mAudit.setAAMPoints(3);
                        break;
                    case R.id.aam_rb2:
                        mAudit.setAAMPoints(2);
                        break;
                    case R.id.aam_rb1:
                        mAudit.setAAMPoints(1);
                        break;
                }

            }
        });

        mPresentationRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (mPresentationRadio.getCheckedRadioButtonId()) {
                    case R.id.pres_rb5:
                        mAudit.setPresentationPoints(5);
                        break;
                    case R.id.pres_rb4:
                        mAudit.setPresentationPoints(4);
                        break;
                    case R.id.pres_rb3:
                        mAudit.setPresentationPoints(3);
                        break;
                    case R.id.pres_rb2:
                        mAudit.setPresentationPoints(2);
                        break;
                    case R.id.pres_rb1:
                        mAudit.setPresentationPoints(1);
                        break;
                }

            }
        });

        mEyeContactRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (mEyeContactRadio.getCheckedRadioButtonId()) {
                    case R.id.eyec_rb5:
                        mAudit.setEyeContactPoints(5);
                        break;
                    case R.id.eyec_rb4:
                        mAudit.setEyeContactPoints(4);
                        break;
                    case R.id.eyec_rb3:
                        mAudit.setEyeContactPoints(3);
                        break;
                    case R.id.eyec_rb2:
                        mAudit.setEyeContactPoints(2);
                        break;
                    case R.id.eyec_rb1:
                        mAudit.setEyeContactPoints(1);
                        break;
                }

            }
        });

        mAwarenessRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (mAwarenessRadio.getCheckedRadioButtonId()) {
                    case R.id.awar_rb5:
                        mAudit.setAwarenessPoints(5);
                        break;
                    case R.id.awar_rb4:
                        mAudit.setAwarenessPoints(4);
                        break;
                    case R.id.awar_rb3:
                        mAudit.setAwarenessPoints(3);
                        break;
                    case R.id.awar_rb2:
                        mAudit.setAwarenessPoints(2);
                        break;
                    case R.id.awar_rb1:
                        mAudit.setAwarenessPoints(1);
                        break;
                }

            }
        });

        mSafetyRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (mSafetyRadio.getCheckedRadioButtonId()) {
                    case R.id.safe_rb5:
                        mAudit.setSafetyControlPoints(5);
                        break;
                    case R.id.safe_rb4:
                        mAudit.setSafetyControlPoints(4);
                        break;
                    case R.id.safe_rb3:
                        mAudit.setSafetyControlPoints(3);
                        break;
                    case R.id.safe_rb2:
                        mAudit.setSafetyControlPoints(2);
                        break;
                    case R.id.safe_rb1:
                        mAudit.setSafetyControlPoints(1);
                        break;
                }

            }
        });

    }

    @Override
    public void onPause() {
        super.onPause();
        mAudit.getTotalAdvertisingPoints();
        mAudit.setAAMRadioID(mAAMRadio.getCheckedRadioButtonId());
        mAudit.setPresentationRadioID(mPresentationRadio.getCheckedRadioButtonId());
        mAudit.setEyeContactRadioID(mEyeContactRadio.getCheckedRadioButtonId());
        mAudit.setAwarenessRadioID(mAwarenessRadio.getCheckedRadioButtonId());
        mAudit.setSafetyControlRadioID(mSafetyRadio.getCheckedRadioButtonId());
    }
}


