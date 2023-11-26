package com.sbs.controllers;

import com.sbs.models.Coupon;
import com.sbs.models.User;
import com.sbs.services.UserService;
import com.sbs.utils.Exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User addUser(User user) {
        return userService.addUser(user);
    }

    @DeleteMapping(value = "/{id}", params = "remove")
    public void removeUser(@PathVariable Long id) {
        userService.removeUser(id);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/id")
    public User findById(Long id) {
        return userService.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    @PatchMapping(value = {"/{id}/{payment}"}, params = "add")
    public User addFunds(@PathVariable Long id, @PathVariable Float payment) {
        return userService.addFunds(id, payment);
    }

    @PatchMapping(value = "/{id}/{withdrawal}", params = "withdraw")
    public User withdrawFunds(@PathVariable Long id, @PathVariable Float withdrawal) {
        return userService.withdrawFunds(id, withdrawal);
    }

    @PatchMapping(value = "/{id}/{couponId}", params = "assign")
    public Coupon takeCoupon(@PathVariable Long id, @PathVariable Long couponId) {
        return userService.takeCoupon(id, couponId);
    }
    @PatchMapping(value = "/{id}/{couponId}", params = "send")
    public Optional<Coupon> sendCoupon(@PathVariable Long id, @PathVariable Long couponId) {
        return userService.sendCoupon(id, couponId);
    }
}