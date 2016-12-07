package br.com.deepworking.project.model.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.deepworking.project.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer> {

    Project findById(Integer projectId);

}
