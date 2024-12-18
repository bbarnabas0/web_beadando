package hu.unideb.inf.crud.uito;

import java.io.Serializable;
import java.util.List;

public class CategoryUITO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long categId;
	private String categName;

	private List<ItemUITO> itemUITOLst;

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

	public List<ItemUITO> getItemUITOLst() {
		return itemUITOLst;
	}

	public void setItemUITOLst(List<ItemUITO> itemUITOLst) {
		this.itemUITOLst = itemUITOLst;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categId == null) ? 0 : categId.hashCode());
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
		CategoryUITO other = (CategoryUITO) obj;
		if (categId == null) {
			if (other.categId != null)
				return false;
		} else if (!categId.equals(other.categId))
			return false;
		return true;
	}

}
