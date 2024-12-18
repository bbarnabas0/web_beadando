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

import hu.unideb.inf.crud.repositry.ItemRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.crud.entity.CategoryDTO;
import hu.unideb.inf.crud.entity.ItemDTO;
import hu.unideb.inf.crud.service.ItemService;
import hu.unideb.inf.crud.uito.CategoryUITO;
import hu.unideb.inf.crud.uito.ItemUITO;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepo itemRepo;

    @Override
    @Transactional(readOnly = false)
    public ItemUITO doSaveItm(ItemUITO itemUiTO) {
        ItemDTO dto = UiToToDto(itemUiTO);
        dto = itemRepo.save(dto);
        BeanUtils.copyProperties(dto, itemUiTO);

        dtoToUito(itemUiTO, dto);
        return itemUiTO;
    }

    private void dtoToUito(ItemUITO itemUiTO, ItemDTO dto) {
        CategoryUITO uitTO = new CategoryUITO();
        BeanUtils.copyProperties(dto.getCategoryDTO(), uitTO);
        itemUiTO.setCategoryUITO(uitTO);
    }

    private ItemDTO UiToToDto(ItemUITO itemUiTO) {
       ItemDTO dto = new ItemDTO();
        CategoryDTO categDto = new CategoryDTO();
        BeanUtils.copyProperties(itemUiTO, dto);
        BeanUtils.copyProperties(itemUiTO.getCategoryUITO(), categDto);
        dto.setCategoryDTO(categDto);
        List<ItemDTO> lst = new ArrayList<>();
        lst.add(dto);
        categDto.getItemdtolst().addAll(lst);
        return dto;
    }

    @Override
    public List<ItemUITO> doFetchAllItm() {
        List<ItemDTO> dtoLst = itemRepo.findAll();
        List<ItemUITO> uiTOLst = new ArrayList<>();
        dtoLst.forEach(dto -> {
            ItemUITO tmpUiTO = new ItemUITO();
            System.out.println(dto.getCategoryDTO());
            BeanUtils.copyProperties(dto, tmpUiTO);

            dtoToUito(tmpUiTO, dto);
            uiTOLst.add(tmpUiTO);
        });
        return uiTOLst;
    }

    @Override
    public ItemUITO doGetItm(ItemUITO itemUiTO) {
        if (null != itemUiTO.getEmailId()) {
            ItemDTO dto = new ItemDTO();

            BeanUtils.copyProperties(itemUiTO, dto);
            dto = itemRepo.getOne(dto.getItmId());

            BeanUtils.copyProperties(dto, itemUiTO);
        }
        return itemUiTO;
    }

    @Override
    @Transactional
    public void doDeleteItm(ItemUITO itemUiTO) {

        itemRepo.deleteById(itemUiTO.getItmId());
    }

}