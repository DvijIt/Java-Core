package lesson15.task3;

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
                //changed to equals here
                if (roomAPI1 != null && roomAPI1.equals(roomAPI2)) {
                    count++;
                }
            }
        }

        Room[] resultRooms = new Room[count];

        int index = 0;
        for (Room roomAPI1 : roomsAPI1) {
            for (Room roomAPI2 : roomsAPI2) {
                //changed to equals here
                if (roomAPI1 != null && roomAPI1.equals(roomAPI2)) {
                    resultRooms[index] = roomAPI1;
                    index++;
                }
            }
        }
        return resultRooms;
    }

}
