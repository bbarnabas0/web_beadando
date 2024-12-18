/**
 * 
 */
/**
 * @author s727953
 *
 */
package hu.unideb.inf.crud.service.impl;

import java.util.ArrayList;
import java.util.List;

import hu.unideb.inf.crud.repositry.CategoryRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.crud.entity.CategoryDTO;
import hu.unideb.inf.crud.service.CategoryService;
import hu.unideb.inf.crud.uito.CategoryUITO;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public List<CategoryUITO> getAllCategory() {
		List<CategoryUITO> categoryUITOLst = new ArrayList<>();
		List<CategoryDTO> categoryDTOLst = categoryRepo.findAll();

		categoryDTOLst.forEach(dto -> {
			CategoryUITO tmpUiTO = new CategoryUITO();

			BeanUtils.copyProperties(dto, tmpUiTO);
			categoryUITOLst.add(tmpUiTO);
		});

		return categoryUITOLst;
	}

	@Override
	public CategoryUITO getCategory(CategoryUITO categoryUITO) {
		System.out.println(">>>>> "+categoryUITO.getCategName());
		CategoryDTO dto = categoryRepo.findTitleByCategName(categoryUITO.getCategName());
		CategoryUITO uito = new CategoryUITO();

		BeanUtils.copyProperties(dto, uito);
		return uito;
	}
}