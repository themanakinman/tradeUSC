package csci201_backend.backenddemo.service;


import csci201_backend.backenddemo.entity.User;

import java.util.List;

public interface UserService {
    User findByID(int theId);
    User save(User theUser);
    List<User> findAll();

}
