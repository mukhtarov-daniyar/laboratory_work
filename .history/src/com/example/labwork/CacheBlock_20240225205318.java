package com.example.labwork;

public class CacheBlock {
    Color[] colors; // Массив цветов в блоке
    boolean valid; // Флаг, показывающий, содержит ли блок актуальные данные

    public CacheBlock() {
        this.colors = new Color[4]; // Предполагаем, что вмещает 4 объекта Color
        this.valid = false;
    }
}
