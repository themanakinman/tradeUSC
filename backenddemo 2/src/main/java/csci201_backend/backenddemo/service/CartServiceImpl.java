package csci201_backend.backenddemo.service;
import csci201_backend.backenddemo.dao.CartDAO;
import csci201_backend.backenddemo.entity.Cart;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service

public class CartServiceImpl implements CartService {
    private CartDAO cartDAO;
    @Autowired
    public CartServiceImpl(CartDAO theCartDAO){
        cartDAO = theCartDAO;
    }

    @Override
    public Cart findByID(int theId){
        return cartDAO.findByID(theId);
    }

    @Override
    public List<Cart> findAll(){
        return cartDAO.findAll();
    }
    

    @Override
    @Transactional
    public Cart save(Cart theCart){
        return cartDAO.save(theCart);
    }
    @Override
    @Transactional
    public void deleteById(int theId){

        cartDAO.deleteById(theId);

    }
}
