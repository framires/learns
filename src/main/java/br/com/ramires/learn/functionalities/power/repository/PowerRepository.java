package br.com.ramires.learn.functionalities.power.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.ramires.learn.functionalities.power.model.Power;

@Repository
public interface PowerRepository extends PagingAndSortingRepository<Power, Integer> {

	Integer countByName(String name);
	
	Power findByName(String name);

	@Query("SELECT COUNT(p) FROM Power as p WHERE p.name =?1 AND p.id <> ?2 ")
	Integer countByNameAndDifferentId(String name, Integer id);
}
