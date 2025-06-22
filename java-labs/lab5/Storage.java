import java.util.ArrayList;
import java.util.List;

public class Storage<T extends Number> {
    private final List<T> items = new ArrayList<>();

    /**
     * Добавляет элемент в хранилище.
     * @param item объект числового типа
     */
    public void add(T item) {
        items.add(item);
    }

    /**
     * Вычисляет среднее значение всех добавленных чисел.
     * @return среднее значение в виде double; если нет элементов, возвращает 0.0
     */
    public double average() {
        if (items.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;
        for (T item : items) {
            sum += item.doubleValue();
        }
        return sum / items.size();
    }

    /**
     * Возвращает количество элементов в хранилище.
     */
    public int size() {
        return items.size();
    }

    // Пример использования
    public static void main(String[] args) {
        Storage<Integer> intStorage = new Storage<>();
        intStorage.add(10);
        intStorage.add(20);
        intStorage.add(30);
        System.out.println("Среднее для Integer: " + intStorage.average()); // 20.0

        Storage<Double> doubleStorage = new Storage<>();
        doubleStorage.add(5.5);
        doubleStorage.add(7.25);
        System.out.println("Среднее для Double: " + doubleStorage.average()); // 6.375
    }
}
