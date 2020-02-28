package de.telran;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/users", method = POST)
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping(path = "/users/{id}", method = GET)
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @RequestMapping(path ="/users", method = GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(path ="/users/{lastName}", method = DELETE)
    public void deleteUserById(@PathVariable String lastName) {
        userService.deleteUser(lastName);
    }
}
