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
public class HeroesServiceTest {

	@Mock
	HeroRepository repository;

	@InjectMocks
	HeroService service;

	@Test
	@DisplayName("Test Example")
	void testSucess() {

		Mockito.when(repository.findAllWithPowers()).thenReturn(new ArrayList<Hero>());

		List<HeroResponse> result = service.findAll(true);

		Assertions.assertEquals(0, result.size());
	}

}
