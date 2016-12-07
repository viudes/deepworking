package br.com.deepworking.project.model.transfer;

import java.util.ArrayList;
import java.util.List;

public class ProjectEntry {

    private Integer id;

    private String name;

    private List<ActivityTypeEntry> activityTypes = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ActivityTypeEntry> getActivityTypes() {
        return activityTypes;
    }

    public void setActivityTypes(List<ActivityTypeEntry> activityTypes) {
        this.activityTypes = activityTypes;
    }

    public static class ActivityTypeEntry {

        private String name;

        private String description;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return "ActivityTypeEntry [name=" + name + ", description=" + description + "]";
        }

    }

    @Override
    public String toString() {
        return "ProjectEntry [name=" + name + ", activityTypes=" + activityTypes + "]";
    }

}
