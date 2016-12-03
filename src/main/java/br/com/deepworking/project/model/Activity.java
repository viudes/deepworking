package br.com.deepworking.project.model;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Activity {

    @Id
    @SequenceGenerator(name = "activitySeq", sequenceName = "activity_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "activitySeq")
    private Integer id;

    @ManyToOne
    private Project project;

    @ManyToOne
    private ActivityType activityType;

    private OffsetDateTime startTime;

    private int amountTimeInMinutes;

    private String description;

    public Integer getId() {
        return id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public OffsetDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(OffsetDateTime startTime) {
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
        return "Activity [id=" + id + ", project=" + project + ", activityType=" + activityType + ", startTime="
                + startTime + ", amountTimeInMinutes=" + amountTimeInMinutes + ", description=" + description + "]";
    }

}
