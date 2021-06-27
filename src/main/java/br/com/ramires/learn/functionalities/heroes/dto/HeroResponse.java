package br.com.ramires.learn.functionalities.heroes.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.ramires.learn.functionalities.power.dto.PowerResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeroResponse {

    private Integer id;
    private String name;
    private List<PowerResponse> powers = new ArrayList<>();

}
