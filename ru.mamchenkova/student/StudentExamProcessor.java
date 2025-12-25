package ru.mamchekova.student;

import java.io.*;
import java.util.*;

public class StudentExamProcessor {

    static class Student {
        String lastName;
        String firstName;
        int school;
        int score;

        Student(String lastName, String firstName, int school, int score) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.school = school;
            this.score = score;
        }

        String getFullName() {
            return lastName + " " + firstName;
        }
    }

    // Основной метод обработки файла
    public void processStudentsFromFile(String filename) throws IOException {
        List<Student> allStudents = readStudentsFromFile(filename);
        if (allStudents == null) return;

        List<Student> school50Students = new ArrayList<>();
        for (Student s : allStudents) {
            if (s.school == 50) {
                school50Students.add(s);
            }
        }

        if (school50Students.size() < 5) {
            System.out.println("Ошибка: менее 5 учеников школы №50");
            return;
        }

        processResults(school50Students);
    }

    // Чтение данных из файла
    private List<Student> readStudentsFromFile(String filename) throws IOException {
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            if (line == null) {
                System.out.println("Файл пуст");
                return null;
            }

            int totalStudents = Integer.parseInt(line.trim());

            for (int i = 0; i < totalStudents; i++) {
                line = reader.readLine();
                if (line == null) {
                    System.out.println("Недостаточно строк в файле");
                    break;
                }

                String[] parts = line.trim().split("\\s+");
                if (parts.length != 4) {
                    System.out.println("Некорректный формат строки: " + line);
                    continue;
                }

                String lastName = parts[0];
                String firstName = parts[1];
                int school = Integer.parseInt(parts[2]);
                int score = Integer.parseInt(parts[3]);

                students.add(new Student(lastName, firstName, school, score));
            }
        }

        return students;
    }

    // Обработка результатов учеников школы №50
    private void processResults(List<Student> school50Students) {
        school50Students.sort((s1, s2) -> Integer.compare(s2.score, s1.score));

        int bestScore = school50Students.get(0).score;

        // Считаем учеников с максимальным баллом
        int bestCount = 0;
        for (Student s : school50Students) {
            if (s.score == bestScore) bestCount++;
            else break;
        }

        // Вывод согласно условиям задачи
        if (bestCount > 2) {
            System.out.println(bestCount);
        } else if (bestCount == 2) {
            System.out.println(school50Students.get(0).getFullName());
            System.out.println(school50Students.get(1).getFullName());
        } else {
            System.out.println(school50Students.get(0).getFullName());
        }
    }
}
