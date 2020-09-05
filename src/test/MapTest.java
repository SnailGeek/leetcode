package test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: MapTest
 * @description:
 * @author: wangf-q
 * @date: 2020-01-15 11:00
 **/
public class MapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>(16);

        map.put(1, "11");
        map.put(2, "22");

        map.forEach((key, value)->{
            System.out.println("key: " + key + " value: " + value);
        });
    }
}
