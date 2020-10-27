package br.com.ramires.learn.functionalities.power.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.ramires.learn.functionalities.power.model.Power;

@Repository
public interface PowerRepository extends PagingAndSortingRepository<Power, Integer> {
}
