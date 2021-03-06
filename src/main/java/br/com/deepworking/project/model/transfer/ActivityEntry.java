package br.com.deepworking.project.model.transfer;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

public class ActivityEntry {

    private int projectId;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;

    @NotBlank
    private String activityType;

    @NotNull
    private String startTime;

    @NotNull
    @Min(value = 1)
    private int amountTimeInMinutes;

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
        return amountTimeInMinutes;
    }

    public void setAmountTimeInMinutes(int amountTimeInMinutes) {
        this.amountTimeInMinutes = amountTimeInMinutes;
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
                + ", startTime=" + startTime + ", amountHours=" + amountTimeInMinutes + ", description=" + description + "]";
    }

}
