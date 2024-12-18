package hu.unideb.inf.crud.utills;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;

import hu.unideb.inf.crud.service.CategoryService;
import hu.unideb.inf.crud.uito.CategoryUITO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategConverter implements Converter {

	@Autowired
	private CategoryService categoryService;

	private static final Logger LOG = LoggerFactory.getLogger(CategConverter.class.getName());

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		LOG.info("getAsObject: " + categoryService);

		CategoryUITO categoryUITO = new CategoryUITO();
		categoryUITO.setCategName(string);
		categoryUITO = categoryService.getCategory(categoryUITO);
		System.out.println(categoryUITO.toString());
		return categoryUITO;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
		LOG.info("getAsString obj class: " + obj.getClass().getName());
		if (obj instanceof CategoryUITO) {
			CategoryUITO categ = (CategoryUITO) obj;
			LOG.info("getAsString def name: " + categ.getCategName());
			return categ.getCategName();
		} else {
			StringBuilder sbError = new StringBuilder("The object of class ");
			sbError.append(obj.getClass().getName()).append(" is not of CategoryUITO");
			throw new ClassCastException(sbError.toString());
		}
	}
}