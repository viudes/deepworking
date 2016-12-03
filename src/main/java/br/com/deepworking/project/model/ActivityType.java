package br.com.deepworking.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class ActivityType {

    @Id
    @SequenceGenerator(name = "activityTypeSeq", sequenceName = "activity_type_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "activityTypeSeq")
    private Integer id;

    private String name;

    private String description;

    @ManyToOne
    private Project project;

    @Deprecated
    ActivityType() {
    }

    ActivityType(String name) {
        super();
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return project;
    }

    @Override
    public String toString() {
        return "ActivityType [id=" + id + ", name=" + name + ", description=" + description + ", project=" + project
                + "]";
    }

}
