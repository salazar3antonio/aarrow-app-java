package com.aarrowsignspinners.myaudits;

import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import java.util.UUID;


public class TechnicalFragment extends Fragment {

    public static final String ARG_PAGE = "arg_page";
    private static final String ARG_AUDIT_ID = "audit_id";

    private RadioGroup mDifficultyRadio;
    private RadioGroup mPowerRadio;
    private RadioGroup mTransitionsRadio;
    private RadioGroup mCatchesRadio;
    private RadioGroup mFreezesRadio;

    private int mPage;
    private Audit mAudit;


    public static TechnicalFragment newInstance(int section, UUID auditID) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, section);
        args.putSerializable(ARG_AUDIT_ID, auditID);
        TechnicalFragment fragment = new TechnicalFragment();
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
        View view = inflater.inflate(R.layout.fragment_technical, container, false);

        mDifficultyRadio = (RadioGroup) view.findViewById(R.id.difficulty_radio);
        mDifficultyRadio.check(mAudit.getDifficultyRadioID());

        mPowerRadio = (RadioGroup) view.findViewById(R.id.power_radio);
        mPowerRadio.check(mAudit.getPowerRadioID());

        mTransitionsRadio = (RadioGroup) view.findViewById(R.id.transitions_radio);
        mTransitionsRadio.check(mAudit.getTransitionsRadioID());

        mCatchesRadio = (RadioGroup) view.findViewById(R.id.catches_radio);
        mCatchesRadio.check(mAudit.getCatchesRadioID());

        mFreezesRadio = (RadioGroup) view.findViewById(R.id.freezes_radio);
        mFreezesRadio.check(mAudit.getFreezesRadioID());

        mDifficultyRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (mDifficultyRadio.getCheckedRadioButtonId()) {
                    case R.id.diff_rb5:
                        mAudit.setDifficultyPoints(5);
                        break;
                    case R.id.diff_rb4:
                        mAudit.setDifficultyPoints(4);
                        break;
                    case R.id.diff_rb3:
                        mAudit.setDifficultyPoints(3);
                        break;
                    case R.id.diff_rb2:
                        mAudit.setDifficultyPoints(2);
                        break;
                    case R.id.diff_rb1:
                        mAudit.setDifficultyPoints(1);
                        break;
                }

            }
        });

        mPowerRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (mPowerRadio.getCheckedRadioButtonId()) {
                    case R.id.powr_rb5:
                        mAudit.setPowerPoints(5);
                        break;
                    case R.id.powr_rb4:
                        mAudit.setPowerPoints(4);
                        break;
                    case R.id.powr_rb3:
                        mAudit.setPowerPoints(3);
                        break;
                    case R.id.powr_rb2:
                        mAudit.setPowerPoints(2);
                        break;
                    case R.id.powr_rb1:
                        mAudit.setPowerPoints(1);
                        break;
                }

            }
        });

        mTransitionsRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (mTransitionsRadio.getCheckedRadioButtonId()) {
                    case R.id.tran_rb5:
                        mAudit.setTransitionsPoints(5);
                        break;
                    case R.id.tran_rb4:
                        mAudit.setTransitionsPoints(4);
                        break;
                    case R.id.tran_rb3:
                        mAudit.setTransitionsPoints(3);
                        break;
                    case R.id.tran_rb2:
                        mAudit.setTransitionsPoints(2);
                        break;
                    case R.id.tran_rb1:
                        mAudit.setTransitionsPoints(1);
                        break;
                }

            }
        });

        mCatchesRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (mCatchesRadio.getCheckedRadioButtonId()) {
                    case R.id.catc_rb5:
                        mAudit.setCatchesPoints(5);
                        break;
                    case R.id.catc_rb4:
                        mAudit.setCatchesPoints(4);
                        break;
                    case R.id.catc_rb3:
                        mAudit.setCatchesPoints(3);
                        break;
                    case R.id.catc_rb2:
                        mAudit.setCatchesPoints(2);
                        break;
                    case R.id.catc_rb1:
                        mAudit.setCatchesPoints(1);
                        break;
                }

            }
        });

        mFreezesRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (mFreezesRadio.getCheckedRadioButtonId()) {
                    case R.id.free_rb5:
                        mAudit.setFreezesPoints(5);
                        break;
                    case R.id.free_rb4:
                        mAudit.setFreezesPoints(4);
                        break;
                    case R.id.free_rb3:
                        mAudit.setFreezesPoints(3);
                        break;
                    case R.id.free_rb2:
                        mAudit.setFreezesPoints(2);
                        break;
                    case R.id.free_rb1:
                        mAudit.setFreezesPoints(1);
                        break;
                }

            }
        });

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        mAudit.getTotalTechnicalPoints();
        mAudit.setDifficultyRadioID(mDifficultyRadio.getCheckedRadioButtonId());
        mAudit.setPowerRadioID(mPowerRadio.getCheckedRadioButtonId());
        mAudit.setTransitionsRadioID(mTransitionsRadio.getCheckedRadioButtonId());
        mAudit.setCatchesRadioID(mCatchesRadio.getCheckedRadioButtonId());
        mAudit.setFreezesRadioID(mFreezesRadio.getCheckedRadioButtonId());
    }
}


