package com.aarrowsignspinners.myaudits;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.UUID;


public class AppearanceFragment extends Fragment {

    public static final String ARG_PAGE = "arg_page";
    private static final String ARG_AUDIT_ID = "audit_id";


    private int mPage;
    private Audit mAudit;

    private RadioGroup mSmileRadio;
    private RadioGroup mUniformRadio;
    private RadioGroup mStyleRadio;
    private RadioGroup mDirectionRadio;
    private RadioGroup mPositioningRadio;

    public static AppearanceFragment newInstance(int section, UUID auditID) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, section);
        args.putSerializable(ARG_AUDIT_ID, auditID);
        AppearanceFragment fragment = new AppearanceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
        UUID auditID = (UUID) getArguments().getSerializable(ARG_AUDIT_ID);
        mAudit = AuditList.get(getActivity()).getAudit(auditID);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_appearance, container, false);
        return view;
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mSmileRadio = (RadioGroup) view.findViewById(R.id.smile_radio);
        mSmileRadio.check(mAudit.getSmileRadioID());

        mUniformRadio = (RadioGroup) view.findViewById(R.id.uniform_radio);
        mUniformRadio.check(mAudit.getUniformRadioID());

        mStyleRadio = (RadioGroup) view.findViewById(R.id.style_radio);
        mStyleRadio.check(mAudit.getStyleRadioID());

        mDirectionRadio = (RadioGroup) view.findViewById(R.id.direction_radio);
        mDirectionRadio.check(mAudit.getDirectionRadioID());

        mPositioningRadio = (RadioGroup) view.findViewById(R.id.positioning_radio);
        mPositioningRadio.check(mAudit.getPositioningRadioID());


        mSmileRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (mSmileRadio.getCheckedRadioButtonId()) {
                    case R.id.smil_rb5:
                        mAudit.setSmilePoints(5);
                        break;
                    case R.id.smil_rb4:
                        mAudit.setSmilePoints(4);
                        break;
                    case R.id.smile_rb3:
                        mAudit.setSmilePoints(3);
                        break;
                    case R.id.smil_rb2:
                        mAudit.setSmilePoints(2);
                        break;
                    case R.id.smil_rb1:
                        mAudit.setSmilePoints(1);
                        break;
                }

            }
        });

        mUniformRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (mUniformRadio.getCheckedRadioButtonId()) {
                    case R.id.unif_rb5:
                        mAudit.setUniformPoints(5);
                        break;
                    case R.id.unif_rb4:
                        mAudit.setUniformPoints(4);
                        break;
                    case R.id.unif_rb3:
                        mAudit.setUniformPoints(3);
                        break;
                    case R.id.unif_rb2:
                        mAudit.setUniformPoints(2);
                        break;
                    case R.id.unif_rb1:
                        mAudit.setUniformPoints(1);
                        break;
                }

            }
        });

        mStyleRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (mStyleRadio.getCheckedRadioButtonId()) {
                    case R.id.styl_rb5:
                        mAudit.setStylePoints(5);
                        break;
                    case R.id.styl_rb4:
                        mAudit.setStylePoints(4);
                        break;
                    case R.id.styl_rb3:
                        mAudit.setStylePoints(3);
                        break;
                    case R.id.styl_rb2:
                        mAudit.setStylePoints(2);
                        break;
                    case R.id.styl_rb1:
                        mAudit.setStylePoints(1);
                        break;
                }

            }
        });

        mDirectionRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (mDirectionRadio.getCheckedRadioButtonId()) {
                    case R.id.dire_rb5:
                        mAudit.setDirectionPoints(5);
                        break;
                    case R.id.dire_rb4:
                        mAudit.setDirectionPoints(4);
                        break;
                    case R.id.dire_rb3:
                        mAudit.setDirectionPoints(3);
                        break;
                    case R.id.dire_rb2:
                        mAudit.setDirectionPoints(2);
                        break;
                    case R.id.dire_rb1:
                        mAudit.setDirectionPoints(1);
                        break;
                }

            }
        });

        mPositioningRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            RadioButton rb4 = (RadioButton) view.findViewById(R.id.posi_rb5);
            RadioButton rb3 = (RadioButton) view.findViewById(R.id.posi_rb4);
            RadioButton rb2 = (RadioButton) view.findViewById(R.id.posi_rb3);
            RadioButton rb1 = (RadioButton) view.findViewById(R.id.posi_rb2);
            RadioButton rb0 = (RadioButton) view.findViewById(R.id.posi_rb1);

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (mPositioningRadio.getCheckedRadioButtonId()) {
                    case R.id.posi_rb5:
                        mAudit.setPositioningPoints(5);
                        rb4.setTypeface(Typeface.DEFAULT_BOLD);
                        rb3.setTypeface(Typeface.DEFAULT);
                        rb2.setTypeface(Typeface.DEFAULT);
                        rb1.setTypeface(Typeface.DEFAULT);
                        rb0.setTypeface(Typeface.DEFAULT);
                        break;
                    case R.id.posi_rb4:
                        mAudit.setPositioningPoints(4);
                        rb4.setTypeface(Typeface.DEFAULT);
                        rb3.setTypeface(Typeface.DEFAULT_BOLD);
                        rb2.setTypeface(Typeface.DEFAULT);
                        rb1.setTypeface(Typeface.DEFAULT);
                        rb0.setTypeface(Typeface.DEFAULT);
                        break;
                    case R.id.posi_rb3:
                        mAudit.setPositioningPoints(3);
                        rb4.setTypeface(Typeface.DEFAULT);
                        rb3.setTypeface(Typeface.DEFAULT);
                        rb2.setTypeface(Typeface.DEFAULT_BOLD);
                        rb1.setTypeface(Typeface.DEFAULT);
                        rb0.setTypeface(Typeface.DEFAULT);
                        break;
                    case R.id.posi_rb2:
                        mAudit.setPositioningPoints(2);
                        rb4.setTypeface(Typeface.DEFAULT);
                        rb3.setTypeface(Typeface.DEFAULT);
                        rb2.setTypeface(Typeface.DEFAULT);
                        rb1.setTypeface(Typeface.DEFAULT_BOLD);
                        rb0.setTypeface(Typeface.DEFAULT);
                        break;
                    case R.id.posi_rb1:
                        mAudit.setPositioningPoints(1);
                        rb4.setTypeface(Typeface.DEFAULT);
                        rb3.setTypeface(Typeface.DEFAULT);
                        rb2.setTypeface(Typeface.DEFAULT);
                        rb1.setTypeface(Typeface.DEFAULT);
                        rb0.setTypeface(Typeface.DEFAULT_BOLD);
                        break;
                }
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        mAudit.getTotalAppearancePoints();
        mAudit.setSmileRadioID(mSmileRadio.getCheckedRadioButtonId());
        mAudit.setUniformRadioID(mUniformRadio.getCheckedRadioButtonId());
        mAudit.setStyleRadioID(mStyleRadio.getCheckedRadioButtonId());
        mAudit.setDirectionRadioID(mDirectionRadio.getCheckedRadioButtonId());
        mAudit.setPositioningRadioID(mPositioningRadio.getCheckedRadioButtonId());
    }


}


