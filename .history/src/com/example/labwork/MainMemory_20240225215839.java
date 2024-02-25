package com.example.labwork;

// Класс MainMemory представляет основную память, хранящую цвета в двумерном массиве CMYK.
public class MainMemory {
    private Color[][] memory; // Массив для хранения цветов
    private int N; // Размерность по вертикали
    private int M; // Размерность по горизонтали

    // Конструктор класса, принимающий размеры N и M
    public MainMemory(int N, int M) {
        this.N = N; // Сохранение размера N
        this.M = M; // Сохранение размера M
        memory = new Color[N][M]; // Создание двумерного массива для памяти
        // Инициализация памяти нулевыми значениями CMYK
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                memory[i][j] = new Color(0, 0, 0, 0); // Создание нового цвета и его сохранение в ячейке памяти
            }
        }
    }

    // Метод для установки цвета в указанной ячейке памяти
    public void setColor(int i, int j, Color color) {
        memory[i][j] = color; // Присваивание цвета указанной ячейке памяти
    }

    // Метод для получения цвета из указанной ячейки памяти
    public Color getColor(int i, int j) {
        return memory[i][j]; // Возвращение цвета из указанной ячейки памяти
    }

    // Метод для получения размера N
    public int getN() {
        return N; // Возвращение размера N
    }

    // Метод для получения размера M
    public int getM() {
        return M; // Возвращение размера M
    }
}
