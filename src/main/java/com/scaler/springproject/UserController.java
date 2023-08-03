package com.scaler.springproject;

import com.scaler.springproject.pojos.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    List<User> users = new ArrayList<User>();
    @PostMapping("/")
    public User createUser(@RequestBody User user){
        users.add(user);
        return user;
    }
    @GetMapping("/")
    public List<User> getUsers(){
        return users;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        if(id>=0 && users.size()>id){
            return users.get(id);
        }
        User noUser=new User();
        noUser.setName("null");
        noUser.setEmail("null");
        return noUser;
    }
}
