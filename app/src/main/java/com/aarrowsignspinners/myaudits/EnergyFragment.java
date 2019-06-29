package com.aarrowsignspinners.myaudits;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import java.util.UUID;


public class EnergyFragment extends Fragment {

    public static final String ARG_PAGE = "arg_page";
    private static final String ARG_AUDIT_ID = "audit_id";

    private RadioGroup mPersonalityRadio;
    private RadioGroup mSpinteractionRadio;
    private RadioGroup mDancingRadio;
    private RadioGroup mEnduranceRadio;
    private RadioGroup mRecoveryRadio;

    private int mPage;
    private Audit mAudit;

    public static EnergyFragment newInstance(int section, UUID auditID) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, section);
        args.putSerializable(ARG_AUDIT_ID, auditID);
        EnergyFragment fragment = new EnergyFragment();
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
        View view = inflater.inflate(R.layout.fragment_energy, container, false);
        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPersonalityRadio = (RadioGroup) view.findViewById(R.id.personality_radio);
        mPersonalityRadio.check(mAudit.getPersonalityRadioID());

        mSpinteractionRadio = (RadioGroup) view.findViewById(R.id.spinteraction_radio);
        mSpinteractionRadio.check(mAudit.getSpinterationRadioID());

        mDancingRadio = (RadioGroup) view.findViewById(R.id.dancing_radio);
        mDancingRadio.check(mAudit.getSpinterationRadioID());

        mEnduranceRadio = (RadioGroup) view.findViewById(R.id.endurance_radio);
        mEnduranceRadio.check(mAudit.getEnduranceRadioID());

        mRecoveryRadio = (RadioGroup) view.findViewById(R.id.recovery_radio);
        mRecoveryRadio.check(mAudit.getRecoveryRadioID());


        mPersonalityRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (mPersonalityRadio.getCheckedRadioButtonId()) {
                    case R.id.pers_rb5:
                        mAudit.setPersonalityPoints(5);
                        break;
                    case R.id.pers_rb4:
                        mAudit.setPersonalityPoints(4);
                        break;
                    case R.id.pers_rb3:
                        mAudit.setPersonalityPoints(3);
                        break;
                    case R.id.pers_rb2:
                        mAudit.setPersonalityPoints(2);
                        break;
                    case R.id.pers_rb1:
                        mAudit.setPersonalityPoints(1);
                        break;
                }

            }
        });

        mSpinteractionRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (mSpinteractionRadio.getCheckedRadioButtonId()) {
                    case R.id.spin_rb5:
                        mAudit.setSpinteractionPoints(5);
                        break;
                    case R.id.spin_rb4:
                        mAudit.setSpinteractionPoints(4);
                        break;
                    case R.id.spin_rb3:
                        mAudit.setSpinteractionPoints(3);
                        break;
                    case R.id.spin_rb2:
                        mAudit.setSpinteractionPoints(2);
                        break;
                    case R.id.spin_rb1:
                        mAudit.setSpinteractionPoints(1);
                        break;
                }

            }
        });

        mDancingRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (mDancingRadio.getCheckedRadioButtonId()) {
                    case R.id.danc_rb5:
                        mAudit.setDancingPoints(5);
                        break;
                    case R.id.danc_rb4:
                        mAudit.setDancingPoints(4);
                        break;
                    case R.id.danc_rb3:
                        mAudit.setDancingPoints(3);
                        break;
                    case R.id.danc_rb2:
                        mAudit.setDancingPoints(2);
                        break;
                    case R.id.spin_rb1:
                        mAudit.setDancingPoints(1);
                        break;
                }
            }
        });

        mEnduranceRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (mEnduranceRadio.getCheckedRadioButtonId()) {
                    case R.id.endu_rb5:
                        mAudit.setEndurancePoints(5);
                        break;
                    case R.id.endu_rb4:
                        mAudit.setEndurancePoints(4);
                        break;
                    case R.id.endu_rb3:
                        mAudit.setEndurancePoints(3);
                        break;
                    case R.id.endu_rb2:
                        mAudit.setEndurancePoints(2);
                        break;
                    case R.id.endu_rb1:
                        mAudit.setEndurancePoints(1);
                        break;
                }
            }
        });

        mRecoveryRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (mRecoveryRadio.getCheckedRadioButtonId()) {
                    case R.id.reco_rb5:
                        mAudit.setRecoveryPoints(5);
                        break;
                    case R.id.reco_rb4:
                        mAudit.setRecoveryPoints(4);
                        break;
                    case R.id.reco_rb3:
                        mAudit.setRecoveryPoints(3);
                        break;
                    case R.id.reco_rb2:
                        mAudit.setRecoveryPoints(2);
                        break;
                    case R.id.reco_rb1:
                        mAudit.setRecoveryPoints(1);
                        break;
                }
            }
        });

    }

    @Override
    public void onPause() {
        super.onPause();
        mAudit.getTotalEnergyPoints();
        mAudit.setPersonalityRadioID(mPersonalityRadio.getCheckedRadioButtonId());
        mAudit.setSpinterationRadioID(mSpinteractionRadio.getCheckedRadioButtonId());
        mAudit.setDancingRadioID(mDancingRadio.getCheckedRadioButtonId());
        mAudit.setEnduranceRadioID(mEnduranceRadio.getCheckedRadioButtonId());
        mAudit.setRecoveryRadioID(mRecoveryRadio.getCheckedRadioButtonId());
    }
}


