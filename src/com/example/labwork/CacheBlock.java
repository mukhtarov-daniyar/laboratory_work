package com.example.labwork;

public class CacheBlock {
    Color[] colors; // Массив цветов в блоке кэша
    boolean valid; // Флаг, показывающий, содержит ли блок кэша актуальные данные

    // Конструктор класса CacheBlock
    public CacheBlock() {
        this.colors = new Color[4]; // Создание массива для хранения цветов в блоке кэша размером 4
        this.valid = false; // Инициализация флага, что блок кэша не содержит актуальных данных
    }
}
