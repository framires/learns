package br.com.ramires.learn.functionalities.power.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PowerRequest {

	private Integer id;

	@NotBlank(message = "field name is required")
	private String name;

}
