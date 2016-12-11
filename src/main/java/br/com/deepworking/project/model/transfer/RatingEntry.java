package br.com.deepworking.project.model.transfer;


public class RatingEntry {

    private Integer scorePoint;

    private Integer interruptions;

    private String notes;

    private Integer activityId;

    public Integer getScorePoint() {
        return scorePoint;
    }

    public void setScorePoint(Integer scorePoint) {
        this.scorePoint = scorePoint;
    }

    public Integer getInterruptions() {
        return interruptions;
    }

    public void setInterruptions(Integer interruptions) {
        this.interruptions = interruptions;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    @Override
    public String toString() {
        return "RatingEntry [scorePoint=" + scorePoint + ", interruptions=" + interruptions + ", notes=" + notes
                + ", activityId=" + activityId + "]";
    }

}
