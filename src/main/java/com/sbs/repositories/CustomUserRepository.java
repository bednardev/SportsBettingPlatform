package com.sbs.repositories;

import com.sbs.models.Coupon;
import com.sbs.models.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CustomUserRepository implements UserRepository {
    private Map<Long, User> users = new HashMap<>();

    private Long id = 0L;
    @Override
    public User addUser(User user) {
        user.setId(id);
        users.put(id, user);
        id += 1;
        return user;
    }
    @Override
    public void removeUser(Long id) {
        users.remove(id);
    }
    @Override
    public List<User> getUsers(){
        return new LinkedList<>(users.values());
    }

    @Override
    public Optional<User> findById(Long id){
        return users.containsKey(id) ? Optional.of(users.get(id)) : Optional.empty();
    }

}
