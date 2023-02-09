import java.util.ArrayList;

public class Admin extends Person {

    // To make this clas Singleton 
    // Person - name , phone
    
    private ArrayList<Hotel> hotels ;

    public Admin(Hotel hotel){
        hotels = new ArrayList<>();
        hotels.add(hotel);
    }



    public void addHotel(Hotel hotel){
        hotels.add(hotel);
    }

	public void addRoom(Hotel hotel,Room roomDetail){
                hotel.roomList.add(roomDetail);
    }
	public String deleteRoom(Hotel hotel,int roomId){

           Room toDeleteRoom = null;
                   for(Room cuRoom : hotel.roomList){
                            if(roomId == cuRoom.getRoomId()) {
                                toDeleteRoom = cuRoom ;
                                break ;
                            }
                   }

           if(toDeleteRoom != null){
               hotel.roomList.remove(toDeleteRoom);
               return "Room Removed";
           }

           else return "Room Not Found";
           
    }
	public void editRoom(Hotel hotel, Room roomDetail){
              deleteRoom(hotel , roomDetail.getRoomId());
              addRoom(hotel , roomDetail);
    }
}
