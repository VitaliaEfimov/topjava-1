package ru.javawebinar.topjava;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="http://topjava.herokuapp.com">Demo application</a>
 * @see <a href="https://github.com/JavaOPs/topjava">Initial project</a>
 */
public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"get");
        map.put(2,"get");
        map.put(3,"get");
        map.remove(3);
        System.out.println(map);
    }
}
