package com.skypay.reservation;

import java.util.*;

public class Service {
  private final List<Room> rooms = new ArrayList<>();
  private final List<User> users = new ArrayList<>();
  private final List<Booking> bookings = new ArrayList<>();

  public void setRoom(int roomNumber, RoomType roomType, int roomPricePerNight) {
    Room room = findRoom(roomNumber);
    if (room == null) {
      rooms.add(new Room(roomNumber, roomType, roomPricePerNight));
    } else {
      room.updateRoom(roomType, roomPricePerNight);
    }
  }

  public void setUser(int userId, int balance) {
    if (findUser(userId) == null) {
      users.add(new User(userId, balance));
    }
  }

  public void bookRoom(int userId, int roomNumber, Date checkIn, Date checkOut) {
    if (!checkOut.after(checkIn)) {
      System.out.println("Invalid dates for booking. Check-in date must be before check-out date.");
      return;
    }

    Room room = findRoom(roomNumber);
    User user = findUser(userId);
    if (room == null || user == null) {
      System.out.println("Either room or user not found.");
      return;
    }

    if (!isRoomAvailable(room, checkIn, checkOut)) {
      System.out.println("The room is not available at the given dates.");
      return;
    }

    int nights = (int) ((checkOut.getTime() - checkIn.getTime()) / (1000 * 60 * 60 * 24));
    int cost = nights * room.getPricePerNight();
    if (user.getBalance() < cost) {
      System.out.println("you don't have enough balance to pay for the booking.");
      return;
    }

    user.deductBalance(cost);
    bookings.add(new Booking(user, room, checkIn, checkOut, cost));
  }

  public void printAll() {
    ListIterator<Room> roomItr = rooms.listIterator(rooms.size());
    while (roomItr.hasPrevious())
      System.out.println(roomItr.previous());
    ListIterator<Booking> bookingIt = bookings.listIterator(bookings.size());
    while (bookingIt.hasPrevious())
      System.out.println(bookingIt.previous());
  }

  public void printAllUsers() {
    ListIterator<User> it = users.listIterator(users.size());
    while (it.hasPrevious())
      System.out.println(it.previous());
  }

  private Room findRoom(int number) {
    return rooms.stream().filter(r -> r.getNumber() == number).findFirst().orElse(null);
  }

  private User findUser(int id) {
    return users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
  }

  private boolean isRoomAvailable(Room room, Date checkIn, Date checkOut) {
    for (Booking b : bookings) {
      if (b.getRoom().getNumber() == room.getNumber()) {
        if (!(checkOut.compareTo(b.getCheckIn()) <= 0 || checkIn.compareTo(b.getCheckOut()) >= 0)) {
          return false;
        }
      }
    }
    return true;
  }
}