package com.aarrowsignspinners.myaudits;

import android.graphics.Bitmap;

import java.util.Date;
import java.util.UUID;

/**
 * Created by salaz on 2/21/2016.
 */
public class Audit {

    private int mTotalAuditPoints;
    private UUID mAuditID;

    public Audit() {
        mDate = new Date();
        mAuditID = UUID.randomUUID();
    }

    public UUID getAuditID() {
        return mAuditID;
    }

    public int getTotalAuditPoints() {
        mTotalAuditPoints = mTotalAppearancePoints + mTotalAdvertisingPoints + mTotalEnergyPoints + mTotalTechnicalPoints;
        return mTotalAuditPoints;
    }

    public void setTotalAuditPoints(int totalAuditPoints) {
        mTotalAuditPoints = totalAuditPoints;
    }

    // BASIC INFO SECTION
    private String mSpinnerName;
    private Date mDate;
    private String mLocation;
    private String mCorner;

    public String getSpinnerName() {
        return mSpinnerName;
    }

    public void setSpinnerName(String spinnerName) {
        mSpinnerName = spinnerName;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public String getCorner() {
        return mCorner;
    }

    public void setCorner(String corner) {
        mCorner = corner;
    }

    // PREPAREDNESS SECTION
    private int mTotalPreparednessPoints;
    private int mConfirmationPoints;
    private int mArrivalTextPoints;
    private int mSignInSheetPoints;
    private int mOnTimePoints;
    private int mWaterPoints;

    private int mConfirmationRadioID = R.id.conf_no;
    private int mArrivalTextRadioID = R.id.arrival_no;
    private int mSignInSheetRadioID = R.id.sis_no;
    private int mOnTimeRadioID = R.id.ontime_no;
    private int mWaterRadioID = R.id.water_no;

    public int getTotalPreparednessPoints() {
        mTotalPreparednessPoints = mArrivalTextPoints + mConfirmationPoints + mOnTimePoints + mWaterPoints + mSignInSheetPoints;
        return mTotalPreparednessPoints;
    }

    public int getConfirmationPoints() {
        return mConfirmationPoints;
    }

    public void setConfirmationPoints(int confirmationPoints) {
        mConfirmationPoints = confirmationPoints;
    }

    public int getConfirmationRadioID() {
        return mConfirmationRadioID;
    }

    public void setConfirmationRadioID(int confirmationRadioID) {
        mConfirmationRadioID = confirmationRadioID;
    }

    public int getArrivalTextPoints() {
        return mArrivalTextPoints;
    }

    public void setArrivalTextPoints(int arrivalTextPoints) {
        mArrivalTextPoints = arrivalTextPoints;
    }

    public int getArrivalTextRadioID() {
        return mArrivalTextRadioID;
    }

    public void setArrivalTextRadioID(int arrivalTextRadioID) {
        mArrivalTextRadioID = arrivalTextRadioID;
    }

    public int getSignInSheetPoints() {
        return mSignInSheetPoints;
    }

    public void setSignInSheetPoints(int signInSheetPoints) {
        mSignInSheetPoints = signInSheetPoints;
    }

    public int getSignInSheetRadioID() {
        return mSignInSheetRadioID;
    }

    public void setSignInSheetRadioID(int signInSheetRadioID) {
        mSignInSheetRadioID = signInSheetRadioID;
    }

    public int getOnTimePoints() {
        return mOnTimePoints;
    }

    public void setOnTimePoints(int onTimePoints) {
        mOnTimePoints = onTimePoints;
    }

    public int getOnTimeRadioID() {
        return mOnTimeRadioID;
    }

    public void setOnTimeRadioID(int onTimeRadioID) {
        mOnTimeRadioID = onTimeRadioID;
    }

    public int getWaterPoints() {
        return mWaterPoints;
    }

    public void setWaterPoints(int waterPoints) {
        mWaterPoints = waterPoints;
    }

    public int getWaterRadioID() {
        return mWaterRadioID;
    }

    public void setWaterRadioID(int waterRadioID) {
        mWaterRadioID = waterRadioID;
    }

    // APPEARANCE SECTION
    private int mTotalAppearancePoints;
    private int mSmilePoints = 1;
    private int mUniformPoints = 1;
    private int mDirectionPoints= 1;
    private int mStylePoints = 1;
    private int mPositioningPoints = 1;

    private int mSmileRadioID = R.id.smil_rb1;
    private int mUniformRadioID = R.id.unif_rb1;
    private int mDirectionRadioID = R.id.dire_rb1;
    private int mStyleRadioID = R.id.styl_rb1;
    private int mPositioningRadioID = R.id.posi_rb1;

    public int getTotalAppearancePoints() {
        mTotalAppearancePoints = mSmilePoints + mUniformPoints + mStylePoints + mDirectionPoints + mPositioningPoints;
        return mTotalAppearancePoints;
    }

    public void setTotalAppearancePoints(int totalAppearancePoints) {
        mTotalAppearancePoints = totalAppearancePoints;
    }

    public int getSmilePoints() {
        return mSmilePoints;
    }

    public void setSmilePoints(int smilePoints) {
        mSmilePoints = smilePoints;
    }

    public int getSmileRadioID() {
        return mSmileRadioID;
    }

    public void setSmileRadioID(int smileRadioID) {
        mSmileRadioID = smileRadioID;
    }

    public int getUniformPoints() {
        return mUniformPoints;
    }

    public void setUniformPoints(int uniformPoints) {
        mUniformPoints = uniformPoints;
    }

    public int getUniformRadioID() {
        return mUniformRadioID;
    }

    public void setUniformRadioID(int uniformRadioID) {
        mUniformRadioID = uniformRadioID;
    }

    public int getStylePoints() {
        return mStylePoints;
    }

    public void setStylePoints(int stylePoints) {
        mStylePoints = stylePoints;
    }

    public int getStyleRadioID() {
        return mStyleRadioID;
    }

    public void setStyleRadioID(int styleRadioID) {
        mStyleRadioID = styleRadioID;
    }

    public int getDirectionPoints() {
        return mDirectionPoints;
    }

    public void setDirectionPoints(int directionPoints) {
        mDirectionPoints = directionPoints;
    }

    public int getDirectionRadioID() {
        return mDirectionRadioID;
    }

    public void setDirectionRadioID(int directionRadioID) {
        mDirectionRadioID = directionRadioID;
    }

    public int getPositioningPoints() {
        return mPositioningPoints;
    }

    public void setPositioningPoints(int positioningPoints) {
        mPositioningPoints = positioningPoints;
    }

    public int getPositioningRadioID() {
        return mPositioningRadioID;
    }

    public void setPositioningRadioID(int positioningRadioID) {
        mPositioningRadioID = positioningRadioID;
    }

    // ADVERTISING SECTION
    private int mTotalAdvertisingPoints;
    private int mAAMPoints = 1;
    private int mPresentationPoints = 1;
    private int mEyeContactPoints = 1;
    private int mAwarenessPoints = 1;
    private int mSafetyControlPoints = 1;

    private int mAAMRadioID = R.id.aam_rb1;
    private int mPresentationRadioID = R.id.pres_rb1;
    private int mEyeContactRadioID = R.id.eyec_rb1;
    private int mAwarenessRadioID = R.id.awar_rb1;
    private int mSafetyControlRadioID = R.id.safe_rb1;

    public int getTotalAdvertisingPoints() {
        mTotalAdvertisingPoints = mAAMPoints + mPresentationPoints + mEyeContactPoints + mAwarenessPoints + mSafetyControlPoints;
        return mTotalAdvertisingPoints;
    }

    public void setTotalAdvertisingPoints(int totalAdvertisingPoints) {
        mTotalAdvertisingPoints = totalAdvertisingPoints;
    }

    public int getAAMPoints() {
        return mAAMPoints;
    }

    public void setAAMPoints(int AAMPoints) {
        mAAMPoints = AAMPoints;
    }

    public int getPresentationPoints() {
        return mPresentationPoints;
    }

    public void setPresentationPoints(int presentationPoints) {
        mPresentationPoints = presentationPoints;
    }

    public int getEyeContactPoints() {
        return mEyeContactPoints;
    }

    public void setEyeContactPoints(int eyeContactPoints) {
        mEyeContactPoints = eyeContactPoints;
    }

    public int getAwarenessPoints() {
        return mAwarenessPoints;
    }

    public void setAwarenessPoints(int awarenessPoints) {
        mAwarenessPoints = awarenessPoints;
    }

    public int getSafetyControlPoints() {
        return mSafetyControlPoints;
    }

    public void setSafetyControlPoints(int safetyControlPoints) {
        mSafetyControlPoints = safetyControlPoints;
    }

    public int getAAMRadioID() {
        return mAAMRadioID;
    }

    public void setAAMRadioID(int AAMRadioID) {
        mAAMRadioID = AAMRadioID;
    }

    public int getPresentationRadioID() {
        return mPresentationRadioID;
    }

    public void setPresentationRadioID(int presentationRadioID) {
        mPresentationRadioID = presentationRadioID;
    }

    public int getEyeContactRadioID() {
        return mEyeContactRadioID;
    }

    public void setEyeContactRadioID(int eyeContactRadioID) {
        mEyeContactRadioID = eyeContactRadioID;
    }

    public int getAwarenessRadioID() {
        return mAwarenessRadioID;
    }

    public void setAwarenessRadioID(int awarenessRadioID) {
        mAwarenessRadioID = awarenessRadioID;
    }

    public int getSafetyControlRadioID() {
        return mSafetyControlRadioID;
    }

    public void setSafetyControlRadioID(int safetyControlRadioID) {
        mSafetyControlRadioID = safetyControlRadioID;
    }

    // ENERGY SECTION
    private int mTotalEnergyPoints;
    private int mPersonalityPoints = 1;
    private int mSpinteractionPoints = 1;
    private int mDancingPoints = 1;
    private int mEndurancePoints = 1;
    private int mRecoveryPoints = 1;

    private int mPersonalityRadioID = R.id.pers_rb1;
    private int mSpinterationRadioID = R.id.spin_rb1;
    private int mDancingRadioID = R.id.danc_rb1;
    private int mEnduranceRadioID = R.id.endu_rb1;
    private int mRecoveryRadioID = R.id.reco_rb1;

    public int getTotalEnergyPoints() {
        mTotalEnergyPoints = mPersonalityPoints + mSpinteractionPoints + mDancingPoints + mEndurancePoints + mRecoveryPoints;
        return mTotalEnergyPoints;
    }

    public void setTotalEnergyPoints(int totalEnergyPoints) {
        mTotalEnergyPoints = totalEnergyPoints;
    }

    public int getPersonalityPoints() {
        return mPersonalityPoints;
    }

    public void setPersonalityPoints(int personalityPoints) {
        mPersonalityPoints = personalityPoints;
    }

    public int getSpinteractionPoints() {
        return mSpinteractionPoints;
    }

    public void setSpinteractionPoints(int spinteractionPoints) {
        mSpinteractionPoints = spinteractionPoints;
    }

    public int getDancingPoints() {
        return mDancingPoints;
    }

    public void setDancingPoints(int dancingPoints) {
        mDancingPoints = dancingPoints;
    }

    public int getEndurancePoints() {
        return mEndurancePoints;
    }

    public void setEndurancePoints(int endurancePoints) {
        mEndurancePoints = endurancePoints;
    }

    public int getRecoveryPoints() {
        return mRecoveryPoints;
    }

    public void setRecoveryPoints(int recoveryPoints) {
        mRecoveryPoints = recoveryPoints;
    }

    public int getPersonalityRadioID() {
        return mPersonalityRadioID;
    }

    public void setPersonalityRadioID(int personalityRadioID) {
        mPersonalityRadioID = personalityRadioID;
    }

    public int getSpinterationRadioID() {
        return mSpinterationRadioID;
    }

    public void setSpinterationRadioID(int spinterationRadioID) {
        mSpinterationRadioID = spinterationRadioID;
    }

    public int getDancingRadioID() {
        return mDancingRadioID;
    }

    public void setDancingRadioID(int dancingRadioID) {
        mDancingRadioID = dancingRadioID;
    }

    public int getEnduranceRadioID() {
        return mEnduranceRadioID;
    }

    public void setEnduranceRadioID(int enduranceRadioID) {
        mEnduranceRadioID = enduranceRadioID;
    }

    public int getRecoveryRadioID() {
        return mRecoveryRadioID;
    }

    public void setRecoveryRadioID(int recoveryRadioID) {
        mRecoveryRadioID = recoveryRadioID;
    }

    // TECHNICAL SECTION
    private int mTotalTechnicalPoints;
    private int mDifficultyPoints = 1;
    private int mPowerPoints = 1;
    private int mTransitionsPoints = 1;
    private int mCatchesPoints = 1;
    private int mFreezesPoints = 1;

    private int mDifficultyRadioID = R.id.diff_rb1;
    private int mPowerRadioID = R.id.powr_rb1;
    private int mTransitionsRadioID = R.id.tran_rb1;
    private int mCatchesRadioID = R.id.catc_rb1;
    private int mFreezesRadioID = R.id.free_rb1;

    public int getTotalTechnicalPoints() {
        mTotalTechnicalPoints = mDifficultyPoints + mPowerPoints + mTransitionsPoints + mCatchesPoints + mFreezesPoints;
        return mTotalTechnicalPoints;
    }

    public void setTotalTechnicalPoints(int totalTechnicalPoints) {
        mTotalTechnicalPoints = totalTechnicalPoints;
    }

    public int getDifficultyPoints() {
        return mDifficultyPoints;
    }

    public void setDifficultyPoints(int difficultyPoints) {
        mDifficultyPoints = difficultyPoints;
    }

    public int getPowerPoints() {
        return mPowerPoints;
    }

    public void setPowerPoints(int powerPoints) {
        mPowerPoints = powerPoints;
    }

    public int getTransitionsPoints() {
        return mTransitionsPoints;
    }

    public void setTransitionsPoints(int transitionsPoints) {
        mTransitionsPoints = transitionsPoints;
    }

    public int getCatchesPoints() {
        return mCatchesPoints;
    }

    public void setCatchesPoints(int catchesPoints) {
        mCatchesPoints = catchesPoints;
    }

    public int getFreezesPoints() {
        return mFreezesPoints;
    }

    public void setFreezesPoints(int freezesPoints) {
        mFreezesPoints = freezesPoints;
    }

    public int getDifficultyRadioID() {
        return mDifficultyRadioID;
    }

    public void setDifficultyRadioID(int difficultyRadioID) {
        mDifficultyRadioID = difficultyRadioID;
    }

    public int getPowerRadioID() {
        return mPowerRadioID;
    }

    public void setPowerRadioID(int powerRadioID) {
        mPowerRadioID = powerRadioID;
    }

    public int getTransitionsRadioID() {
        return mTransitionsRadioID;
    }

    public void setTransitionsRadioID(int transitionsRadioID) {
        mTransitionsRadioID = transitionsRadioID;
    }

    public int getCatchesRadioID() {
        return mCatchesRadioID;
    }

    public void setCatchesRadioID(int catchesRadioID) {
        mCatchesRadioID = catchesRadioID;
    }

    public int getFreezesRadioID() {
        return mFreezesRadioID;
    }

    public void setFreezesRadioID(int freezesRadioID) {
        mFreezesRadioID = freezesRadioID;
    }

    // SUBMISSION SECTION
    private int mBonusPoints;
    private int mDemeritPoints;
    private String mDoingGreatAt;
    private String mImprovements;
    private Bitmap mPhotoSigBitmap;
    private boolean photoSigned = false;

    public int getBonusPoints() {
        return mBonusPoints;
    }

    public void setBonusPoints(int bonusPoints) {
        mBonusPoints = bonusPoints;
    }

    public int getDemeritPoints() {
        return mDemeritPoints;
    }

    public void setDemeritPoints(int demeritPoints) {
        mDemeritPoints = demeritPoints;
    }

    public String getDoingGreatAt() {
        return mDoingGreatAt;
    }

    public void setDoingGreatAt(String doingGreatAt) {
        mDoingGreatAt = doingGreatAt;
    }

    public String getImprovements() {
        return mImprovements;
    }

    public void setImprovements(String improvements) {
        mImprovements = improvements;
    }

    public boolean isPhotoSigned() {
        return photoSigned;
    }

    public void setIsPhotoTaken(boolean isPhotoTaken) {
        this.photoSigned = isPhotoTaken;
    }

    public Bitmap getPhotoSigBitmap() {
        return mPhotoSigBitmap;
    }

    public void setPhotoSigBitmap(Bitmap photoSigBitmap) {
        mPhotoSigBitmap = photoSigBitmap;
    }

    public String getPhotoSigFileName() {
        return "IMG_" + getAuditID().toString() + ".jpg";
    }
}
