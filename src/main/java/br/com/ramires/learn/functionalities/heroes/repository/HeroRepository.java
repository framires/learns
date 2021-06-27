package br.com.ramires.learn.functionalities.heroes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.ramires.learn.functionalities.heroes.entity.Hero;

@Repository
public interface HeroRepository extends PagingAndSortingRepository<Hero, Integer> {

	Integer countByName(String name);

	@Query("SELECT COUNT(h) FROM Hero as h WHERE h.name =?1 AND h.id <> ?2 ")
	Integer countByNameAndDifferentId(String name, Integer id);

	@Query("SELECT DISTINCT h FROM Hero as h LEFT JOIN h.powersList")
	List<Hero> findAllWithPowers();
}