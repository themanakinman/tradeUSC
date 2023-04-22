package csci201_backend.backenddemo.dao;

import csci201_backend.backenddemo.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOJpaImpl implements UserDAO{
    private EntityManager entityManager;


    @Autowired
    public UserDAOJpaImpl(EntityManager theEntityManager) {entityManager = theEntityManager;}

    @Override
    public User findByID(int theId){
        User theUser = entityManager.find(User.class,theId);
        return theUser;
    }

    @Override
    public User save(User theUser){
        User dbUser = entityManager.merge(theUser);
        return dbUser;
    }

    @Override
    public List<User> findAll(){
        TypedQuery<User> theQuery = entityManager.createQuery("from User", User.class);

        // execute query and get result list
        List<User> Users = theQuery.getResultList();

        // return the results
        return Users;
    }









}
