package csci201_backend.backenddemo.service;
import csci201_backend.backenddemo.dao.ItemDAO;
import csci201_backend.backenddemo.entity.Item;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {
    private ItemDAO itemDAO;
    @Autowired
    public ItemServiceImpl(ItemDAO theItemDAO){ itemDAO = theItemDAO;}

    @Override
    public Item findByID(int theId){
        return itemDAO.findByID(theId);
    }

    @Override
    public List<Item> findAll(){
        return itemDAO.findAll();
    }

    @Override
    public List<Item> findAll_category(String s){return itemDAO.findAll_category(s);}

    @Override
    @Transactional
    public Item save(Item theItem){
        return itemDAO.save(theItem);
    }
    @Override
    @Transactional
    public void deleteById(int theId){

        itemDAO.deleteById(theId);

    }



}