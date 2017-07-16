package com.javarush.task.task35.task3512;

public class Generator<T> {
    public Generator(Class<T> eventClass) {
        this.aClass = eventClass;
    }

    private Class<T>  aClass;

    T newInstance() throws IllegalAccessException, InstantiationException {
        return (T) aClass.newInstance();
    }
}
