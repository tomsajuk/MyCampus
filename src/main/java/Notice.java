package com.ait_pro.tsk.mycampus;

/**
 * Created by TSK on 25-08-2016.
 */
public class Notice {

    private String heading;
    private String description;
    private String issued;

    public Notice(String headingPass, String descrip, String issue) {

        heading = headingPass;
        description = descrip;
        issued = issue;
    }

    public String getHeading() {
        return heading;
    }

    public String getDescription() {
        return description;
    }

    public String getIssued() {
        return issued;
    }

}
