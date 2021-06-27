package br.com.ramires.learn.functionalities.heroes.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import br.com.ramires.learn.basics.entity.AuditableEntity;
import br.com.ramires.learn.functionalities.power.model.Power;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "HERO")
public class Hero extends AuditableEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Size(max = 100)
	@Column(name = "NAME")
	private String name;

	@ManyToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinTable(name = "HERO_POWER", joinColumns = { @JoinColumn(name = "HERO_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "POWER_ID") })
	private List<Power> powersList;

}