package csci201_backend.backenddemo.dao;

import csci201_backend.backenddemo.entity.Cart;

import java.util.List;

public interface CartDAO {
    Cart findByID(int theId);

    List<Cart> findAll();

//    List<Cart> findAll_category(String s);

    void deleteById(int theId);

    Cart save(Cart theCart);
}
