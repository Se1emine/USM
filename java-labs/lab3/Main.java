import java.util.Scanner;

class EvenNumberException extends Exception {
    public EvenNumberException(String message) {
        super(message);
    }
}

public class Main {

    public static void addNumber(int number, int[] array, int index) throws EvenNumberException {
        if (number % 2 != 0) {
            throw new EvenNumberException("Нечетное число: " + number + ". Ожидалось четное.");
        }
        array[index] = number;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];
        int count = 0;

        System.out.println("Введите 10 четных чисел:");
        while (count < numbers.length) {
            System.out.print("Число " + (count + 1) + ": ");
            int input;
            try {
                input = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректное целое число.");
                continue;
            }

            try {
                addNumber(input, numbers, count);
                count++;
            } catch (EvenNumberException e) {
                System.out.println("Ошибка: " + e.getMessage());
                System.out.println("Попробуйте еще раз.");
            }
        }

        System.out.println("Массив четных чисел заполнен: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        scanner.close();
    }
}
