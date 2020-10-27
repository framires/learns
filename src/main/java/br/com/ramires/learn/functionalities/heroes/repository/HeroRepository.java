package br.com.ramires.learn.functionalities.heroes.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.ramires.learn.functionalities.heroes.entity.Hero;

@Repository
public interface HeroRepository extends PagingAndSortingRepository<Hero, Integer> {
}