package br.com.ramires.learn.functionalities.power.resource;

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
import br.com.ramires.learn.functionalities.power.dto.PowerRequest;
import br.com.ramires.learn.functionalities.power.dto.PowerResponse;
import br.com.ramires.learn.functionalities.power.service.PowerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "POWER")
@RestController
public class PowerResource {

	@Autowired
	private PowerService service;

	// base URL
	private static final String BASE_URI_V1 = "/api/v1/power";

	/**
	 * Method find all powers and return list<Powers>
	 * 
	 * @return {@link PowerResponse}
	 * @author feliperamires
	 * @date Out,26 2020
	 */
	@ApiOperation(value = "Request the All Powers")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Find all Power sucess"),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponseDTO.class) })
	@GetMapping(path = BASE_URI_V1 + "/findAll")
	public ResponseEntity<List<PowerResponse>> getAllPowers() {
		// find all
		List<PowerResponse> listPowers = service.findAll();
		return new ResponseEntity<>(listPowers, HttpStatus.OK);
	}

	/**
	 * Method find all powers and return list<Powers>
	 * 
	 * @return {@link PowerResponse}
	 * @author feliperamires
	 * @date Out,26 2020
	 */
	@ApiOperation(value = "Request the All Powers")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Find all Power sucess"),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponseDTO.class) })
	@GetMapping(path = BASE_URI_V1 + "/find")
	public ResponseEntity<PowerResponse> getPowerById(@RequestParam("id") Integer id) {
		// find by Id
		PowerResponse power = service.findById(id);
		return new ResponseEntity<>(power, HttpStatus.OK);
	}

	/**
	 * Method find all powers and return list<Powers>
	 * 
	 * @return {@link PowerResponse}
	 * @author feliperamires
	 * @date Out,26 2020
	 */
	@ApiOperation(value = "Request the All Powers")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Delete Power by ID sucess"),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponseDTO.class) })
	@DeleteMapping(path = BASE_URI_V1)
	public ResponseEntity<String> deleteById(@RequestParam("id") Integer id) {
		// remove by Id
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Method save or edit Power
	 * 
	 * @return {@link PowerResponse}
	 * @author feliperamires
	 * @date Out,26 2020
	 */
	@ApiOperation(value = "Request the All Powers")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Power created/updated sucess"),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponseDTO.class),
			@ApiResponse(code = 400, message = "BadRequest", response = ErrorResponseDTO.class) })
	@PostMapping(path = BASE_URI_V1 + "/merge")
	public ResponseEntity<PowerResponse> mergePowers(@Valid @RequestBody PowerRequest powerRequest) {
		// merge power
		PowerResponse powerResponse = service.merge(powerRequest);
		return new ResponseEntity<>(powerResponse, HttpStatus.CREATED);
	}

}
