package csci201_backend.backenddemo.rest;

import csci201_backend.backenddemo.entity.User;
import csci201_backend.backenddemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService theUserService){ userService = theUserService;}

    @GetMapping("/user/find")
    public User getUser(@RequestHeader int user_id){
        User theUser = userService.findByID(user_id);
        if(theUser ==null){
            throw new RuntimeException("User id not found - "+user_id);
        }
        return theUser;
    }
    @GetMapping("/user/findAll")
    public List<User> getAllUser(){
        return userService.findAll();
    }

@GetMapping("/user/login")
    public boolean checkUsername(@RequestBody User theUser){
        String email = theUser.getEmail();
        String password = theUser.getPassword();
        List<User> Users = userService.findAll();
        for(User user:Users){
            if(user.getEmail().equals(email)){
                if(user.getPassword().equals(password)) return true;
                else return false;
            }
        }
        return false;
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User theUser){
        List<User> Users = userService.findAll();
        boolean flag = false;
        for(User user: Users){
            if(user.getEmail().equals(theUser.getEmail())) flag=true;
        }
        if(flag){
        new RuntimeException("the Email is Already existed - "+theUser.getEmail());
        }
        else{
        theUser.setUser_id(0);
        User dbUser = userService.save(theUser);
        return dbUser;
        }
        return null;
    }






}
