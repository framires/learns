package br.com.ramires.learn.learns.functionalities.power;

import java.util.ArrayList;
import java.util.List;

import br.com.ramires.learn.functionalities.heroes.entity.Hero;
import br.com.ramires.learn.functionalities.power.model.Power;

public class PowerDataTest {

	/**
	 * List Power
	 * 
	 * @param size (quantity list size)
	 * @return
	 */
	public List<Power> listPower(int size) {
		List<Power> listPower = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			listPower.add(createPower(i));
		}
		return listPower;
	}

	/**
	 * Create Power
	 * 
	 * @param id
	 * @return
	 */
	private Power createPower(int id) {
		Power power = new Power();
		power.setId(id);
		power.setName("power_" + id);
		return power;
	}
}
