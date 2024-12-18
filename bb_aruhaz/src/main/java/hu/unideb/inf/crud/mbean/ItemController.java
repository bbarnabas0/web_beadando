/**
 * @author s727953
 */
/**
 * @author s727953
 *
 */
package hu.unideb.inf.crud.mbean;

import hu.unideb.inf.crud.service.CategoryService;
import hu.unideb.inf.crud.service.ItemService;
import hu.unideb.inf.crud.uito.CategoryUITO;
import hu.unideb.inf.crud.uito.ItemUITO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Controller("itmlController")
@SessionScope
public class ItemController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private CategoryService categoryService;

    private String actionLabel;
    private ItemUITO itmUiTO;
    private List<ItemUITO> itmUiToList;

    private List<CategoryUITO> categoryUiToList;

    /**
     * add or update new Record in DB
     *
     * @return
     */
    public void doSaveInfoItml() {
        System.out.println(this.getItmUiTO());
        itemService.doSaveItm(this.getItmUiTO());
        getAllItml();
        this.setItmUiTO(new ItemUITO());
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Details", "Item Details added/Updated Successfully.");

        //PrimeFaces.current().dialog().showMessageDynamic(message);
        //RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,
        //		"Item Details", "Item Details added/Updated Successfully."));

    }

    /**
     * Default load all the Item info
     */
    @PostConstruct
    public void getAllItml() {
        if (!this.getItmUiToList().isEmpty()) {
            this.getItmUiToList().clear();
            this.getCategoryUiToList().clear();
        }
        System.out.println(" >>>>>>>>>>>>> " + itemService);
        this.getItmUiToList().addAll(itemService.doFetchAllItm());
        this.getCategoryUiToList().addAll(categoryService.getAllCategory());
        this.setActionLabel("Add");
    }

    /**
     * Remove selected Item info
     *
     * @return
     */

    public void deleteItem(ItemUITO itemUiTO) {
        itemService.doDeleteItm(itemUiTO);
        getAllItml();
    }

    public void editItem(ItemUITO ItemUiTO) {
        this.setActionLabel("Update");
        BeanUtils.copyProperties(ItemUiTO, this.getItmUiTO());
        System.out.println(this.getItmUiTO());
    }

    public ItemUITO getItmUiTO() {
        if (itmUiTO == null) {
            itmUiTO = new ItemUITO();
        }
        return itmUiTO;
    }

    public void setItmUiTO(ItemUITO itmUiTO) {
        this.itmUiTO = itmUiTO;
    }

    public List<ItemUITO> getItmUiToList() {
        if (null == itmUiToList) {
            itmUiToList = new ArrayList<>();
        }
        return itmUiToList;
    }

    public String getActionLabel() {
        return actionLabel;
    }

    public void setActionLabel(String actionLabel) {
        this.actionLabel = actionLabel;
    }

    public List<CategoryUITO> getCategoryUiToList() {
        if (categoryUiToList == null) {
            categoryUiToList = new ArrayList<>();
        }
        return categoryUiToList;
    }

    public void setCategoryUiToList(List<CategoryUITO> categoryUiToList) {
        this.categoryUiToList = categoryUiToList;
    }
}