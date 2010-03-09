package rnd.validation;

public abstract class AbstractValidation implements Validation {

	private String validationMessage;

	public AbstractValidation(String validationMessage) {
		this.validationMessage = validationMessage;
	}

	public abstract boolean isValid(Object object);

	@Override
	public String getValidationMessage() {
		return this.validationMessage;
	}

}
