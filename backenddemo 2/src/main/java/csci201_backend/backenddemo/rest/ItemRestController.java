package csci201_backend.backenddemo.rest;
import csci201_backend.backenddemo.entity.Item;
import csci201_backend.backenddemo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("/api")
    @CrossOrigin
    public class ItemRestController {

        private ItemService itemService;

        @Autowired
        public ItemRestController(ItemService theItemService){ itemService = theItemService;}

        @GetMapping("/item/find")
        public Item getItem(@RequestHeader int item_id){
            Item theItem = itemService.findByID(item_id);
            if(theItem ==null){
                throw new RuntimeException("Item_id not found - "+item_id);
            }
            return theItem;
        }

        @GetMapping("/item/findAll")
        public List<Item> getAllItem(){
            return itemService.findAll();
        }

        @GetMapping("/item/category")
        public List<Item> getAllItem_category(@RequestHeader String s ){
            List<Item> theItem_list = itemService.findAll_category(s);
            if(theItem_list.size()==0){
                throw new RuntimeException("Category not found -"+ s);
            }
            return theItem_list;
        }

        @PostMapping("/item")
        public Item addItem(@RequestBody Item theItem){
                theItem.setItem_id_id(0);
                Item dbItem = itemService.save(theItem);
                return dbItem;
        }


        @DeleteMapping("/item")
        public String deleteItem(@RequestBody Item theItem) {

            List<Item> Items = itemService.findAll();
            Item tempItem = null;
            for(int i=0; i<Items.size();i++){
                if(theItem.getTitle().equals(Items.get(i).getTitle())){
                   tempItem = Items.get(i);
                }
            }

            // throw exception if null

            if (tempItem == null) {
                throw new RuntimeException("Employee id not found - " + theItem);
            }

            itemService.deleteById(tempItem.getItem_id());

            return "Deleted employee id - " + tempItem.getItem_id();
        }
    }


