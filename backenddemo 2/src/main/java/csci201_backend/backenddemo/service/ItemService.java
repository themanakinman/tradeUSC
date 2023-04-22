package csci201_backend.backenddemo.service;

import csci201_backend.backenddemo.entity.Item;

import java.util.List;

public interface ItemService {
    Item findByID(int theId);

    List<Item> findAll();

    List<Item> findAll_category(String s);

    void deleteById(int theId);
    Item save(Item theItem);
}
