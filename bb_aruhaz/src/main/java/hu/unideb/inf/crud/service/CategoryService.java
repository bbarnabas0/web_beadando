
package hu.unideb.inf.crud.service;

import java.util.List;

import hu.unideb.inf.crud.uito.CategoryUITO;

public interface CategoryService {

	List<CategoryUITO> getAllCategory();

	CategoryUITO getCategory(CategoryUITO categoryUITO);

}