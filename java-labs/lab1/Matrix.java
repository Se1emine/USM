import java.util.Scanner;

/**
 * Класс Matrix представляет собой целочисленную матрицу размером n x m
 * с методами ввода-вывода и поиска минимального и максимального элементов.
 */
public class Matrix {
    private int n;        // число строк
    private int m;        // число столбцов
    private int[][] data; // сами данные матрицы

    /**
     * Конструктор, создающий пустую матрицу n x m
     * @param n число строк
     * @param m число столбцов
     */
    public Matrix(int n, int m) {
        this.n = n;
        this.m = m;
        data = new int[n][m];
    }

    /**
     * Метод для заполнения матрицы с консоли
     * Использует Scanner для ввода
     */
    public void input() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.printf("Введите элементы матрицы размером %d x %d:%n", n, m);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.printf("A[%d][%d] = ", i, j);
                    data[i][j] = sc.nextInt();
                }
            }
        }
    }

    /**
     * Метод вывода матрицы в консоль
     * Использует System.out.println
     */
    public void print() {
        System.out.println("Содержимое матрицы:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(data[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Поиск минимального элемента в матрице
     * @return минимальное значение
     */
    public int minElement() {
        int min = data[0][0];
        for (int[] row : data) {
            for (int value : row) {
                if (value < min) {
                    min = value;
                }
            }
        }
        return min;
    }

    /**
     * Поиск максимального элемента в матрице
     * @return максимальное значение
     */
    public int maxElement() {
        int max = data[0][0];
        for (int[] row : data) {
            for (int value : row) {
                if (value > max) {
                    max = value;
                }
            }
        }
        return max;
    }

    /**
     * Точка входа для демонстрации функционала класса Matrix
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Введите число строк n: ");
            int n = sc.nextInt();
            System.out.print("Введите число столбцов m: ");
            int m = sc.nextInt();

            Matrix mat = new Matrix(n, m);
            mat.input();
            mat.print();

            System.out.println("Минимальный элемент матрицы: " + mat.minElement());
            System.out.println("Максимальный элемент матрицы: " + mat.maxElement());
        }
    }
}

