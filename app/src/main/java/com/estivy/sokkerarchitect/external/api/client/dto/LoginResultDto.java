package com.estivy.sokkerarchitect.external.api.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class LoginResultDto {
    String teamId;
    String xmlSession;
}
