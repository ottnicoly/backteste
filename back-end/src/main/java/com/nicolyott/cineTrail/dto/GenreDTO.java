package com.nicolyott.cineTrail.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GenreDTO(
        @JsonAlias("id") Integer id,
        @JsonAlias("name") String name
) {
}
