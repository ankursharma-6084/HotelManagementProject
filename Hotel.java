import java.util.ArrayList;

// mark all instance variables private
// generate all getters and setters

public class Hotel {
    private String name;

    public Integer getId() {
        return id;
    }

    public String getHotelLocation() {
        return hotelLocation;
    }

    public ArrayList<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(ArrayList<Room> roomList) {
        this.roomList = roomList;
    }

    private Integer id;
    private String hotelLocation;

    //roomlist has to be secured
    ArrayList<Room> roomList;

    public Hotel(String name, Integer id, String hotelLocation) {

        this.name = name;
        this.id = id;
        this.hotelLocation = hotelLocation;
        roomList = new ArrayList<>();

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name ;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setHotelLocation(String hotelLocation) {
        this.hotelLocation = hotelLocation;
    }

    public ArrayList<Room> searchHotel(){
         ArrayList<Room> availableRooms = new ArrayList<>();
         for(Room curRoom : roomList){
             if(curRoom.roomStatus == RoomStatus.AVAILABLE) {
                 availableRooms.add(curRoom);
             }
         }

         return availableRooms ;
    }
}
