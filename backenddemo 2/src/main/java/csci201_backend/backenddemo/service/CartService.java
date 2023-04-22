package csci201_backend.backenddemo.service;

import csci201_backend.backenddemo.entity.Cart;

import java.util.List;

public interface CartService {
    Cart findByID(int theId);
    List<Cart> findAll();
    void deleteById(int theId);
    Cart save(Cart theCart);
}