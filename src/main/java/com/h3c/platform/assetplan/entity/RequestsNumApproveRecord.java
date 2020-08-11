package com.h3c.platform.assetplan.entity;

public class RequestsNumApproveRecord {
    private Integer assetplanid;

    private Integer reviewercount;

    private Integer dept3managercount;

    private Integer dept2managercount;

    private Integer plannercount;

    private Integer oqdeptreviewercount;

    private Integer dept1reviewercount;

    private String reviewerperson;

    public Integer getAssetplanid() {
        return assetplanid;
    }

    public void setAssetplanid(Integer assetplanid) {
        this.assetplanid = assetplanid;
    }

    public Integer getReviewercount() {
        return reviewercount;
    }

    public void setReviewercount(Integer reviewercount) {
        this.reviewercount = reviewercount;
    }

    public Integer getDept3managercount() {
        return dept3managercount;
    }

    public void setDept3managercount(Integer dept3managercount) {
        this.dept3managercount = dept3managercount;
    }

    public Integer getDept2managercount() {
        return dept2managercount;
    }

    public void setDept2managercount(Integer dept2managercount) {
        this.dept2managercount = dept2managercount;
    }

    public Integer getPlannercount() {
        return plannercount;
    }

    public void setPlannercount(Integer plannercount) {
        this.plannercount = plannercount;
    }

    public Integer getOqdeptreviewercount() {
        return oqdeptreviewercount;
    }

    public void setOqdeptreviewercount(Integer oqdeptreviewercount) {
        this.oqdeptreviewercount = oqdeptreviewercount;
    }

    public Integer getDept1reviewercount() {
        return dept1reviewercount;
    }

    public void setDept1reviewercount(Integer dept1reviewercount) {
        this.dept1reviewercount = dept1reviewercount;
    }

    public String getReviewerperson() {
        return reviewerperson;
    }

    public void setReviewerperson(String reviewerperson) {
        this.reviewerperson = reviewerperson == null ? null : reviewerperson.trim();
    }
}