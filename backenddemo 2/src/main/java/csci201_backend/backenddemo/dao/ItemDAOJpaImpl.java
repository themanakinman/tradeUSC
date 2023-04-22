package csci201_backend.backenddemo.dao;
import csci201_backend.backenddemo.entity.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ItemDAOJpaImpl implements ItemDAO {
    private EntityManager entityManager;
    @Autowired
    public ItemDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Item> findAll() {
        TypedQuery<Item> theQuery = entityManager.createQuery("from Item", Item.class);
        List<Item> items = theQuery.getResultList();
        return items;
    }

    @Override
    public List<Item> findAll_category(String s) {
        TypedQuery<Item> theQuery = entityManager.createQuery(
                "SELECT item FROM Item item WHERE item.category= :category", Item.class);
        theQuery.setParameter("category", s);
        List<Item> items = theQuery.getResultList();
        return items;
    }


    @Override
    public Item findByID(int theId) {
        Item theItem = entityManager.find(Item.class, theId);
        return theItem;
    }




    @Override
    public Item save(Item theItem){
        Item dbItem = entityManager.merge(theItem);
        return dbItem;
    }

    @Override
    public void deleteById(int theId) {


        Item theItem = entityManager.find(Item.class, theId);


        entityManager.remove(theItem);
    }
}



