package br.com.deepworking.project.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.deepworking.project.model.Activity;
import br.com.deepworking.project.model.Project;

public interface ActivityRepository extends CrudRepository<Activity, Integer> {

    public List<Activity> findByProjectOrderByStartTimeAsc(Project project);

}
