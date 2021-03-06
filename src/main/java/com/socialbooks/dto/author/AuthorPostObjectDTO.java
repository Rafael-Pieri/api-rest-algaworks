package com.socialbooks.dto.author;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
public class AuthorPostObjectDTO {

    @NotEmpty(message = "The field name is required.")
    private String name;

    @NotNull(message = "The field nationality is required.")
    private String nationality;

    @JsonCreator
    public AuthorPostObjectDTO(@JsonProperty("name") final String name,
                               @JsonProperty("nationality") final String nationality) {
        this.name = name;
        this.nationality = nationality;
    }
}