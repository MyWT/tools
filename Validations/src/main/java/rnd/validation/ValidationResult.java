package rnd.validation;

public class ValidationResult {

	private boolean valid;
	private String validationMessage;

	public ValidationResult(boolean valid, String validationMessage) {
		this.valid = valid;
		this.validationMessage = validationMessage;
	}

	public boolean isValid() {
		return valid;
	}

	public String getValidationMessage() {
		return validationMessage;
	}
}
