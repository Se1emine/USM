import java.util.Arrays;
import java.util.Scanner;

public class ParallelVectorProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1) Выводим число доступных процессоров
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("Available processors: " + processors);

        // 2) Ввод размера вектора с проверкой
        int n = 0;
        while (true) {
            System.out.print("Введите размер вектора (положительное целое): ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) break;
                else System.out.println("Размер должен быть > 0.");
            } else {
                System.out.println("Неверный ввод. Попробуйте ещё раз.");
                scanner.next(); // сброс неверного токена
            }
        }

        // 3) Ввод элементов вектора с проверкой
        int[] vector = new int[n];
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.printf("vector[%d] = ", i);
                if (scanner.hasNextInt()) {
                    vector[i] = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Неверный ввод. Введите целое число.");
                    scanner.next();
                }
            }
        }

        System.out.println("Исходный вектор: " + Arrays.toString(vector));

        // 4) Создаём потоки
        // Поток для подсчёта отрицательных элементов
        NegativeCounter counterTask = new NegativeCounter(vector);
        Thread counterThread = new Thread(counterTask, "CounterThread");

        // Поток для сортировки
        Sorter sorterTask = new Sorter(vector);
        Thread sorterThread = new Thread(sorterTask, "SorterThread");

        // 5) Запускаем оба потока
        counterThread.start();
        sorterThread.start();

        // Ждём их завершения
        try {
            counterThread.join();
            sorterThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 6) Выводим результаты в main
        System.out.println("Число отрицательных элементов: " + counterTask.getNegativeCount());
        System.out.println("Отсортированный вектор:     " + Arrays.toString(vector));

        scanner.close();
    }
}

// Задача для подсчёта отрицательных элементов
class NegativeCounter implements Runnable {
    private final int[] array;
    private int negativeCount;

    public NegativeCounter(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        int count = 0;
        for (int x : array) {
            if (x < 0) count++;
            // имитация нагрузки, если нужно
            // try { Thread.sleep(1); } catch (InterruptedException ignored) {}
        }
        negativeCount = count;
    }

    public int getNegativeCount() {
        return negativeCount;
    }
}

// Задача для сортировки массива
class Sorter implements Runnable {
    private final int[] array;

    public Sorter(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        Arrays.sort(array);
    }
}
