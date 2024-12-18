package hu.unideb.inf.crud.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.unideb.inf.crud.entity.CategoryDTO;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryDTO, Long> {

	CategoryDTO findTitleByCategName(String categName);
}