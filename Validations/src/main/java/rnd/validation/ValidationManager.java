package rnd.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationManager {

	public static ValidationResult isValid(Object object) {

		List<Validation> validations = new ArrayList<Validation>();
		
		// TODO get validaion list from OMD
		// TODO support Resourse bundle in Validaion Message

		for (Validation validation : validations) {
			if (!validation.isValid(object)) {
				return new ValidationResult(false, validation.getValidationMessage());
			}
		}

		return new ValidationResult(true, null);

	}

}
