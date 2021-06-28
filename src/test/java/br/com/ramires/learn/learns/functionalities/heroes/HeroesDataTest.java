package br.com.ramires.learn.learns.functionalities.heroes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.ramires.learn.functionalities.heroes.entity.Hero;
import br.com.ramires.learn.learns.functionalities.power.PowerDataTest;

public class HeroesDataTest {

	private PowerDataTest powerData = new PowerDataTest();

	/**
	 * List Hero
	 * 
	 * @param size      (quantity list size)
	 * @param withPower (boolean for create Power)
	 * @return
	 */
	public List<Hero> listHero(int size, boolean withPower) {
		List<Hero> listHero = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			listHero.add(createHero(i, withPower));
		}
		return listHero;
	}

	/**
	 * Create Hero
	 * 
	 * @param id
	 * @return
	 */
	private Hero createHero(int id, boolean power) {
		Hero hero = new Hero();
		hero.setId(id);
		hero.setName("hero_" + id);
		if (power) {
			hero.setPowersList(powerData.listPower(random()));
		}
		return hero;
	}

	private int random() {
		Random r = new Random();
		int low = 1;
		int high = 3;
		return r.nextInt(high - low) + low;
	}

}
