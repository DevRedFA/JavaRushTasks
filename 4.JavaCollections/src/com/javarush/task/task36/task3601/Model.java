package com.javarush.task.task36.task3601;

import java.util.List;

/**
 * Created by Ivan on 25.06.2017.
 */
public class Model {
    private static Service service = new Service();

    public List<String> getStringDataList() {
        return service.getData();
    }
}
