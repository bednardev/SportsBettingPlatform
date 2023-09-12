package Coupon;


 class CustomCouponRepository implements CouponRepository {

    private Coupon coupon;
    private Long id = 0L;

    public Coupon addBet(Bet bet) {
        coupon.getCouponBets().add(bet);
        return coupon;
    }

    public Coupon removeBet(Bet bet) {
        coupon.getCouponBets().remove(bet);
        return coupon;
    }

    public Coupon saveCoupon(){
        coupon.setId(id);
        id += 1;
        return coupon;
    }
}
