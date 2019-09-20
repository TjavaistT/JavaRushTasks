package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.get(key);

        return softReference != null ? softReference.get() : null;
    }

    public AnyObject put(Long key, AnyObject value) {

        SoftReference<AnyObject> softReference = cacheMap.get(key);

        AnyObject anyObject = softReference != null ? softReference.get() : null;

        cacheMap.put(key, new SoftReference<>(value));

        if(softReference != null)softReference.clear();

        return anyObject;
    }

    public AnyObject remove(Long key) {

        SoftReference<AnyObject> softReference = cacheMap.get(key);

        AnyObject anyObject = softReference != null ? softReference.get() : null;

        cacheMap.remove(key);

        if(softReference != null)softReference.clear();

        return anyObject;
    }
}