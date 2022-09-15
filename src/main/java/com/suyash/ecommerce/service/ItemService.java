package com.suyash.ecommerce.service;

import com.suyash.ecommerce.model.Item;
import com.suyash.ecommerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    // return product
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // add product
    public void addItem(Item item) {
        itemRepository.save(item);
    }

    // remove product
    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }

    // find item by id
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    // get all item by category
    public List<Item> getAllItemsByCategory(Long id) {
        return itemRepository.findAllByCategoryId(id);
    }
}
