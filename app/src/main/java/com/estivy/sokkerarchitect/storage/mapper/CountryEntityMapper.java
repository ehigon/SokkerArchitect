package com.estivy.sokkerarchitect.storage.mapper;

import com.estivy.sokkerarchitect.core.domain.Country;
import com.estivy.sokkerarchitect.storage.entities.CountryEntity;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CountryEntityMapper {

    CountryEntityMapper INSTANCE =  Mappers.getMapper(CountryEntityMapper.class);

    List<CountryEntity> mapToEntity(List<Country> countries);

    CountryEntity mapToEntity(Country country);

}
