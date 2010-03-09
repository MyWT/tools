package rnd.validation;

public interface Validation {

	boolean isValid(Object object);

	String getValidationMessage();

}