package br.com.ramires.learn.functionalities.heroes.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ramires.learn.basics.exceptions.ErrorResponseDTO;
import br.com.ramires.learn.functionalities.heroes.dto.HeroResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "HERO")
@RestController
public class HeroResource {

    private static final String BASE_URI_V1 = "/api/v1/hero";

    /**
     * Method find all heroes and return
     * 
     * @return {@link HeroResponse}
     * @author feliperamires
     * @date Out,26 2020
     */
    @ApiOperation(value = "Request the All Heroes")
    @ApiResponses(value = { 
	    	@ApiResponse(code = 200, message = "Find all Heroes sucess"),
	    	@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponseDTO.class) })
    @GetMapping(path = BASE_URI_V1 + "/findAll")
    public ResponseEntity<List<HeroResponse>> getHeroes() {

	List<HeroResponse> heroes = new ArrayList<>();

	return new ResponseEntity<>(heroes, HttpStatus.OK);
    }

}
