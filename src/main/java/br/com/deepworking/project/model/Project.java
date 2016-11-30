package br.com.deepworking.project.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Project {

    @Id
    @SequenceGenerator(name = "projectSeq", sequenceName = "project_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projectSeq")
    private Integer id;

    private String name;

    private Labels labels = new Labels();

    @Deprecated
    Project() {
    }

    public Project(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Labels getLabels() {
        return labels;
    }

    public void addLabel(Label label) {
        labels.add(label);
    }

}
