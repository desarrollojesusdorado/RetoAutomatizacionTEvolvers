package model.restful;

import lombok.Getter;

@Getter
public class DataCreateBooking {

    public String firstname;
    public String lastname;
    public Integer totalprice;
    public Boolean depositpaid;
    public Bookingdates bookingdates;
    public String additionalneeds;

    public DataCreateBooking withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public DataCreateBooking withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public DataCreateBooking withTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
        return this;
    }

    public DataCreateBooking withDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
        return this;
    }

    public DataCreateBooking withBookingdates(Bookingdates bookingdates) {
        this.bookingdates = bookingdates;
        return this;
    }

    public DataCreateBooking withAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
        return this;
    }
}
