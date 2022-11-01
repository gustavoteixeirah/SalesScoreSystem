package dev.gustavoteixeira.model.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BusinessErrors {

    ERROR_VALIDATING_CONSTRAINT("Couldn't validate constraints: ");

    private final String value;

}