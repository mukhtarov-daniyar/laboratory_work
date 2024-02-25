package com.example.labwork;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    private Map<Integer, Color> cacheMap;

    public Cache() {
        cacheMap = new HashMap<>();
    }

    public void addToCache(int address, Color color) {
        cacheMap.put(address, color);
    }

    public Color getFromCache(int address) {
        return cacheMap.getOrDefault(address, null);
    }

    public boolean isInCache(int address) {
        return cacheMap.containsKey(address);
    }
}

