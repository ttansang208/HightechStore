package base.validators;

import base.entities.*;
import org.springframework.validation.*;

public class AccountValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Account.class.equals(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {
		//...............
	}

	
	
}
