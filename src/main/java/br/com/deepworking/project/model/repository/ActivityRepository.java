package br.com.deepworking.project.model.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.deepworking.project.model.Activity;

public interface ActivityRepository extends CrudRepository<Activity, Integer> {

}
