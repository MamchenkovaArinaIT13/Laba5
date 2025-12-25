package ru.mamchekova.file;

import java.io.*;
import java.util.*;

public class FileRead {
    private Set<Character> voicelessConsonants; // Глухие согласные

    public FileRead() {
        // Глухие согласные русского языка
        this.voicelessConsonants = Set.of(
                'п', 'ф', 'к', 'т', 'ш', 'с', 'х', 'ц', 'ч', 'щ'
        );
    }

    /**
     * Находит все глухие согласные, которые входят в каждое нечетное слово текста
     */
    public Set<Character> analyzeFile(String filename) throws IOException {
        // Множество для хранения глухих согласных из ВСЕХ нечетных слов
        Set<Character> commonConsonants = null;
        int wordCount = 0; // Счетчик слов

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Разбиваем строку на слова
                String[] words = line.toLowerCase().split("[\\s\\p{Punct}]+");

                for (String word : words) {
                    if (word.isEmpty()) {
                        continue; // Пропускаем пустые слова
                    }

                    wordCount++;

                    // Проверяем, нечетное ли это слово (1, 3, 5, ...)
                    if (wordCount % 2 == 1) {
                        // Находим все глухие согласные в текущем слове
                        Set<Character> consonantsInWord = getVoicelessConsonants(word);

                        if (commonConsonants == null) {
                            // Первое нечетное слово - инициализируем
                            commonConsonants = new HashSet<>(consonantsInWord);
                        } else {
                            // Оставляем только те согласные, которые есть и в текущем слове
                            commonConsonants.retainAll(consonantsInWord);
                        }
                    }
                }
            }
        }

        // Если нет нечетных слов или нет общих согласных
        if (commonConsonants == null || commonConsonants.isEmpty()) {
            return new TreeSet<>();
        }

        // Возвращаем в алфавитном порядке
        return new TreeSet<>(commonConsonants);
    }

    /**
     * Возвращает множество глухих согласных из слова
     */
    private Set<Character> getVoicelessConsonants(String word) {
        Set<Character> result = new HashSet<>();

        for (char c : word.toCharArray()) {
            if (isRussianLetter(c) && voicelessConsonants.contains(c)) {
                result.add(c);
            }
        }

        return result;
    }

    /**
     * Проверяет, является ли символ русской буквой
     */
    private boolean isRussianLetter(char c) {
        return (c >= 'а' && c <= 'я') || c == 'ё';
    }

    /**
     * Выводит результат в алфавитном порядке
     */
    public void printResult(Set<Character> consonants) {
        if (consonants.isEmpty()) {
            System.out.println("Нет глухих согласных, входящих во все нечетные слова");
            return;
        }

        System.out.println("Глухие согласные, входящие во все нечетные слова:");
        for (char c : consonants) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    // Дополнительные методы для тестирования

    /**
     * Анализирует текст из строки (для тестов)
     */
    public Set<Character> analyzeText(String text) {
        Set<Character> commonConsonants = null;
        int wordCount = 0;

        String[] words = text.toLowerCase().split("[\\s\\p{Punct}]+");

        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }

            wordCount++;

            if (wordCount % 2 == 1) {
                Set<Character> consonantsInWord = getVoicelessConsonants(word);

                if (commonConsonants == null) {
                    commonConsonants = new HashSet<>(consonantsInWord);
                } else {
                    commonConsonants.retainAll(consonantsInWord);
                }
            }
        }

        if (commonConsonants == null || commonConsonants.isEmpty()) {
            return new TreeSet<>();
        }

        return new TreeSet<>(commonConsonants);
    }

    /**
     * Печатает информацию о классе
     */
    @Override
    public String toString() {
        return "FileRead{" +
                "voicelessConsonants=" + voicelessConsonants +
                '}';
    }
}
