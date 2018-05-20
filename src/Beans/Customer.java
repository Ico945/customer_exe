package Beans;

public class Customer {
    private int id;
    private String user_id;
    private String merchant_id;
    private String coupon_id;
    private String discount_rate;
    private String distance;
    private String date_received;

    public int getId() {
        return id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public String getCoupon_id() {
        return coupon_id;
    }

    public String getDiscount_rate() {
        return discount_rate;
    }

    public String getDistance() {
        return distance;
    }

    public String getDate_received() {
        return date_received;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public void setCoupon_id(String coupon_id) {
        this.coupon_id = coupon_id;
    }

    public void setDiscount_rate(String discount_rate) {
        this.discount_rate = discount_rate;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public void setDate_received(String date_received) {
        this.date_received = date_received;
    }
}
