package com.estivy.sokkerarchitect.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Country {

    private Integer countryId;

    private String name;

    private String currencyName;

    private Double currencyRate;
}
