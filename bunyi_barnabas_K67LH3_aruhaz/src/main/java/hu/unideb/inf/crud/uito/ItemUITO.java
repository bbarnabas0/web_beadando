/**
 * 
 */
package hu.unideb.inf.crud.uito;

import java.io.Serializable;

/**
 * @author s727953
 *
 */
public class ItemUITO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4840260415183676656L;
	private Long itmId;
	private String itmName;
	private String itmCode;
	private Long itmPrice;
	private String emailId;
	private CategoryUITO categoryUITO;

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

	public void setItmPrice(Long price) {
		this.itmPrice = price;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public CategoryUITO getCategoryUITO() {
		return categoryUITO;
	}

	public void setCategoryUITO(CategoryUITO categoryUITO) {
		this.categoryUITO = categoryUITO;
	}

	@Override
	public String toString() {
		return "ItemUITO [itmId=" + itmId + ", itmName=" + itmName + ", itmCode=" + itmCode +", itmPrice="
				+ itmPrice + ", emailId=" + emailId + ", categoryUITO=" + categoryUITO + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itmName == null) ? 0 : itmName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemUITO other = (ItemUITO) obj;
		if (itmName == null) {
			if (other.itmName != null)
				return false;
		} else if (!itmName.equals(other.itmName))
			return false;
		return true;
	}

}
