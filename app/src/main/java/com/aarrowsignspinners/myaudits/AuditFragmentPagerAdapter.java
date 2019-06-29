package com.aarrowsignspinners.myaudits;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by salaz on 1/29/2016.
 */
public class AuditFragmentPagerAdapter extends FragmentPagerAdapter {

    //static member variables
    public static InformationFragment sInformationFragment = new InformationFragment();
  //  public static PreparednessFragment sPreparednessFragment = new PreparednessFragment();
    public static AppearanceFragment sAppearanceFragment = new AppearanceFragment();
    public static AdvertisingFragment sAdvertisingFragment = new AdvertisingFragment();
    public static EnergyFragment sEnergyFragment = new EnergyFragment();
    public static TechnicalFragment sTechnicalFragment = new TechnicalFragment();
    public static SubmissionFragment sSubmissionFragment = new SubmissionFragment();

    private UUID mAuditID;

    public AuditFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return sInformationFragment.newInstance(position, mAuditID);
           // case 1:
           //     return sPreparednessFragment.newInstance(position, mAuditID);
            case 1:
                return sAppearanceFragment.newInstance(position, mAuditID);
            case 2:
                return sAdvertisingFragment.newInstance(position, mAuditID);
            case 3:
                return sEnergyFragment.newInstance(position, mAuditID);
            case 4:
                return sTechnicalFragment.newInstance(position, mAuditID);
            case 5:
                return sSubmissionFragment.newInstance(position, mAuditID);

        }
        return null;

    }

    ;

    @Override
    public int getCount() {
        // Show 7 total pages.
        return 6;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Information";
        //    case 1:
          //      return "Preparedness";
            case 1:
                return "Appearance";
            case 2:
                return "Advertising";
            case 3:
                return "Energy";
            case 4:
                return "Technical";
            case 5:
                return "Submission";
        }
        return null;
    }

    public void setAuditID(UUID auditID) {
        mAuditID = auditID;
    }
}




