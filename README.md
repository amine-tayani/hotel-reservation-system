# Hotel Reservation System

A simple Java hotel reservation system to manage rooms, users, and bookings.


## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/amine-tayani/hotel-reservation-system.git
cd hotel-reservation-system
```

### 2. Run the project

```bash
mvn compile exec:java -Dexec.mainClass=com.skypay.reservation.Main
```

### 3. Test the project

```bash
mvn test
```

## 📝 Run Results

```bash
󰣇 Desktop/projects/java ❯  

/usr/bin/env /usr/lib/jvm/java-24-openjdk/bin/java -XX:+ShowCodeDetailsInExceptionMessages -cp /home/maxima/Desktop/projects/java/reservation-system/target/classes com.skypay.reservation.Main

you don't have enough balance to pay for the booking.
Invalid dates for booking. Check-in date must be before check-out date.
The room is not available at the given dates.

Room{number=3, type=SUITE, pricePerNight=3000}
Room{number=2, type=JUNIOR, pricePerNight=2000}
Room{number=1, type=SUITE, pricePerNight=10000}

Booking{user=User{id=2, balance=7000}, room=Room{number=3, type=SUITE, pricePerNight=3000},
checkIn=Tue Jul 07 00:00:00 GMT+01:00 2026, checkOut=Wed Jul 08 00:00:00 GMT+01:00 2026, priceAtBooking=3000}

Booking{user=User{id=1, balance=4000}, room=Room{number=1, type=SUITE, pricePerNight=10000},
checkIn=Tue Jul 07 00:00:00 GMT+01:00 2026, checkOut=Wed Jul 08 00:00:00 GMT+01:00 2026, priceAtBooking=1000}

User{id=2, balance=7000}
User{id=1, balance=4000}

```
