package com.perfectmatch.web.controller.mapper;

import org.mapstruct.Mapper;

import com.perfectmatch.persistence.model.Artist;
import com.perfectmatch.web.controller.dto.ArtistDTO;

@Mapper(componentModel = "spring")
public interface ArtistMapper {
	
	Artist dtoToModel(ArtistDTO artistDTO);
	ArtistDTO modelToDto(Artist artist);
}
