package com.javarush.task.task36.task3601;

import java.util.*;

/**
 * Created by Ivan on 25.06.2017.
 */
public class Service {
    public List<String> getData() {
        List<String> data = new ArrayList<String>() {{
            add("First string");
            add("Second string");
            add("Third string");
        }};
        return data;
    }
}
