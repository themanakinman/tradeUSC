package csci201_backend.backenddemo.dao;

import csci201_backend.backenddemo.entity.User;

import java.util.List;

public interface UserDAO {
    User findByID(int theID);
    User save(User theUser);
    List<User> findAll();



}
