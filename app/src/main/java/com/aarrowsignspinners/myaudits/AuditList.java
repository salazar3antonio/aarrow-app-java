package com.aarrowsignspinners.myaudits;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by salaz on 2/29/2016.
 */
public class AuditList {

    //a static member variable of Audit List
    private static AuditList sAuditList;

    //need to create a list of Audit elements. use data type List<E>
    private List<Audit> mAudits;

    private Context mContext;

    //a static class method that creates a new audit list if none is present else return the class variable sAuditList
    // this is a Singleton Class. It allows only one instance of itself to be created
    public static AuditList get(Context context) {
        if (sAuditList == null) {
            sAuditList = new AuditList(context);
        }
        return sAuditList;
    }

    //this private constructor creates a list array of audits and points mContext to the apps context
    private AuditList(Context context) {
        mContext = context.getApplicationContext();
        mAudits = new ArrayList<>();
    }

    public List<Audit> getAudits() {
        return mAudits;
    }

    //loop through the elements of mAudits until the UUID that was passed in is equal to the Audit element
    public Audit getAudit(UUID id) {
        for (Audit audit : mAudits) {
            if (audit.getAuditID().equals(id)) {
                return audit;
            }
        }
        return null;
    }

    public void addAudit(Audit a) {
        mAudits.add(a);
    }

    public void deleteAudit(Audit a) {
        mAudits.remove(a);
    }

    public File getPhotoSigFile(Audit audit) {
        //get the external directory path of the  context object of the app
        File externalDir = mContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        if (externalDir == null) {
            return null;
        } else {
            return new File(externalDir, audit.getPhotoSigFileName());
        }
    }

}
