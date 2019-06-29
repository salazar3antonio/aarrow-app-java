package com.aarrowsignspinners.myaudits;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by salaz on 2/8/2016.
 */
public class MyAuditsFragment extends Fragment {

    public static final String ARG_PAGE = "arg_page";
    private int mPage;

    private RecyclerView mRecyclerView;
    private AuditAdapter mAuditAdapter;

    public static MyAuditsFragment newInstance(int section) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, section);
        MyAuditsFragment fragment = new MyAuditsFragment();
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
        View view = inflater.inflate(R.layout.fragment_audit_list, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.audit_recycleView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateAuditList();

        return view;
    }


    //need to define inner class for View Holder

    private class AuditHolder extends RecyclerView.ViewHolder {

        private TextView mSpinnerName;
        private TextView mAuditScore;
        private TextView mAuditDate;
        private Audit mAudit;
        private ImageButton mEditAudit;
        private ImageButton mEmailAudit;
        private TextView mPhotoSignChecker;
        private ImageView mPhotoCheckerThumb;

        public AuditHolder(View itemView) {
            super(itemView);

            mSpinnerName = (TextView) itemView.findViewById(R.id.list_item_spinner_name);
            mAuditScore = (TextView) itemView.findViewById(R.id.list_item_audit_score);
            mAuditDate = (TextView) itemView.findViewById(R.id.list_item_audit_date);
            mPhotoSignChecker = (TextView) itemView.findViewById(R.id.list_item_audit_photoSignedView);
            mPhotoCheckerThumb = (ImageView) itemView.findViewById(R.id.photoChecker_thumb);

            mEditAudit = (ImageButton) itemView.findViewById(R.id.list_edit_button);
            mEditAudit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = AuditActivity.newIntent(getActivity(), mAudit.getAuditID());
                    startActivity(intent);

                }
            });

            mEmailAudit = (ImageButton) itemView.findViewById(R.id.list_share_button);
            mEmailAudit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_TEXT, getAuditSummary());
                    i.putExtra(Intent.EXTRA_SUBJECT, "Your AArrow Audit");
                    startActivity(i);
                }
            });
        }

        //here we set the text of the list item views to the values of the Audit object
        public void bindAudit(Audit audit) {
            mAudit = audit;
            mSpinnerName.setText(mAudit.getSpinnerName());
            mAuditScore.setText(String.valueOf(mAudit.getTotalAuditPoints()));
            mAuditDate.setText(String.valueOf(mAudit.getDate()));
            mPhotoCheckerThumb.setImageBitmap(mAudit.getPhotoSigBitmap());
            if (mAudit.isPhotoSigned()) {
                mPhotoSignChecker.setText(R.string.isPhotoSigned);
                mPhotoSignChecker.setTextColor(ContextCompat.getColor(getContext(), R.color.secondary_text));
                mEmailAudit.setEnabled(true);
            } else {
                mPhotoSignChecker.setText(R.string.isNotPhotoSigned);
                mPhotoSignChecker.setTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
                mEmailAudit.setEnabled(false);
            }

        }

        public String getAuditSummary() {
            String auditSummary = getString(R.string.audit_summary_email,
                    mAudit.getSpinnerName(), mAudit.getTotalAuditPoints(), mAudit.getLocation(),
                    mAudit.getTotalAppearancePoints(), mAudit.getTotalAdvertisingPoints(),
                    mAudit.getTotalEnergyPoints(), mAudit.getTotalTechnicalPoints(),
                    mAudit.getDoingGreatAt(), mAudit.getImprovements());
            return auditSummary;
        }

    }

    //need to define inner class for Adapter
    private class AuditAdapter extends RecyclerView.Adapter<AuditHolder> {

        private List<Audit> mAudits;

        // a public constructor to point the list of Audits once an AuditAdapter is created
        public AuditAdapter(List<Audit> audits) {
            mAudits = audits;
        }

        @Override
        public AuditHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_audit, parent, false);
            return new AuditHolder(view);
        }

        @Override
        public void onBindViewHolder(AuditHolder holder, int position) {
            Audit audit = mAudits.get(position);
            holder.bindAudit(audit);
        }

        @Override
        public int getItemCount() {
            return mAudits.size();
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        updateAuditList();
    }

    public void updateAuditList() {

        AuditList auditList = AuditList.get(getActivity());
        List<Audit> audits = auditList.getAudits();

        if (mAuditAdapter == null) {
            mAuditAdapter = new AuditAdapter(audits);
            mRecyclerView.setAdapter(mAuditAdapter);
        } else {
            mAuditAdapter.notifyDataSetChanged();
        }


    }

}
