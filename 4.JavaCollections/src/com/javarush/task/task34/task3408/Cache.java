package com.javarush.task.task34.task3408;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        V cl = cache.get(key);
        if (cl == null) cl = clazz.getConstructor(key.getClass()).newInstance(key);
        cache.put(key, cl);
        //TODO add your code here
        return cl;
    }


    //        Field field = obj.getClass().getDeclaredField("myKey");
//        field.setAccessible(true);
//        Object value = field.get(obj);
    //        K k = (K) value;
    public boolean put(V obj) {
        try {
            Method getKey = obj.getClass().getDeclaredMethod("getKey");
            getKey.setAccessible(true);
            cache.put((K) getKey.invoke(obj), obj);
            return true;
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
//                e.printStackTrace();
        }
        return false;
    }


    public int size() {
        return cache.size();
    }
}
