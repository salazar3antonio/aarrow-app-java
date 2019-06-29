package com.aarrowsignspinners.myaudits;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.UUID;


public class SubmissionFragment extends Fragment {

    public static final String ARG_PAGE = "arg_page";
    private static final String ARG_AUDIT_ID = "audit_id";
    private static final String EXTRA_PHOTOSIG_THUMB = "photosig_thumb";
    public static final int REQUEST_IMAGE_CAPTURE = 1;

    private int mPage;
    private Audit mAudit;

    private EditText mDoingGreatAt;
    private EditText mImprovements;
    private ImageButton mPhotoSigButton;
    private ImageView mPhotoSigImageView;
    private Bitmap mPhotoSigBitmap;

    public static SubmissionFragment newInstance(int section, UUID auditID) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, section);
        args.putSerializable(ARG_AUDIT_ID, auditID);
        SubmissionFragment fragment = new SubmissionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
        UUID auditID = (UUID) getArguments().getSerializable(ARG_AUDIT_ID);
        mAudit = AuditList.get(getActivity()).getAudit(auditID);
        if (savedInstanceState != null) {
            mPhotoSigBitmap = savedInstanceState.getParcelable(EXTRA_PHOTOSIG_THUMB);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_submission, container, false);

        mPhotoSigImageView = (ImageView) view.findViewById(R.id.photoSig_thumbnail);
        mPhotoSigImageView.setImageBitmap(mAudit.getPhotoSigBitmap());

        mDoingGreatAt = (EditText) view.findViewById(R.id.doing_great_at);
        mDoingGreatAt.setText(mAudit.getDoingGreatAt());
        mDoingGreatAt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mAudit.setDoingGreatAt(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mImprovements = (EditText) view.findViewById(R.id.improvements);
        mImprovements.setText(mAudit.getImprovements());
        mImprovements.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mAudit.setImprovements(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            Bundle extras = data.getExtras();
            mPhotoSigBitmap = (Bitmap) extras.get("data");
            mAudit.setPhotoSigBitmap(mPhotoSigBitmap);
            mAudit.setIsPhotoTaken(true);
            mPhotoSigImageView.setImageBitmap(mPhotoSigBitmap);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(EXTRA_PHOTOSIG_THUMB, mPhotoSigBitmap);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPhotoSigButton = (ImageButton) view.findViewById(R.id.photoSig_button);
        mPhotoSigButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent capturePhoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (capturePhoto.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivityForResult(capturePhoto, REQUEST_IMAGE_CAPTURE);
                }
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        mAudit.getTotalAuditPoints();
    }
}


