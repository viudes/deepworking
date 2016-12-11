package br.com.deepworking.project.model.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.deepworking.project.model.Score;

public interface ScoreRepository extends CrudRepository<Score, Integer> {

}
