package br.com.ramires.learn.learns.functionalities.heroes;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.ramires.learn.functionalities.heroes.dto.HeroResponse;
import br.com.ramires.learn.functionalities.heroes.entity.Hero;
import br.com.ramires.learn.functionalities.heroes.repository.HeroRepository;
import br.com.ramires.learn.functionalities.heroes.service.HeroService;

@ExtendWith(MockitoExtension.class)
class HeroesServiceTest {

	private HeroesDataTest heroesData = new HeroesDataTest();

	@Mock
	HeroRepository repository;

	@InjectMocks
	HeroService service;

	@Test
	@DisplayName("find all with powers - success")
	void test_find_all_with_powers() {
		// Mock
		Mockito.when(repository.findAllWithPowers()).thenReturn(heroesData.listHero(10, true));
		// call service
		List<HeroResponse> result = service.findAll(true);
		// Assertions
		Assertions.assertEquals(10, result.size());
		Assertions.assertEquals(true, result.get(0).getPowers().size() > 0);
	}

	@Test
	@DisplayName("find all without powers - success")
	void test_find_all_without_powers() {
		// mock
		Mockito.when(repository.findAllWithPowers()).thenReturn(heroesData.listHero(10, false));
		// call service
		List<HeroResponse> result = service.findAll(false);
		// Assertions
		Assertions.assertEquals(10, result.size());
		Assertions.assertEquals(false, result.get(0).getPowers().size() > 0);
	}

}
