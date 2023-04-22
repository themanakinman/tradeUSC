package csci201_backend.backenddemo.rest;
import csci201_backend.backenddemo.entity.Cart;
import csci201_backend.backenddemo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class CartRestController {
    private CartService cartService;

    @Autowired
    public CartRestController(CartService theCartService){ cartService = theCartService;}

    @GetMapping("/cart/find")
    public Cart getCart(@RequestHeader int item_id){
        Cart theCart = cartService.findByID(item_id);
        if(theCart ==null){
            throw new RuntimeException("Item_id not found - "+item_id);
        }
        return theCart;
    }

    @GetMapping("/cart/findAll")
    public List<Cart> getAllItem(){
        return cartService.findAll();
    }


    @PostMapping("/cart")
    public Cart addItem(@RequestBody Cart theCart){
        theCart.setItem_id(0);
        Cart dbCart = cartService.save(theCart);
        return dbCart;

    }


    @DeleteMapping("/cart")
    public String deleteItem(@RequestBody Cart theCart) {

        List<Cart> Carts = cartService.findAll();
        Cart tempCart = null;
        for(int i=0; i<Carts.size();i++){
            if(theCart.getTitle().equals(Carts.get(i).getTitle())){
                tempCart = Carts.get(i);
            }
        }
        if (tempCart == null) {
            throw new RuntimeException("Item not found - " + theCart);
        }
        cartService.deleteById(tempCart.getItem_id());
        return "Deleted Item - " + tempCart.getItem_id();
    }
}
