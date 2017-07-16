package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

/**
 * Created by Ivan on 12.06.2017.
 */
public class MaleFactory implements AbstractFactory {
    public Human getPerson(int age) {
        if (age <= KidBoy.MAX_AGE) return new KidBoy();
        if (age > KidBoy.MAX_AGE && age <= TeenBoy.MAX_AGE) return new TeenBoy();
        return new Man();
    }
}