package br.com.ramires.learn.functionalities.power.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.ramires.learn.functionalities.power.dto.PowerRequest;
import br.com.ramires.learn.functionalities.power.dto.PowerResponse;
import br.com.ramires.learn.functionalities.power.model.Power;

@Mapper
public interface PowerMapper {

	PowerMapper INSTANCE = Mappers.getMapper(PowerMapper.class);

	// convert Request to Model
	Power requestToModel(PowerRequest request);

	// convert Model to Response
	PowerResponse modelToResponse(Power response);

	// covert ListModel to listResponse
	List<PowerResponse> listModelToResponse(List<Power> list);
}
