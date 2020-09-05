package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: ArrayListTest
 * @description:
 * @author: wangf-q
 * @date: 2020-01-14 17:11
 **/
public class ArrayListTest {

    public static void main(String[] args) {
        List<String> listStr = new ArrayList<>();
        listStr.add("1");
        listStr.add("2");
        listStr.add("3");
        List<String> strings = listStr.subList(0, 3);
        strings.remove("1");
        System.out.println(strings);
        System.out.println(listStr);

        List<Integer> integers = Arrays.asList(1, 2, 3);
//        list.add(4);
    }
}
