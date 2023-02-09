import java.time.LocalDate;
import java.util.*;;

public class HotelManagementSystem{

        public static void main(String args[]) {

            // Adding new Hotel
            Hotel taj = new Hotel("taj Hotel", 100, "Mumbai") ;

            // Admin adds Rooms to the Hotel
            Admin ankur = new Admin(taj) ;
            Room roomDetail = new Room(100 , RoomStyle.STANDARD, RoomStatus.AVAILABLE, 1000 );
            ankur.addRoom(taj ,roomDetail);

            roomDetail = new Room(101 , RoomStyle.STANDARD, RoomStatus.AVAILABLE, 1000 );
            ankur.addRoom(taj,roomDetail);

            roomDetail = new Room(200 , RoomStyle.DELUX, RoomStatus.AVAILABLE, 2000 );
            ankur.addRoom(taj,roomDetail);

            roomDetail = new Room(201 , RoomStyle.DELUX, RoomStatus.AVAILABLE, 2000 );
            ankur.addRoom(taj,roomDetail);

            roomDetail = new Room(202 , RoomStyle.DELUX, RoomStatus.AVAILABLE, 2000 );
            ankur.addRoom(taj,roomDetail);

            roomDetail = new Room(301 , RoomStyle.FAMILY_SUITE, RoomStatus.AVAILABLE, 3000 );
            ankur.addRoom(taj,roomDetail);

            roomDetail = new Room(302 , RoomStyle.FAMILY_SUITE, RoomStatus.AVAILABLE, 3000 );
            ankur.addRoom(taj,roomDetail);

            // New Guest Formation
            Guest animesh = new Guest();
            // Get available rooms using Hotel Name
            ArrayList<Room> allAvailableRooms = animesh.getAllAvailableRooms(taj) ;
            System.out.println("Available Rooms in Selected Hotel");
            for(Room room : allAvailableRooms){
                System.out.print(room.getRoomId() + ", ");
            }

            // Create booking using hotel name and room number
            String myBooking = animesh.createBooking(taj, 301) ;
            System.out.println(myBooking);


            // Room search using StartDate and EndDate ;
            MakeMyTrip newMakeMyTrip = MakeMyTrip.getInstance() ;
            newMakeMyTrip.registerHotel(ankur , taj) ;
            LocalDate startDate = LocalDate.of(2023 , 02 , 12);
            LocalDate endDate = LocalDate.of(2023 , 02 , 20);

            ArrayList<AvailableHotel> availableHotels = newMakeMyTrip.getAllAvailableHotels(startDate , endDate) ;
            System.out.println("Available Rooms in All Hotels selected According to Dates");
            for(AvailableHotel hotel : availableHotels) {
                System.out.println("Hotel Name : " + hotel.getName());
                ArrayList<Room> availableRooms = hotel.getAvailableRoom() ;
                for(Room curRoom : availableRooms) {
                    System.out.print(curRoom.getRoomId() + ", ");
                }
            }

            String myBookingWithDates = animesh.createBooking(taj, 201, startDate, endDate) ;
            System.out.println(myBookingWithDates);

            ArrayList<BookedHotelDetails> myBookedHotels = animesh.getMyBookings();
            for(BookedHotelDetails curBookedHotel : myBookedHotels ){
                System.out.print("Hotel : " + curBookedHotel.getHotelName() + ", ");
                System.out.print("RoomNumber : " + curBookedHotel.getRoomNumber() + ", ");
                System.out.print("BookingId : " + curBookedHotel.getBookingId() + ", ");
                System.out.print("StartDate : " + curBookedHotel.getStartDate() + ", ");
                System.out.println("EndDate : " + curBookedHotel.getEndDate());
            }
        }



}