package br.com.deepworking.project.model;

import org.springframework.data.repository.CrudRepository;

public interface ProjectFolder extends CrudRepository<Project, Integer> {

    Project findById(Integer projectId);

}
