package com.skypay.reservation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;


public class ServiceTest {
    private Service service;
    private final SimpleDateFormat sDateFrmt = new SimpleDateFormat("dd/MM/yyyy");

    @BeforeEach
    void setup() {
        service = new Service();
        service.setRoom(1, RoomType.STANDARD, 1000);
        service.setUser(1, 5000);
    }

    @Test
    void testSuccessfulBooking() throws Exception {
        service.bookRoom(1, 1, sDateFrmt.parse("01/07/2026"), sDateFrmt.parse("03/07/2026"));
    }

    @Test
    void testInvalidDates() throws Exception {
        service.bookRoom(1, 1, sDateFrmt.parse("05/07/2026"), sDateFrmt.parse("01/07/2026"));
    }

    @Test
    void testInsufficientBalance() throws Exception {
        service.setRoom(2, RoomType.SUITE, 10000);
        service.bookRoom(1, 2, sDateFrmt.parse("01/07/2026"), sDateFrmt.parse("03/07/2026"));
    }

    @Test
    void testOverlappingBooking() throws Exception {
        service.bookRoom(1, 1, sDateFrmt.parse("01/07/2026"), sDateFrmt.parse("03/07/2026"));
        service.bookRoom(1, 1, sDateFrmt.parse("02/07/2026"), sDateFrmt.parse("04/07/2026"));
    }
}
