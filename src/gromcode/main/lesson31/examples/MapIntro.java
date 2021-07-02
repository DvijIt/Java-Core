package gromcode.main.lesson31.examples;

import java.util.HashMap;
import java.util.Map;

public class MapIntro {
    public static void main(String[] args) {
        Map<String, Building> map = new HashMap<>();

        Building building = new Building("school..", 5);
        Building building1 = new Building("hospital..", 9);

        map.put("TTT222", building);
        map.put("PG55PR", building1);
        System.out.println(map);

        System.out.println("keys: " + map.keySet());

        System.out.println("values: " + map.values());

        System.out.println("get: " + map.get("TTT222"));

        map.remove("PG55PR");

        System.out.println("map: " + map);

        map.put(null, building);

        map.put("asdasd", building1);

        System.out.println("map: " + map);
    }
}
