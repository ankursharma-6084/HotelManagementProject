import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
class Guest extends Person {

	private Booking bookingObj;
    private ArrayList<BookedHotelDetails> bookingsDone ;

    public Guest(){
        bookingsDone = new ArrayList<>() ;
    }

    public ArrayList<BookedHotelDetails> getMyBookings(){
        return bookingsDone;
    }

	public ArrayList<Room> getAllAvailableRooms(Hotel hotel){
         return hotel.searchHotel();
    }

    public ArrayList<AvailableHotel> getAllAvailableHotels(MakeMyTrip newMakeMyTrip ,
                                                           LocalDate startDate , LocalDate endDate){
           return newMakeMyTrip.getAllAvailableHotels(startDate , endDate) ;
    }

	public String createBooking(Hotel hotel, int roomId){
        bookingObj = new Booking();

        Integer bookingId = bookingObj.createBooking(hotel, roomId);
        if(bookingId == -1) {
            return "Booking Unsuccesfull" ;
        }

        bookingsDone.add(new BookedHotelDetails( bookingId , hotel.getId(), hotel.getName() , roomId, LocalDate.now(), null )) ;
        return "Booking Successfull" ;
    }

    public String createBooking(Hotel hotel, int roomId, LocalDate startDate, LocalDate endDate){
        bookingObj = new Booking();

        Integer bookingId = bookingObj.createBooking(hotel, roomId, startDate, endDate);
        if(bookingId == -1) {
            return "Booking Unsuccesfull" ;
        }

        bookingsDone.add(new BookedHotelDetails( bookingId , hotel.getId(), hotel.getName() , roomId, startDate, endDate )) ;
        return "Booking Successfull" ;
    }

	public String cancelBooking(Hotel hotel, int roomId){

        bookingObj = new Booking();
        BookedHotelDetails toDeleteBooking = null;
        String bookingCancelledOrNot = bookingObj.cancelBooking(hotel, roomId);
        if(bookingCancelledOrNot == "Cancelled"){
            for(BookedHotelDetails curBookedHotel : bookingsDone){
                 if(curBookedHotel.getRoomNumber() == roomId && curBookedHotel.getHotelName() == hotel.getName()){
                      toDeleteBooking = curBookedHotel ;
                      break;
                 }
            }
        }

        bookingsDone.remove(toDeleteBooking) ;
        if(toDeleteBooking != null) return "Cancelled Successfully" ;
        return "Cannot Be Cancelled" ;
    }

    public String cancelBooking(Integer bookingId){

        LocalDate startDate ;
        LocalDate endDate ;
        BookedHotelDetails toDeleteBooking = null;
        for(BookedHotelDetails curBookedHotel : bookingsDone){
            if(curBookedHotel.getBookingId() == bookingId ){
                toDeleteBooking = curBookedHotel ;
                break;
            }
        }

        if(toDeleteBooking == null) {
            return "Cannot Be Cancelled" ;
        }

        startDate = toDeleteBooking.getStartDate() ;
        endDate = toDeleteBooking.getEndDate() ;
        Hotel hotel = MakeMyTrip.getHotelfromHotelId(toDeleteBooking.getHotelId()) ;

        if(hotel == null)  return "Cannot Be Cancelled" ;

        int roomId = toDeleteBooking.getRoomNumber() ;
        bookingObj = new Booking();
        return bookingObj.cancelBooking(hotel , roomId , startDate, endDate );

    }
}
