package com.estivy.sokkerarchitect.storage.entities;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor(onConstructor_=@__({@Ignore}))
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity(tableName = "countries")
public class CountryEntity {

    @PrimaryKey
    private Integer countryId;

    private String name;

    private String currencyName;

    private Double currencyRate;
}
