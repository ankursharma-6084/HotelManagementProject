import java.time.LocalDate;

public class Booking {

    private static Integer bookingId = 0 ;

    private Room findRoomFromRoomId(Hotel hotel, int roomId) {
        for (Room room : hotel.roomList) {
            if (roomId == room.getRoomId()) {
                return room;
            }
        }
        return null;
    }


    // This function books guest room from today till user wants the room there is no boundary
	public Integer createBooking(Hotel hotel, int roomId){
          
             Room room = findRoomFromRoomId(hotel , roomId );
                 if(room == null) return -1;

                 else if(room.roomStatus == RoomStatus.AVAILABLE){
                        System.out.println("Booking in process");
                        room.roomStatus = RoomStatus.NOT_AVAILBLE ;
                        bookingId++ ;
                        return bookingId;
                 }

                 else{
                    return -1 ;
                 }

    }

    // Change to StartDate , EndDate booking Schedule
    public Integer createBooking(Hotel hotel , int roomId, LocalDate startDate, LocalDate endDate){
           int startIndex = DifferenceBetweenTwoDates.getDifferenceBtwDates(startDate);
           int endIndex = DifferenceBetweenTwoDates.getDifferenceBtwDates(endDate);
           Room room = findRoomFromRoomId(hotel , roomId );

           if(endIndex > 100 || room == null || room.roomStatus == RoomStatus.NOT_AVAILBLE) return -1 ;

           boolean roomAvailable = true ;

           for(int i=startIndex; i<=endIndex; i++){
                if(room.roomBookingSchedule[i] == 1) roomAvailable = false ;
           }

           if(roomAvailable == false) return -1 ;

            for(int i=startIndex; i<=endIndex; i++){
                room.roomBookingSchedule[i] = 1 ;
            }

            bookingId++ ;
            return bookingId;
    }

	public String cancelBooking(Hotel hotel, int roomId){
          
        for(Room room: hotel.roomList){
              
            if(roomId == room.getRoomId()){
               if(room.roomStatus == RoomStatus.NOT_AVAILBLE){
                  room.roomStatus = RoomStatus.AVAILABLE ;
                  return "Cancelled";
               }

               else{
                  return "Cannot be Cancelled" ;
               }
            }
        }

          return "Cannot be Cancelled" ;
    }

    public String cancelBooking(Hotel hotel, int roomId, LocalDate startDate, LocalDate endDate){

        Room roomBooked = null ;

        for(Room room: hotel.roomList){

            if(roomId == room.getRoomId()){
                roomBooked = room ;
                break;
            }
        }

        if(roomBooked == null)
        return "Cannot be Cancelled" ;

        int startIndex = DifferenceBetweenTwoDates.getDifferenceBtwDates(startDate);
        int endIndex = DifferenceBetweenTwoDates.getDifferenceBtwDates(endDate);

        for(int i=startIndex; i<=endIndex; i++){
            roomBooked.roomBookingSchedule[i] = 0 ;
        }

        return "Cancelled" ;
    }

}

