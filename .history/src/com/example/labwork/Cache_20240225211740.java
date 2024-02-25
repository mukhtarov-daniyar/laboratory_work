package com.example.labwork;

public class Cache {
    private CacheBlock[] cacheBlocks;
    private int hits; // Количество попаданий в кэш
    private int misses; // Количество промахов кэша
    private int totalAccesses; // Общее количество обращений к кэшу

    public Cache(int size) {
        this.cacheBlocks = new CacheBlock[size];
        for (int i = 0; i < size; i++) {
            cacheBlocks[i] = new CacheBlock();
        }
        this.hits = 0;
        this.misses = 0;
        this.totalAccesses = 0;
    }

    /**
     * Осуществляет доступ к кэшу для чтения или записи данных.
     *
     * @param address Адрес данных в основной памяти.
     * @param color Данные цвета для записи в кэш.
     * @param write Флаг, определяющий операцию записи (true) или чтения (false).
     * @return Возвращает true, если произошло попадание в кэш, и false в случае промаха.
     */
    public boolean accessCache(int address, Color color, boolean write) {
        totalAccesses++; // Учет каждого обращения к кэшу
        int blockIndex = address % cacheBlocks.length;
        int colorIndex = (address / cacheBlocks.length) % 4;
        CacheBlock block = cacheBlocks[blockIndex];

        if (write) {
            // При записи обновляем данные в кэше и считаем это промахом
            misses++;
            block.colors[colorIndex] = color;
            block.valid = true;
            return false;
        } else {
            // Проверка на попадание в кэш при чтении
            if (block.valid && block.colors[colorIndex] != null) {
                hits++;
                return true; // Попадание в кэш
            } else {
                misses++;
                block.valid = true;
                return false; // Промах
            }
        }
    }

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
