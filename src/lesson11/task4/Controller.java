package lesson11.task4;

public class Controller {
    API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {
        int amount = countOfAllApisValidateRooms(price, persons, city, hotel);
        Room[] resultRooms = new Room[amount];

        if (amount <= 0) {
            return new Room[0];
        }

        int index = 0;
        for (API api : apis) {
            Room[] rooms = api.findRooms(price, persons, city, hotel);
            for (Room room : rooms) {
                resultRooms[index] = room;
                index++;
            }
        }
        return resultRooms;
    }

    private int countOfAllApisRooms() {
        int count = 0;
        for (API api : apis) {
            if (api != null)
                count += api.getAll().length;
        }
        return count;
    }

    private Room[] allRooms() {
        int allRoomsAmount = countOfAllApisRooms();

        if (allRoomsAmount <= 0) {
            return null;
        }

        Room[] allRooms = new Room[allRoomsAmount];

        int index = 0;
        for (API api : apis) {
            if (api != null) {
                Room[] rooms = api.getAll();
                for (Room room : rooms) {
                    allRooms[index] = room;
                    index++;
                }
            }

        }
        return allRooms;
    }

    private int countOfAllApisValidateRooms(int price, int persons, String city, String hotel) {
        int count = 0;
        for (API api : apis) {
            if (api != null) {
                count += api.findRooms(price, persons, city, hotel).length;
            }
        }
        return count;
    }

    public Room cheapestRoom() {
        Room[] allRooms = this.allRooms();
        Room cheapestRoom = allRooms[0];

        for (Room room : allRooms) {
            if (room != null && room.getPrice() < cheapestRoom.getPrice())
                cheapestRoom = room;
        }

        return cheapestRoom;
    }

    public Room[] check(API api1, API api2) {
        if (api1 == null || api2 == null) {
            return new Room[0];
        }

        int count = 0;

        Room[] roomsAPI1 = api1.getAll();
        Room[] roomsAPI2 = api2.getAll();

        for (Room roomAPI1 : roomsAPI1) {
            for (Room roomAPI2 : roomsAPI2) {
                if (isRoomsSimilar(roomAPI1, roomAPI2)) {
                    count++;
                    break;
                }
            }
        }

        Room[] resultRooms = new Room[count];

        int index = 0;
        for (Room roomAPI1 : roomsAPI1) {
            for (Room roomAPI2 : roomsAPI2) {
                if (isRoomsSimilar(roomAPI1, roomAPI2)) {
                    resultRooms[index] = roomAPI1;
                    index++;
                    break;
                }
            }
        }
        return resultRooms;
    }

    private boolean isRoomsSimilar(Room room1, Room room2) {
        if (room1 == null || room2 == null) {
            return false;
        }

        return room1.getPrice() == room2.getPrice() &&
                room1.getCityName() == room2.getCityName() &&
                room1.getPersons() == room2.getPersons() &&
                room1.getHotelName() == room2.getHotelName();
    }

}
