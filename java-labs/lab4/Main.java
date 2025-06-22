import java.util.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите строку (для завершения ввода нажмите Ctrl+C):");
        Scanner scanner = new Scanner(System.in);
        StringBuffer buffer = new StringBuffer();
        while (scanner.hasNextLine()) {
            buffer.append(scanner.nextLine());
            buffer.append("\n");
        }
        scanner.close();
        String input = buffer.toString();

        Pattern wordPattern = Pattern.compile("[A-Za-zА-Яа-яЁё]+", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = wordPattern.matcher(input);

        List<String> words = new ArrayList<>();
        while (matcher.find()) {
            words.add(matcher.group());
        }

        System.out.println("\nКоличество слов в строке: " + words.size());

        Set<Character> vowels = new HashSet<>(Arrays.asList(
            // латинские
            'A','E','I','O','U','Y',
            'a','e','i','o','u','y',
            // русские
            'А','Е','Ё','И','О','У','Ы','Э','Ю','Я',
            'а','е','ё','и','о','у','ы','э','ю','я'
        ));

        System.out.println("\nСтатистика по каждому слову:");
        for (String word : words) {
            int vCount = 0;
            int cCount = 0;
            for (char ch : word.toCharArray()) {
                if (Character.isLetter(ch)) {
                    if (vowels.contains(ch)) vCount++;
                    else cCount++;
                }
            }
            System.out.printf("%s: гласных=%d, согласных=%d%n", word, vCount, cCount);
        }

        Pattern upperLatinPattern = Pattern.compile("^[A-Z]+$");
        List<String> upperWords = new ArrayList<>();
        for (String word : words) {
            if (upperLatinPattern.matcher(word).matches()) {
                upperWords.add(word);
            }
        }

        // Сортировка и вывод
        Collections.sort(upperWords);
        System.out.println("\nСлова, состоящие только из заглавных латинских букв, в алфавитном порядке:");
        if (upperWords.isEmpty()) {
            System.out.println("Таких слов нет.");
        } else {
            for (String w : upperWords) {
                int vCount = 0, cCount = 0;
                for (char ch : w.toCharArray()) {
                    if (vowels.contains(ch)) vCount++;
                    else cCount++;
                }
                System.out.printf("%s: гласных=%d, согласных=%d%n", w, vCount, cCount);
            }
        }
    }
}
