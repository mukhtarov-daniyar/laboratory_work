package com.example.labwork;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    private CacheBlock[] cacheBlocks;
    private int hits;
    private int misses;

    public Cache(int size) {
        this.cacheBlocks = new CacheBlock[size];
        for (int i = 0; i < size; i++) {
            cacheBlocks[i] = new CacheBlock();
        }
        this.hits = 0;
        this.misses = 0;
    }

    public boolean accessCache(int address, Color color) {
        int blockIndex = address % cacheBlocks.length;
        CacheBlock block = cacheBlocks[blockIndex];

        if (block.valid && block.colors[address / cacheBlocks.length % 4] != null) {
            hits++;
            return true; // Попадание в кэш
        } else {
            misses++;
            block.colors[address / cacheBlocks.length % 4] = color; // Добавление в кэш
            block.valid = true;
            return false; // Промах и добавление в кэш
        }
    }

    public int getHits() {
        return hits;
    }

    public int getMisses() {
        return misses;
    }
}
