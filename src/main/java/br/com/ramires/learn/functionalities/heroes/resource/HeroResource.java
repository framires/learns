package br.com.ramires.learn.functionalities.heroes.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ramires.learn.basics.exceptions.ErrorResponseDTO;
import br.com.ramires.learn.functionalities.heroes.dto.HeroRequest;
import br.com.ramires.learn.functionalities.heroes.dto.HeroResponse;
import br.com.ramires.learn.functionalities.heroes.service.HeroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "HERO")
@RestController
public class HeroResource {

	private static final String BASE_URI_V1 = "/api/v1/hero";

	@Autowired
	private HeroService service;

	/**
	 * Method find all Hero and return list<Heroes>
	 * 
	 * @return {@link HeroResponse}
	 * @author feliperamires
	 * @date Out,26 2020
	 */
	@ApiOperation(value = "Request the All Heroes")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Find all Heroes sucess"),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponseDTO.class) })
	@GetMapping(path = BASE_URI_V1 + "/findAll")
	public ResponseEntity<List<HeroResponse>> getAllHeroes(
			@RequestParam(value = "power", required = false, defaultValue = "false") Boolean powerList) {
		// find all
		List<HeroResponse> listHeroes = service.findAll(powerList);
		return new ResponseEntity<>(listHeroes, HttpStatus.OK);
	}

	/**
	 * Method find all Heroes and return list<Heroes>
	 * 
	 * @return {@link HeroResponse}
	 * @author feliperamires
	 * @date Out,26 2020
	 */
	@ApiOperation(value = "Request the All Heroes")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Find Hero by ID sucess"),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponseDTO.class) })
	@GetMapping(path = BASE_URI_V1 + "/find")
	public ResponseEntity<HeroResponse> getHeroById(@RequestParam("id") Integer id) {
		// find by Id
		HeroResponse hero = service.findById(id);
		return new ResponseEntity<>(hero, HttpStatus.OK);
	}

	/**
	 * Method find all Heroes and return list<Heroes>
	 * 
	 * @return {@link HeroResponse}
	 * @author feliperamires
	 * @date Out,26 2020
	 */
	@ApiOperation(value = "Request the All Heroes")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Delete Hero by ID sucess"),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponseDTO.class) })
	@DeleteMapping(path = BASE_URI_V1)
	public ResponseEntity<String> deleteById(@RequestParam("id") Integer id) {
		// remove by Id
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Method save or edit Hero
	 * 
	 * @return {@link HeroResponse}
	 * @author feliperamires
	 * @date Out,26 2020
	 */
	@ApiOperation(value = "Request the All Heroes")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Hero created/updated sucess"),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponseDTO.class),
			@ApiResponse(code = 400, message = "BadRequest", response = ErrorResponseDTO.class) })
	@PostMapping(path = BASE_URI_V1 + "/merge")
	public ResponseEntity<HeroResponse> mergeHeroes(@Valid @RequestBody HeroRequest heroRequest) {
		// merge Hero
		HeroResponse heroResponse = service.merge(heroRequest);
		return new ResponseEntity<>(heroResponse, HttpStatus.CREATED);
	}

}
