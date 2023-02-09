import java.util.*;

public class Search {

	public ArrayList<Room> searchRoom(Hotel hotel){
        ArrayList<Room> availableRooms = new ArrayList<>();
         
        for(Room room : hotel.roomList){
            if(room.roomStatus == RoomStatus.AVAILABLE){
                availableRooms.add(room);
            }
        }

        return availableRooms;
    }

}
