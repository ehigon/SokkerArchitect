package com.estivy.sokkerarchitect.storage.service;

import com.estivy.sokkerarchitect.core.domain.Country;
import com.estivy.sokkerarchitect.storage.entities.CountryEntity;
import com.estivy.sokkerarchitect.storage.mapper.CountryEntityMapper;
import com.estivy.sokkerarchitect.storage.repositories.CountryRepository;

import java.util.List;

import javax.inject.Inject;

public class CountryStorageService {

    private final CountryRepository countryRepository;

    private final CountryEntityMapper countryEntityMapper;

    @Inject
    public CountryStorageService(CountryRepository countryRepository,
                                 CountryEntityMapper countryEntityMapper) {
        this.countryRepository = countryRepository;
        this.countryEntityMapper = countryEntityMapper;
    }

    public void saveCountries(List<Country> countries){
        countryRepository.save(countryEntityMapper.mapToEntity(countries));
    }
}
