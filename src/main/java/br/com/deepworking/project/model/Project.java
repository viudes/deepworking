package br.com.deepworking.project.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Project {

    @Id
    @SequenceGenerator(name = "projectSeq", sequenceName = "project_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projectSeq")
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "project", cascade = CascadeType.PERSIST)
    private Set<ActivityType> activityTypes = new HashSet<>();

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

    public Collection<ActivityType> getActivityTypes() {
        return Collections.unmodifiableCollection(activityTypes);
    }

    public void addActivityType(String name, String description) {
        ActivityType activityType = new ActivityType(name);
        activityType.setDescription(description);
        activityType.setProject(this);

        this.activityTypes.add(activityType);
    }

    public Optional<ActivityType> findBy(String name) {
        return activityTypes.stream()
                .filter(a -> a.getName().equals(name))
                .findFirst();
    }

    @Override
    public String toString() {
        return "Project [id=" + id + ", name=" + name + ", activityTypes=" + activityTypes + "]";
    }

}
