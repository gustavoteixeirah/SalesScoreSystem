package dev.gustavoteixeira.model.validation;

public class ConstraintException extends RuntimeException {

    public ConstraintException(BusinessErrors error, String parameters) {
        super(error.getValue() + parameters);
    }

}