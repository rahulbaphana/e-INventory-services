package com.hive.keeper;

import com.hive.keeper.entity.InventoryItem;
import com.hive.keeper.exception.InventoryException;
import com.hive.keeper.unit.Units;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private Inventory inventory = new Inventory();

	@RequestMapping("/")
    public String index() {
        return "Hello e-INventory!";
    }
	
	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	public ResponseEntity<InventoryItem> addItem(@RequestBody InventoryItem inventoryItem) throws InventoryException {
		InventoryItem item = new InventoryItem(inventoryItem.getName(), inventoryItem.getDescription(), inventoryItem.getQuantity(), Units.NONE);
		inventory.addItem(item);
		return new ResponseEntity<InventoryItem>(item, HttpStatus.OK);
	}
}
