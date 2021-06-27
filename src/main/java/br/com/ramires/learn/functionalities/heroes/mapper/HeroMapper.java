package br.com.ramires.learn.functionalities.heroes.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import br.com.ramires.learn.functionalities.heroes.dto.HeroRequest;
import br.com.ramires.learn.functionalities.heroes.dto.HeroResponse;
import br.com.ramires.learn.functionalities.heroes.entity.Hero;
import br.com.ramires.learn.functionalities.power.mapper.PowerMapper;

@Mapper(uses = { PowerMapper.class })
public interface HeroMapper {

	HeroMapper INSTANCE = Mappers.getMapper(HeroMapper.class);

	// convert Request to Model
	@Mapping(source = "powers", target = "powersList")
	Hero requestToModel(HeroRequest request);

	// convert Model to Response
	@Mapping(target = "powers", ignore = true)
	@Named("modelToDTO")
	HeroResponse modelToResponse(Hero response);

	// covert ListModel to listResponse
	@IterableMapping(qualifiedByName = "modelToDTO")
	List<HeroResponse> listModelToResponse(List<Hero> list);

	// convert Model to Response with parents object
	@Mapping(source = "powersList", target = "powers")
	@Named("modelToDTOFull")
	HeroResponse modelToResponseFull(Hero response);

	// covert ListModel to listResponse with parents object
	@IterableMapping(qualifiedByName = "modelToDTOFull")
	List<HeroResponse> listModelToResponseFull(List<Hero> list);
}
