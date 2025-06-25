package com.skypay.reservation;

import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws Exception {
        Service service = new Service();
        SimpleDateFormat sDateFrmt = new SimpleDateFormat("dd/MM/yyyy");

        service.setRoom(1, RoomType.STANDARD, 1000);
        service.setRoom(2, RoomType.JUNIOR, 2000);
        service.setRoom(3, RoomType.SUITE, 3000);

        service.setUser(1, 5000);
        service.setUser(2, 10000);

        service.bookRoom(1, 2, sDateFrmt.parse("30/06/2026"), sDateFrmt.parse("07/07/2026"));
        service.bookRoom(1, 2, sDateFrmt.parse("07/07/2026"), sDateFrmt.parse("30/06/2026"));
        service.bookRoom(1, 1, sDateFrmt.parse("07/07/2026"), sDateFrmt.parse("08/07/2026"));
        service.bookRoom(2, 1, sDateFrmt.parse("07/07/2026"), sDateFrmt.parse("09/07/2026"));
        service.bookRoom(2, 3, sDateFrmt.parse("07/07/2026"), sDateFrmt.parse("08/07/2026"));

        service.setRoom(1, RoomType.SUITE, 10000);

        service.printAll();
        service.printAllUsers();
    }
}
