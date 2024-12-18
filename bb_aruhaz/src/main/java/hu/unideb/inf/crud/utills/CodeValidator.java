package hu.unideb.inf.crud.utills;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FacesValidator("customCodeValidator")
public class CodeValidator implements Validator {

    private static final String NUMERIC_PATTERN = "^[0-9]{8}$";

    private Pattern pattern;
    private Matcher matcher;

    public CodeValidator() {
        pattern = Pattern.compile(NUMERIC_PATTERN);
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Validation failed", "Value cannot be null."));
        }

        String input = value.toString().strip();
        matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Validation failed", "Code must be exactly 8 digits."));
        }
    }
}
