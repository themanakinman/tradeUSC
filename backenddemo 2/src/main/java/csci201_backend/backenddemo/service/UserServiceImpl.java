package csci201_backend.backenddemo.service;

import csci201_backend.backenddemo.dao.UserDAO;
import csci201_backend.backenddemo.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO theUserDAO){ userDAO = theUserDAO;}

    @Override
    public User findByID(int theId){
        return userDAO.findByID(theId);
    }
    @Override
    public List<User> findAll(){
        return userDAO.findAll();
    }

    @Override
    @Transactional
    public User save(User theUser){
        return userDAO.save(theUser);
    }



}
