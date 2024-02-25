package com.example.labwork;

public class Cache {
    private CacheBlock[] cacheBlocks;
    private int hits;
    private int misses;
    private int totalAccesses; // Добавляем переменную для подсчета общего количества обращений

    public Cache(int size) {
        this.cacheBlocks = new CacheBlock[size];
        for (int i = 0; i < size; i++) {
            cacheBlocks[i] = new CacheBlock();
        }
        this.hits = 0;
        this.misses = 0;
        this.totalAccesses = 0; // Инициализируем счетчик общего количества обращений
    }

    public boolean accessCache(int address, Color color, boolean write) {
        totalAccesses++; // Учет каждого обращения к кэшу
        int blockIndex = address % cacheBlocks.length;
        int colorIndex = (address / cacheBlocks.length) % 4;
        CacheBlock block = cacheBlocks[blockIndex];

        if (write) {
            // Запись изменяет данные в кэше, считаем это промахом
            misses++;
            block.colors[colorIndex] = color;
            block.valid = true;
            return false; // Возвращаем false, так как это промах
        } else {
            if (block.valid && block.colors[colorIndex] != null) {
                hits++;
                return true; // Попадание в кэш
            } else {
                misses++;
                // Пример чтения из основной памяти и запись в кэш не показан для упрощения
                block.valid = true;
                return false; // Промах
            }
        }
    }

    // Методы для получения статистики
    public int getHits() {
        return hits;
    }

    public int getMisses() {
        return misses;
    }

    public int getTotalAccesses() {
        return totalAccesses;
    }
}
