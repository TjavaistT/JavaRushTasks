package com.javarush.task.task34.task3408;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private WeakHashMap<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        V element = cache.get(key);

        if(element == null){
            element = clazz.getConstructor(key.getClass()).newInstance(key);
            cache.put(key, element);
        }

        return element;
    }

    public boolean put(V obj)  {
        try {
            int sizeStart = size();

            Method getKeyMethod = obj.getClass().getDeclaredMethod("getKey", null);
            getKeyMethod.setAccessible(true);
            cache.put((K) getKeyMethod.invoke(obj, null), obj);

            return size() > sizeStart;
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            return  false;
        }
    }

    public int size() {
        return cache.size();
    }
}
