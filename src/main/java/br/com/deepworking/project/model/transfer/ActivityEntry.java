package br.com.deepworking.project.model.transfer;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class ActivityEntry {

    private int projectId;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;

    @NotNull
    private String activityType;

    @NotNull
    private String startTime;

    @NotNull
    private int amountHours;

    private String description;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getAmountTimeInMinutes() {
        return amountHours;
    }

    public void setAmountHours(int amountHours) {
        this.amountHours = amountHours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ActivityEntry [projectId=" + projectId + ", date=" + date + ", activityType=" + activityType
                + ", startTime=" + startTime + ", amountHours=" + amountHours + ", description=" + description + "]";
    }

}
