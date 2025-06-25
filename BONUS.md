# Design Questions (Bonus):

Suppose we put all the functions inside the same service. Is this the recommended approach? 

* No. It's not recommended. This violates the Single Responsibility Principle (SRP) from SOLID. 
For better maintainability and testing, concerns like Room management, User management, 
and Booking should be split into separate services (e.g., RoomService, BookingService).

In this design, we chose to have a function `setRoom(..)` that should not impact the previous bookings. What is another way? What is your recommendation?  

* My recommendation is to add versioning to the room data or keep records of room price at booking time (already implemented here via `priceAtBooking`). to avoid mutating critical properties (like price) if it impacts business logic. Using immutable snapshots per booking ensures consistency .