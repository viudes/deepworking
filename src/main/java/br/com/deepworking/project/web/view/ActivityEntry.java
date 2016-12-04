package br.com.deepworking.project.web.view;

public class ActivityEntry {

    private String date;

    private String activityType;

    private String startTime;

    private int amountHours;

    private String description;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public int getAmountHours() {
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
        return "ActivityEntry [date=" + date + ", activityType=" + activityType + ", startTime=" + startTime
                + ", amountHours=" + amountHours + ", description=" + description + "]";
    }

}
