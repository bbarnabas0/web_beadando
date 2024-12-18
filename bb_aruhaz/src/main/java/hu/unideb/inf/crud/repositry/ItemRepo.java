package hu.unideb.inf.crud.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.unideb.inf.crud.entity.ItemDTO;

@Repository
public interface ItemRepo extends JpaRepository<ItemDTO, Long> {
}