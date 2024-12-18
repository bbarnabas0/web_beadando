
package hu.unideb.inf.crud.service;

import java.util.List;

import hu.unideb.inf.crud.uito.ItemUITO;

public interface ItemService {
	ItemUITO doSaveItm(ItemUITO itemUiTO);

	List<ItemUITO> doFetchAllItm();

	ItemUITO doGetItm(ItemUITO itemUiTO);

	void doDeleteItm(ItemUITO itemUiTO);
}