package br.com.ramires.learn.functionalities.heroes.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ramires.learn.basics.exceptions.BadRequestException;
import br.com.ramires.learn.functionalities.heroes.dto.HeroRequest;
import br.com.ramires.learn.functionalities.heroes.dto.HeroResponse;
import br.com.ramires.learn.functionalities.heroes.entity.Hero;
import br.com.ramires.learn.functionalities.heroes.mapper.HeroMapper;
import br.com.ramires.learn.functionalities.heroes.repository.HeroRepository;
import br.com.ramires.learn.functionalities.power.service.PowerService;

@Service
public class HeroService {

	@Autowired
	private HeroRepository repository;

	@Autowired
	private PowerService powerService;

	/**
	 * Method find all Heroes
	 * 
	 * @return {@link HeroResponse}
	 */
	@Transactional(readOnly = true)
	public List<HeroResponse> findAll(boolean powerlist) {
		// find all list Hero in database
		if (!powerlist) {
			List<Hero> list = (List<Hero>) repository.findAll();
			return HeroMapper.INSTANCE.listModelToResponse(list);
		} else {
			List<Hero> list = repository.findAllWithPowers();
			return HeroMapper.INSTANCE.listModelToResponseFull(list);
		}
	}

	/**
	 * Method find Hero by ID
	 * 
	 * @param id
	 * @return
	 */
	public HeroResponse findById(Integer id) {
		if (id != null) {
			Optional<Hero> hero = repository.findById(id);
			if (hero.isPresent()) {
				return HeroMapper.INSTANCE.modelToResponse(hero.get());
			}
		}
		throw new BadRequestException("hero_find_by_id_invalid_id", "Hero id not find into database");
	}

	/**
	 * Method delete Hero
	 * 
	 * @param id
	 */
	public void deleteById(Integer id) {
		if (id != null) {
			Optional<Hero> hero = repository.findById(id);
			if (hero.isPresent()) {
				repository.delete(hero.get());
			}
		}
		throw new BadRequestException("hero_find_by_id_invalid_id", "Hero id not find into database");
	}

	/**
	 * Method save/edit Hero
	 * 
	 * @param heroRequest
	 * @return
	 */
	public HeroResponse merge(@Valid HeroRequest heroRequest) {
		// parse Request to Model
		Hero hero = HeroMapper.INSTANCE.requestToModel(heroRequest);

		if (hero.getId() == null) {
			// validate hero name exist in database
			if (repository.countByName(hero.getName()) > 0) {
				throw new BadRequestException("hero_merge_name_registered",
						"Hero field already have registered record");
			}
		} else {
			// validate if exist hero name with different Id in database
			if (repository.countByNameAndDifferentId(hero.getName(), hero.getId()) > 0) {
				throw new BadRequestException("hero_merge_name_registered",
						"Hero field already have registered record");
			}
		}
		// valid listPower
		hero.setPowersList(powerService.findOrCreatePowerList(heroRequest.getPowers()));
		// save
		repository.save(hero);
		// return dto
		return HeroMapper.INSTANCE.modelToResponseFull(hero);
	}

}
