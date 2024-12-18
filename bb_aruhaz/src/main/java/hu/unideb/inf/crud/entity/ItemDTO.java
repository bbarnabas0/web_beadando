/**
 *
 */
package hu.unideb.inf.crud.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.NamedQuery;

import java.io.Serializable;

/**
 * @author s727953
 *
 */

@Entity
@Table(name = "ITM_INFO")
@NamedQuery(name = "ItemDTO.findAll", query = "SELECT a FROM ItemDTO a")
public class ItemDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itmId;

    @Column(name = "ITM_NAME", nullable = false)
    private String itmName;

    @Column(name = "ITM_CODE", nullable = false, unique = true)
    private String itmCode;

    @Column(name = "ITM_PRICE", nullable = false)
    private Long itmPrice;

    @Column(name = "EMAIL_ID")
    private String emailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEG_ID")
    private CategoryDTO categoryDTO;

    public Long getItmId() {
        return itmId;
    }

    public void setItmId(Long itmId) {
        this.itmId = itmId;
    }

    public String getItmName() {
        return itmName;
    }

    public void setItmName(String itmName) {
        this.itmName = itmName;
    }

    public String getItmCode() {
        return itmCode;
    }

    public void setItmCode(String itmCode) {
        this.itmCode = itmCode;
    }

    public Long getItmPrice() {
        return itmPrice;
    }

    public void setItmPrice(Long itmPrice) {
        this.itmPrice = itmPrice;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public CategoryDTO getCategoryDTO() {

        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

}
