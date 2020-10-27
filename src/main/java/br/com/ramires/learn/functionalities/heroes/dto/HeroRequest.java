package br.com.ramires.learn.functionalities.heroes.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.ramires.learn.functionalities.power.dto.PowerRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeroRequest {

    private Integer id;
    private Integer name;
    private List<PowerRequest> powers = new ArrayList<>();
}
