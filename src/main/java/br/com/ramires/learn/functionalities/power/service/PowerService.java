package br.com.ramires.learn.functionalities.power.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ramires.learn.basics.exceptions.BadRequestException;
import br.com.ramires.learn.functionalities.power.dto.PowerRequest;
import br.com.ramires.learn.functionalities.power.dto.PowerResponse;
import br.com.ramires.learn.functionalities.power.mapper.PowerMapper;
import br.com.ramires.learn.functionalities.power.model.Power;
import br.com.ramires.learn.functionalities.power.repository.PowerRepository;

@Service
public class PowerService {

	@Autowired
	private PowerRepository repository;

	/**
	 * Method save or edit Power
	 * 
	 * @param powerRequest
	 * @return {@link PowerResponse}
	 */
	public PowerResponse merge(PowerRequest powerRequest) {

		// parse Request to Model
		Power power = PowerMapper.INSTANCE.requestToModel(powerRequest);

		if (power.getId() == null) {
			// validate power name exist in database
			if (repository.countByName(power.getName()) > 0) {
				throw new BadRequestException("power_merge_name_registered",
						"Power field already have registered record");
			}
		} else {
			// validate if exist power name with different Id in database
			if (repository.countByNameAndDifferentId(power.getName(), power.getId()) > 0) {
				throw new BadRequestException("power_merge_name_registered",
						"Power field already have registered record");
			}
		}
		// save
		repository.save(power);
		// return dto
		return PowerMapper.INSTANCE.modelToResponse(power);
	}

	/**
	 * Method findAll Power in database
	 * 
	 * @return {@link PowerResponse}
	 */
	public List<PowerResponse> findAll() {
		// find all list power in database
		List<Power> list = (List<Power>) repository.findAll();
		return PowerMapper.INSTANCE.listModelToResponse(list);
	}

	/**
	 * Method find power by Id
	 * 
	 * @param id
	 * @return
	 */
	public PowerResponse findById(Integer id) {
		if (id != null) {
			Optional<Power> power = repository.findById(id);
			if (power.isPresent()) {
				return PowerMapper.INSTANCE.modelToResponse(power.get());
			}
		}
		throw new BadRequestException("power_find_by_id_invalid_id", "Power id not find into database");
	}

	/**
	 * Method delete power by Id
	 * 
	 * @param id
	 */
	public void deleteById(Integer id) {
		if (id != null) {
			Optional<Power> power = repository.findById(id);
			if (power.isPresent()) {
				repository.delete(power.get());
			}
		}
		throw new BadRequestException("power_find_by_id_invalid_id", "Power id not find into database");
	}

	/**
	 * Method find and create a new Power
	 * 
	 * @param powersList
	 * @return
	 */
	public List<Power> findOrCreatePowerList(List<PowerRequest> powersList) {
		// create list return
		List<Power> listPower = new ArrayList<>();

		for (PowerRequest power : powersList) {
			Power p1;
			if (power.getId() != null) {
				// find
				try {
					p1 = repository.findById(power.getId()).get();
				} catch (Exception e) {
					p1 = null;
				}
			} else {
				// create
				try {
					p1 = create(power);
				} catch (Exception e) {
					p1 = null;
				}
			}
			if (p1 != null) {
				listPower.add(p1);
			}
		}
		return listPower;
	}

	// ################
	// ################
	// PRIVATE METHODS
	// ################
	// ################

	/**
	 * Method create new Power
	 * 
	 * @param power
	 * @return
	 */
	private Power create(PowerRequest powerRequest) {
		// parse Request to Model
		Power power = PowerMapper.INSTANCE.requestToModel(powerRequest);

		Power p1 = repository.findByName(power.getName());
		if (p1 == null) {
			repository.save(power);
			return power;
		} else {
			return p1;
		}
	}

}
