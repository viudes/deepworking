package br.com.deepworking.project.model.transfer;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RatingEntry {

    @NotNull
    private Integer scorePoint;

    @NotNull
    @Min(0)
    private Integer interruptions;

    @Size(min = 0, max = 255)
    private String notes;

    @NotNull
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
