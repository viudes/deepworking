package br.com.deepworking.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Label {

    @Id
    @SequenceGenerator(name = "labelSeq", sequenceName = "label_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "labelSeq")
    private Integer id;

    private String name;

    private String description;

    @Deprecated
    Label() {
    }

    public Label(String name, String description) {
        this.name = name;
        this.description = description;
    }

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

    public Integer getId() {
        return id;
    }

}
