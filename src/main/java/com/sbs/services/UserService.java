package com.sbs.services;

import com.sbs.models.Coupon;
import com.sbs.models.User;
import com.sbs.repositories.CouponRepository;
import com.sbs.repositories.UserRepository;
import com.sbs.utils.Exceptions.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.sbs.models.CouponStatus.IN_PLAY;
import static com.sbs.models.CouponStatus.IN_PROGRESS;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final CouponRepository couponRepository;

    public UserService(UserRepository userRepository, CouponRepository couponRepository){
        this.userRepository = userRepository;
        this.couponRepository = couponRepository;
    }
    public User addUser(User user){
        return userRepository.addUser(user);
    }
    public void removeUser(Long id){
        userRepository.removeUser(id);
    }
    public List<User> getUsers(){
        return userRepository.getUsers();
    }
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }
    public User addFunds(Long id, Float payment){
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        user.setBalance(user.getBalance() + payment);
        return user;
    }
    public User withdrawFunds(Long id, Float withdrawal){
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        if (withdrawal >= user.getBalance()) {
            user.setBalance(user.getBalance() - withdrawal);
        }
        else {
            throw new NotEnoughFundsException();
        }
        return user;
    }
    public Coupon takeCoupon(Long id, Long couponId){
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(CouponNotFoundException::new);
        coupon.setUserId(user.getId());
        user.getCoupons().add(coupon);
        return coupon;
    }

    public Optional<Coupon> sendCoupon(Long id, Long couponId) {
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        Coupon coupon = user.findUserCouponByCouponId(couponId)
                .orElseThrow(CouponNotFoundException::new);
        if (IN_PROGRESS == coupon.getCouponStatus() && user.getBalance() >= coupon.getStake()){
            if (coupon.checkIfMatchNotStarted()) {
                user.setBalance(user.getBalance() - coupon.getStake());
                coupon.setCouponStatus(IN_PLAY);
                couponRepository.sendCoupon(coupon);
            }
            else {
                throw new MatchInProgressException();
            }
            return Optional.of(coupon);
        }
        else if (IN_PROGRESS == coupon.getCouponStatus()) {
            throw new NotEnoughFundsException();
        }
            throw new CouponInPlayException();
    }

}
