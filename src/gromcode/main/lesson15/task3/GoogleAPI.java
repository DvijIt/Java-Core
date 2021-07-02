package gromcode.main.lesson15.task3;

public class GoogleAPI implements API {
    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int amount = calculateValidRoomsAmount(price, persons, city, hotel);
        Room[] resultRooms = new Room[amount];

        if (!isQueryValid(price, persons) || rooms == null || amount <= 0) {
            return new Room[0];
        }

        int index = 0;
        for (Room room : rooms) {
            if (isRoomValid(price, persons, city, hotel, room)) {
                resultRooms[index] = room;
                index++;
            }
        }
        return resultRooms;

    }

    @Override
    public Room[] getAll() {
        return rooms;
    }

    private int calculateValidRoomsAmount(int price, int persons, String city, String hotel) {
        int count = 0;
        for (Room room : rooms) {
            if (isRoomValid(price, persons, city, hotel, room)) {
                count++;
            }
        }
        return count;
    }

    private boolean isQueryValid(int price, int persons) {
        return price > 0 && persons > 0;
    }

    private boolean isRoomValid(int price, int persons, String city, String hotel, Room room) {
        if (room == null) {
            return false;
        }
        return room.getPrice() == price && room.getPersons() == persons && room.getCityName() == city
                && room.getHotelName() == hotel;
    }
}
