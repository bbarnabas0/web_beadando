package hu.unideb.inf.crud.utills;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FacesValidator("customPriceValidator")
public class PriceValidator implements Validator {

    // Csak pozitív egész számok
    private static final String PRICE_PATTERN = "^[1-9][0-9]*$";

    private Pattern pattern;
    private Matcher matcher;

    public PriceValidator() {
        pattern = Pattern.compile(PRICE_PATTERN);
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Validation failed", "Value cannot be null."));
        }

        String input = value.toString().strip(); // Szóközök eltávolítása
        matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Validation failed", "Price must be a positive whole number (e.g., 1000)."));
        }
    }
}
