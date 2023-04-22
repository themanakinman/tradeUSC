package csci201_backend.backenddemo.dao;

import csci201_backend.backenddemo.entity.Item;

import java.util.List;

public interface ItemDAO {
    Item findByID(int theId);

    List<Item> findAll();

    List<Item> findAll_category(String s);

    void deleteById(int theId);

    Item save(Item thePost);
}