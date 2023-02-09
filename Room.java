public class Room {

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    private int roomId;

    // This has to be marked private - Bug number 2
	RoomStyle roomStyle;
	RoomStatus roomStatus;

    // Have to check if it roomBookingSchedule is not acessed by anyone
    Integer roomBookingSchedule[] = new Integer[105] ;
	int bookingPrice;


    public Room(int num , RoomStyle roomStyle , RoomStatus roomStatus , int bookingPrice){
           roomId = num ;
           this.roomStyle = roomStyle;
           this.roomStatus = roomStatus;
           this.bookingPrice = bookingPrice;

           for(int i = 0 ; i<roomBookingSchedule.length; i++)
               roomBookingSchedule[i] = 0 ;
    }

}

enum RoomStyle {
	STANDARD, DELUX, FAMILY_SUITE;
}

enum RoomStatus {	
	AVAILABLE, NOT_AVAILBLE, OCCUPIED ;
}