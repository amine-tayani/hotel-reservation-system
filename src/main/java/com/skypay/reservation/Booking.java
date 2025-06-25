package com.skypay.reservation;

import java.util.Date;

public class Booking {
  private final User user;
  private final Room room;
  private final Date checkIn;
  private final Date checkOut;
  private final int priceAtBooking;

  public Booking(User user, Room room, Date checkIn, Date checkOut, int priceAtBooking) {
    this.user = user;
    this.room = room;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
    this.priceAtBooking = priceAtBooking;
  }

  public Room getRoom() {
    return room;
  }

  public User getUser() {
    return user;
  }

  public Date getCheckIn() {
    return checkIn;
  }

  public Date getCheckOut() {
    return checkOut;
  }

  @Override
  public String toString() {
    return "Booking{" +
        "user=" + user +
        ", room=" + room +
        ", checkIn=" + checkIn +
        ", checkOut=" + checkOut +
        ", priceAtBooking=" + priceAtBooking +
        '}';
  }
}
