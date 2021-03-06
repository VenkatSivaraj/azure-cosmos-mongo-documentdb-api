package com.microsoft.cosmos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microsoft.cosmos.model.*;
import com.microsoft.cosmos.service.ItemsService;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class ItemsController {
	
	private ItemsService itemsService;
	
	@Autowired
	public ItemsController(ItemsService itemsService) {
		this.itemsService = itemsService;
	}
	
	@GetMapping("/items/") 
	List<Item> getItems() {
		return itemsService.getAllItems();
	}
	@GetMapping("/items/{id}") 
	Item getItems(@PathVariable(value = "id") Integer id) {
		return itemsService.getItemById(id);
	}
	@PostMapping(path = "/items/", consumes = "application/json")
	void setItems(@RequestBody Item item) {
		itemsService.saveItem(item);
	}
}
