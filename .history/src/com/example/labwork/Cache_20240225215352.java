package com.example.labwork;

public class Cache {
    private CacheBlock[] cacheBlocks; // Массив блоков кэша
    private int hits; // Количество попаданий в кэш
    private int misses; // Количество промахов кэша
    private int totalAccesses; // Общее количество обращений к кэшу

    // Конструктор класса Cache
    public Cache(int size) {
        this.cacheBlocks = new CacheBlock[size]; // Создание массива блоков кэша заданного размера
        for (int i = 0; i < size; i++) {
            cacheBlocks[i] = new CacheBlock(); // Инициализация каждого блока кэша
        }
        this.hits = 0; // Инициализация количества попаданий в кэш
        this.misses = 0; // Инициализация количества промахов кэша
        this.totalAccesses = 0; // Инициализация общего количества обращений к кэшу
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
        int blockIndex = address % cacheBlocks.length; // Вычисление индекса блока кэша
        int colorIndex = (address / cacheBlocks.length) % 4; // Вычисление индекса цвета в блоке кэша
        CacheBlock block = cacheBlocks[blockIndex]; // Получение блока кэша по индексу

        if (write) {
            // При записи обновляем данные в кэше и считаем это промахом
            misses++;
            block.colors[colorIndex] = color; // Запись цвета в соответствующий индекс блока кэша
            block.valid = true; // Установка флага, что блок кэша содержит актуальные данные
            return false;
        } else {
            // Проверка на попадание в кэш при чтении
            if (block.valid && block.colors[colorIndex] != null) {
                hits++; // Увеличение счетчика попаданий в кэш
                return true; // Попадание в кэш
            } else {
                misses++; // Увеличение счетчика промахов кэша
                block.valid = true; // Установка флага, что блок кэша содержит актуальные данные
                return false; // Промах
            }
        }
    }

    // Возвращает количество попаданий в кэш
    public int getHits() {
        return hits;
    }

    // Возвращает количество промахов кэша
    public int getMisses() {
        return misses;
    }

    // Возвращает общее количество обращений к кэшу
    public int getTotalAccesses() {
        return totalAccesses;
    }
}
