package csci201_backend.backenddemo.dao;
import csci201_backend.backenddemo.entity.Cart;
import csci201_backend.backenddemo.entity.Item;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Repository
public class CartDAOJpaImpl implements CartDAO{
    private EntityManager entityManager;
    @Autowired
    public CartDAOJpaImpl (EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Cart> findAll() {
        TypedQuery<Cart> theQuery = entityManager.createQuery("from Cart",Cart.class);
        List<Cart> carts = theQuery.getResultList();
        return carts;
    }

    @Override
    public Cart findByID(int theId) {
        Cart theCart = entityManager.find(Cart.class, theId);
        return theCart;
    }
    @Override
    public Cart save(Cart theCart){
        Cart dbCart = entityManager.merge(theCart);
        return dbCart;
    }

    @Override
    public void deleteById(int theId) {
        Cart cart = entityManager.find(Cart.class, theId);
        entityManager.remove(cart);
    }

}
