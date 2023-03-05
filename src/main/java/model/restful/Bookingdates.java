package model.restful;

public class Bookingdates {
    public String checkin;
    public String checkout;

    public Bookingdates withCheckin(String checkin) {
        this.checkin = checkin;
        return this;
    }

    public Bookingdates withCheckout(String checkout) {
        this.checkout = checkout;
        return this;
    }
}
