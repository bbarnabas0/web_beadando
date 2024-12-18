package hu.unideb.inf.crud.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CATEGORY_MASTER")
public class CategoryDTO implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CATEG_ID")
    private Long categId;
    @Column(name = "Categ_Name")
    private String categName;

    @OneToMany(mappedBy = "categoryDTO")
    private List<ItemDTO> itemdtolst;

    public Long getCategId() {
        return categId;
    }

    public void setCategId(Long categId) {
        this.categId = categId;
    }

    public String getCategName() {
        return categName;
    }

    public void setCategName(String categName) {
        this.categName = categName;
    }

    public List<ItemDTO> getItemdtolst() {
        if (null == itemdtolst) {
            itemdtolst = new ArrayList<>();
        }
        return itemdtolst;
    }

    public void setItemdtolst(List<ItemDTO> itemdtolst) {
        this.itemdtolst = itemdtolst;
    }
}
