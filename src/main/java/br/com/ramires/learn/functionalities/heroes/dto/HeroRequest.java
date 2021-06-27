package br.com.ramires.learn.functionalities.heroes.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import br.com.ramires.learn.functionalities.power.dto.PowerRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeroRequest {

    private Integer id;
    
    @NotBlank(message = "field name is required")
    private String name;
    
    private List<PowerRequest> powers = new ArrayList<>();
}
