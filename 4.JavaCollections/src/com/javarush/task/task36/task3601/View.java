package com.javarush.task.task36.task3601;

import java.util.List;

/**
 * Created by Ivan on 25.06.2017.
 */
public class View {
    private static Controller controller = new Controller();

    public void fireEventShowData() {
        System.out.println(controller.onDataListShow());
    }
}
