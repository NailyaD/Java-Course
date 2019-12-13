package de.telran;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserService {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public User getUserById(int id) {
        return users.get(id);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public void deleteUser(String lastName) {
        users.stream().filter(u -> u.getLastName().equals(lastName))
                      .map(u -> users.remove(u)).collect(Collectors.toList());
    }
}
