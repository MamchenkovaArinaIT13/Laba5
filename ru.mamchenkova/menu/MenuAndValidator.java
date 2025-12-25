package ru.mamchekova.menu;

import ru.mamchekova.cats.Cat;
import ru.mamchekova.cats.Funs;
import ru.mamchekova.cats.MeowCounter;
import ru.mamchekova.file.FileRead;
import ru.mamchekova.fractions.Fraction;
import ru.mamchekova.list.ListIntersection;
import ru.mamchekova.queue.QueueEqualityChecker;
import ru.mamchekova.stream.PersonProcessor;
import ru.mamchekova.stream.Point;
import ru.mamchekova.stream.Polyline;
import ru.mamchekova.stream.PolylineStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MenuAndValidator {

  private static final Scanner scanner = new Scanner(System.in);

  // Способ ввода
  public int menu() {
    while (true) {
      System.out.println("\nЗдравствуйте, это Лабораторная работа №5!");
      System.out.println("Выберите способ ввода данных:");
      System.out.println("1. Ручной ввод");
      System.out.println("2. Автоматический ввод (готовые данные)");
      System.out.println("0. Выход");

      System.out.print("Ваш выбор: ");

      if (scanner.hasNextInt()) {
        int inputMethod = scanner.nextInt();
        scanner.nextLine();

        switch (inputMethod) {
          case 1:
            return manualInputMenu(scanner);
          case 2:
            return autoInputMenu(scanner);
          case 0:
            System.out.println("Выход из программы...");
            System.exit(0);
          default:
            System.out.println("Неверный выбор способа ввода!");
            break;
        }
      } else {
        scanner.next(); // очистка некорректного ввода
        System.out.println("Неверно! Введите число от 0 до 2");
      }
    }
  }

  // Ручной ввод
  private int manualInputMenu(Scanner scanner) {
    while (true) {
        System.out.println("\n=== РУЧНОЙ ВВОД ===");
        System.out.println("Выберите задание (вы будете вводить данные):");
        System.out.println("1. Дроби с кэшированием (Задание 1)");
        System.out.println("2. Коты и мяуканье (Задание 2)");
        System.out.println("3. Пересечение списков (Задание 3)");
        System.out.println("4. Лучшие ученики школы №50 (Задание 4)");
        System.out.println("5. Глухие согласные в нечетных словах (Задание 5)");
        System.out.println("6. Проверка равенства участка очереди (Задание 6)");
        System.out.println("7.1. Stream Точек (Задание 7.1)");
        System.out.println("7.2. Stream Людей из файла (Задание 7.2)");
        System.out.println("0. Назад к выбору способа ввода");
        System.out.print("Ваш выбор задания: ");

      if (scanner.hasNextInt()) {
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
          case 1:
            manualInput1();
            break;
          case 2:
            manualInput2();
            break;
          case 3:
            manualInput3();
            break;
          case 4:
            manualInput4();
            break;
          case 5:
            manualInput5();
            break;
          case 6:
            manualInput6();
            break;
          case 7:
            manualInput71();
            break;
          case 8:
            manualInput72();
          case 0:
            return menu();
          default:
            System.out.println("Неверный номер задания!");
            break;
        }
      } else {
        scanner.next();
        System.out.println("Неверно! Введите число от 0 до 7");
      }
    }
  }

  // Автоматический ввод
  private int autoInputMenu(Scanner scanner) {
    while (true) {
      System.out.println("\n=== АВТОМАТИЧЕСКИЙ ВВОД ===");
      System.out.println("Выберите задание (будут использованы готовые данные):");
        System.out.println("1. Дроби с кэшированием (Задание 1)");
        System.out.println("2. Коты и мяуканье (Задание 2)");
        System.out.println("3. Пересечение списков (Задание 3)");
        System.out.println("4. Лучшие ученики школы №50 (Задание 4)");
        System.out.println("5. Глухие согласные в нечетных словах (Задание 5)");
        System.out.println("6. Проверка равенства участка очереди (Задание 6)");
        System.out.println("7.1. Stream Точек (Задание 7.1)");
        System.out.println("7.2. Stream Людей из файла (Задание 7.2)");
        System.out.println("0. Назад к выбору способа ввода");
        System.out.print("Ваш выбор задания: ");

      if (scanner.hasNextInt()) {
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
          case 1:
            autoInput1();
            break;
          case 2:
            autoInput2();
            break;
          case 3:
            autoInput3();
            break;
          case 4:
            autoInput4();
            break;
          case 5:
            autoInput5();
            break;
          case 6:
            autoInput6();
            break;
          case 7:
            autoInput71();
            break;
          case 8:
            autoInput72();
            break;
          case 0:
            return menu();
          default:
            System.out.println("Неверный номер задания!");
            break;
        }
      } else {
        scanner.next();
        System.out.println("Неверно! Введите число от 0 до 7");
      }
    }
  }

  // Методы для ручного ввода
  private void manualInput1() {
    System.out.println("=== Ручной ввод данных для класса Fraction ===");

    try {
      // Создание первой дроби
      System.out.println("\n--- Создание первой дроби ---");
      System.out.print("Введите числитель для дроби 1: ");
      int num1 = scanner.nextInt();
      System.out.print("Введите знаменатель для дроби 1: ");
      int den1 = scanner.nextInt();

      Fraction fraction1 = new Fraction(num1, den1);
      System.out.println("Создана дробь: " + fraction1);
      System.out.println("Вещественное значение: " + fraction1.getFloat());

      // Создание второй дроби
      System.out.println("\n--- Создание второй дроби ---");
      System.out.print("Введите числитель для дроби 2: ");
      int num2 = scanner.nextInt();
      System.out.print("Введите знаменатель для дроби 2: ");
      int den2 = scanner.nextInt();

      Fraction fraction2 = new Fraction(num2, den2);
      System.out.println("Создана дробь: " + fraction2);
      System.out.println("Вещественное значение: " + fraction2.getFloat());

      // Демонстрация кэширования
      System.out.println("\n--- Демонстрация кэширования ---");
      System.out.println("Первое получение вещественного значения дроби 1: " + fraction1.getFloat());
      System.out.println("Второе получение вещественного значения дроби 1: " + fraction1.getFloat() + " (из кэша)");

      // Изменение числителя
      System.out.println("\n--- Изменение числителя дроби 1 ---");
      System.out.print("Введите новый числитель для дроби 1: ");
      int newNum1 = scanner.nextInt();
      fraction1.setNumerator(newNum1);
      System.out.println("Дробь после изменения: " + fraction1);
      System.out.println("Вещественное значение после изменения: " + fraction1.getFloat() + " (кэш сброшен)");

      // Изменение знаменателя
      System.out.println("\n--- Изменение знаменателя дроби 2 ---");
      System.out.print("Введите новый знаменатель для дроби 2: ");
      int newDen2 = scanner.nextInt();
      fraction2.setDenominator(newDen2);
      System.out.println("Дробь после изменения: " + fraction2);
      System.out.println("Вещественное значение после изменения: " + fraction2.getFloat() + " (кэш сброшен)");

      // Сравнение дробей
      System.out.println("\n--- Сравнение дробей ---");
      System.out.println("Дробь 1: " + fraction1);
      System.out.println("Дробь 2: " + fraction2);
      System.out.println("Дроби равны? " + fraction1.equals(fraction2));

      // Создание дроби для сравнения
      System.out.println("\n--- Проверка равенства ---");
      System.out.print("Введите числитель для сравнения: ");
      int compNum = scanner.nextInt();
      System.out.print("Введите знаменатель для сравнения: ");
      int compDen = scanner.nextInt();

      Fraction fractionComp = new Fraction(compNum, compDen);
      System.out.println("Создана дробь для сравнения: " + fractionComp);
      System.out.println("Дробь 1 равна дроби для сравнения? " + fraction1.equals(fractionComp));
      System.out.println("Дробь 2 равна дроби для сравнения? " + fraction2.equals(fractionComp));

      // Тестирование отрицательных значений
      System.out.println("\n--- Тестирование отрицательных значений ---");
      System.out.print("Введите отрицательный числитель: ");
      int negNum = scanner.nextInt();
      System.out.print("Введите отрицательный знаменатель: ");
      int negDen = scanner.nextInt();

      Fraction negativeFraction = new Fraction(negNum, negDen);
      System.out.println("Обработанная дробь: " + negativeFraction);
      System.out.println("Вещественное значение: " + negativeFraction.getFloat());

      // Демонстрация обработки исключений
      System.out.println("\n--- Проверка обработки исключений ---");
      try {
        System.out.print("Введите знаменатель равный 0: ");
        int zeroDen = scanner.nextInt();
        Fraction invalidFraction = new Fraction(1, zeroDen);
      } catch (IllegalArgumentException e) {
        System.out.println("Поймано исключение: " + e.getMessage());
      }

      System.out.println("\n=== Ручной ввод завершен ===");

    } catch (Exception e) {
      System.out.println("Произошла ошибка: " + e.getMessage());
    } finally {
      scanner.close();
    }
  }

  private void manualInput2() {
    System.out.println("Количество мяуканий.\n" +
            "Необходимо воспользоваться классом Кот и методом принимающим всех мяукающих из задачи 2.5.4.\n" +
            "Необходимо таким образом передать кота в указанный метод, что бы после окончания его работы\n" +
            "узнать сколько раз мяукал кот за время его работы. На рисунке показан пример работы. Перед вызовом\n" +
            "метода создаем кота, отправляем ссылку на кота в метод, после окончания его работы выводим\n" +
            "количество мяуканий на экран. Кота изменять нельзя.\n" +
            "Если раннее в вашем варианте не было Кота, то создайте\n" +
            "1. сущность Кот, которая описывается следующим образом:\n" +
            "• Имеет Имя (строка)\n" +
            "• Для создания необходимо указать имя кота.\n" +
            "• Может быть приведен к текстовой форме вида: “кот: Имя”\n" +
            "• Может помяукать, что приводит к выводу на экран следующего текста: “Имя: мяу!”,\n" +
            "вызвать мяуканье можно без параметров.\n" +
            "2. интерфейс Мяуканье: разработайте метод, который принимает набор объектов способных\n" +
            "мяукать и вызывает мяуканье у каждого объекта. Мяукающие объекты должны иметь метод со\n" +
            "следующей сигнатурой:\n" +
            "public void meow();");
    // Запрос имени кота у пользователя
    System.out.print("Введите имя кота: ");
    String catName = scanner.nextLine().trim();

    // Создаем кота с введенным именем
    Cat cat = new Cat(catName);
    System.out.println("Создан: " + cat);

    // Создаем счетчик мяуканий
    MeowCounter counter = new MeowCounter(cat);
    System.out.println("Счетчик мяуканий создан и готов к работе.");

    System.out.println("\nВызываем метод Funs.meowsCare()...");

    // Вызываем метод, который будет вызывать мяуканье
    Funs.meowsCare(counter);

    // Выводим результат
    System.out.println("\nРезультат:");
    System.out.println("кот мяукал " + counter.getMeowCount() + " раз");
  }

    private void manualInput3() {
        ListIntersection<String> listIntersection = new ListIntersection<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Нахождение пересечения двух списков ===");

        // Ввод первого списка L1
        System.out.print("Сколько элементов в первый список L1? ");
        int countL1 = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите элементы списка L1:");
        for (int i = 0; i < countL1; i++) {
            System.out.print("L1 элемент " + (i + 1) + ": ");
            listIntersection.addToL1(scanner.nextLine());
        }

        // Ввод второго списка L2
        System.out.print("Сколько элементов во второй список L2? ");
        int countL2 = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите элементы списка L2:");
        for (int i = 0; i < countL2; i++) {
            System.out.print("L2 элемент " + (i + 1) + ": ");
            listIntersection.addToL2(scanner.nextLine());
        }

        System.out.println("\n=== Исходные данные ===");
        System.out.println("Список L1: " + listIntersection.getL1());
        System.out.println("Список L2: " + listIntersection.getL2());

        // Получение результата (пересечения)
        List<String> result = listIntersection.getIntersection();
        System.out.println("\n=== Результат ===");
        System.out.println("Пересечение L1 ∩ L2 (список L): " + result);

        if (result.isEmpty()) {
            System.out.println("Пересечение пусто - нет общих элементов.");
        } else {
            System.out.println("Найдено " + result.size() + " общих элемента(ов):");
            for (int i = 0; i < result.size(); i++) {
                System.out.println((i + 1) + ") " + result.get(i));
            }
        }

        System.out.println("\n=== Дополнительная информация ===");
        listIntersection.printL1();
        listIntersection.printL2();
        listIntersection.printIntersection();

        // Пример проверки конкретного элемента
        if (!result.isEmpty()) {
            System.out.print("\nПроверить наличие элемента в пересечении? (да/нет): ");
            String check = scanner.nextLine();
            if (check.equalsIgnoreCase("да")) {
                System.out.print("Введите элемент для проверки: ");
                String elementToCheck = scanner.nextLine();
                boolean isInIntersection = listIntersection.isInIntersection(elementToCheck);
                System.out.println("Элемент '" + elementToCheck + "' " +
                        (isInIntersection ? "присутствует" : "отсутствует") + " в пересечении.");
            }
        }

        scanner.close();
    }

    private void manualInput4() {
        System.out.print("Введите количество учеников: ");
        int N = scanner.nextInt();
        scanner.nextLine();

        // Локальный класс для хранения учеников
        class LocalStudent {
            String lastName;
            String firstName;
            int school;
            int score;

            LocalStudent(String lastName, String firstName, int school, int score) {
                this.lastName = lastName;
                this.firstName = firstName;
                this.school = school;
                this.score = score;
            }
        }

        List<LocalStudent> allStudents = new ArrayList<>();

        // Ввод данных
        for (int i = 0; i < N; i++) {
            System.out.print("Ученик " + (i + 1) + " (Фамилия Имя Школа Балл): ");
            String line = scanner.nextLine();
            String[] parts = line.split(" ");

            if (parts.length != 4) {
                System.out.println("Ошибка! Нужно: Фамилия Имя Школа Балл");
                i--;
                continue;
            }

            try {
                String lastName = parts[0];
                String firstName = parts[1];
                int school = Integer.parseInt(parts[2]);
                int score = Integer.parseInt(parts[3]);

                if (school < 1 || school > 99) {
                    System.out.println("Школа должна быть от 1 до 99");
                    i--;
                    continue;
                }

                if (score < 1 || score > 100) {
                    System.out.println("Балл должен быть от 1 до 100");
                    i--;
                    continue;
                }

                allStudents.add(new LocalStudent(lastName, firstName, school, score));

            } catch (NumberFormatException e) {
                System.out.println("Ошибка в числах!");
                i--;
            }
        }

        // Фильтруем школу №50
        List<LocalStudent> school50 = new ArrayList<>();
        for (LocalStudent s : allStudents) {
            if (s.school == 50) {
                school50.add(s);
            }
        }

        // Проверяем количество
        if (school50.size() < 5) {
            System.out.println("\nОшибка: нужно минимум 5 учеников из школы 50");
            System.out.println("Найдено: " + school50.size());
            return;
        }

        // Сортируем по баллам (от большего к меньшему)
        school50.sort((s1, s2) -> s2.score - s1.score);

        int maxScore = school50.get(0).score;

        // Считаем сколько с максимальным баллом
        int countMax = 0;
        for (LocalStudent s : school50) {
            if (s.score == maxScore) {
                countMax++;
            } else {
                break;
            }
        }

        // Вывод результата
        System.out.println("\nРезультат:");
        if (countMax > 2) {
            System.out.println(countMax);
        } else if (countMax == 2) {
            System.out.println(school50.get(0).lastName + " " + school50.get(0).firstName);
            System.out.println(school50.get(1).lastName + " " + school50.get(1).firstName);
        } else {
            System.out.println(school50.get(0).lastName + " " + school50.get(0).firstName);
        }

        scanner.close();
    }

    private void manualInput5() {
        System.out.println("Файл содержит текст на русском языке. Напечатать в алфавитном порядке все глухие\n" +
                "согласные буквы, которые входят в каждое нечетное слово.\n");

        FileRead analyzer = new FileRead();

        System.out.print("Введите название файла для анализа: ");
        String filename = scanner.nextLine();

        System.out.println("\nВыберите режим:");
        System.out.println("1. Прочитать из файла");
        System.out.println("2. Ввести текст вручную");
        System.out.print("Ваш выбор: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // очистка буфера

        try {
            if (choice == 1) {
                // Чтение из файла
                System.out.println("\n=== Анализ файла: " + filename + " ===");
                Set<Character> result = analyzer.analyzeFile(filename);
                System.out.print("Результат: ");
                analyzer.printResult(result);

                // Показываем содержимое файла
                System.out.println("\nСодержимое файла:");
                try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                }

            } else if (choice == 2) {
                // Ввод текста вручную
                System.out.println("\nВведите текст (для завершения введите пустую строку):");
                StringBuilder textBuilder = new StringBuilder();

                while (true) {
                    String line = scanner.nextLine();
                    if (line.isEmpty()) {
                        break;
                    }
                    textBuilder.append(line).append("\n");
                }

                String text = textBuilder.toString().trim();

                System.out.println("\n=== Анализ введенного текста ===");
                System.out.println("Текст: " + text);

                Set<Character> result = analyzer.analyzeText(text);
                System.out.print("\nРезультат: ");
                analyzer.printResult(result);

                // Дополнительная информация
                System.out.println("\n=== Информация о работе программы ===");
                System.out.println("1. Слова нумеруются: 1, 2, 3, 4, ...");
                System.out.println("2. Берутся нечетные слова: 1, 3, 5, ...");
                System.out.println("3. В каждом нечетном слове ищутся глухие согласные");
                System.out.println("4. Находятся согласные, которые есть в КАЖДОМ нечетном слове");
                System.out.println("5. Глухие согласные: п, ф, к, т, ш, с, х, ц, ч, щ");

            } else {
                System.out.println("Неверный выбор!");
            }

        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }


    private void manualInput6() {
        QueueEqualityChecker<String> checker = new QueueEqualityChecker<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Проверка равенства участка очереди ===");

        // Ввод очереди
        System.out.print("Сколько элементов добавить в очередь? ");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            checker.add(scanner.nextLine());
        }

        // Показываем очередь с индексами
        System.out.println("\nТекущая очередь:");
        checker.printQueue();

        // Ввод индексов для проверки
        System.out.print("\nВведите начальный индекс i: ");
        int i = scanner.nextInt();
        System.out.print("Введите конечный индекс j (i < j): ");
        int j = scanner.nextInt();
        scanner.nextLine();

        // Проверка равенства
        try {
            boolean result = checker.checkEquality(i, j);

            System.out.println("\n=== Результат проверки ===");
            System.out.println("Участок очереди с индексами [" + i + ".." + j + "]");

            // Показываем участок
            List<String> list = new ArrayList<>(checker.getQueue());
            System.out.print("Элементы: ");
            for (int k = i; k <= j; k++) {
                System.out.print(list.get(k) + " ");
            }
            System.out.println();

            if (result) {
                System.out.println("✓ ВСЕ элементы на участке РАВНЫ");
                System.out.println("Все равны значению: " + list.get(i));
            } else {
                System.out.println("✗ Элементы на участке НЕ РАВНЫ");
            }

            // Дополнительная информация
            System.out.println("\n=== Дополнительная проверка ===");

            // Проверяем всю очередь
            boolean allEqual = checker.isAllEqual();
            System.out.println("Все элементы очереди равны? " + (allEqual ? "Да" : "Нет"));

            // Поиск всех равных участков
            if (!allEqual) {
                System.out.print("\nВведите длину участка для поиска: ");
                int length = scanner.nextInt();
                scanner.nextLine();

                if (length > 0 && length <= count) {
                    List<Integer> segments = checker.findEqualSegments(length);
                    if (!segments.isEmpty()) {
                        System.out.println("Участки длины " + length + " с равными элементами:");
                        for (int start : segments) {
                            System.out.print("  [" + start + ".." + (start + length - 1) + "]: ");
                            for (int k = start; k < start + length; k++) {
                                System.out.print(list.get(k) + " ");
                            }
                            System.out.println();
                        }
                    } else {
                        System.out.println("Нет участков длины " + length + " с равными элементами");
                    }
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
            System.out.println("Убедитесь, что i < j");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
            System.out.println("Индексы должны быть от 0 до " + (count - 1));
        }

        scanner.close();
    }

  private void manualInput71() {
    System.out.println("Необходимо написать стрим:\n" +
            "Дан набор объектов типа Point, необходимо взять все Point в разных координатах, убрать с\n" +
            "одинаковыми X,Y, отсортировать по X, отрицательные Y сделать положительными и собрать это\n" +
            "все в ломаную (объект типа Polyline)\n" +
            "Если раннее в вашем варианте не было задание с классом Point и Polyline, то написать их:\n" +
            "1. класс Point:\n" +
            "• Координата Х: число.\n" +
            "• Координата Y: число.\n" +
            "• Может возвращать текстовое представление вида “{X;Y}”.\n" +
            "2. класс Line (Линия), расположенная на двумерной плоскости, которая описывается:\n" +
            "• Координата начала: Точка\n" +
            "• Координата конца: Точка\n" +
            "• Может возвращать текстовое представление вида “Линия от {X1;Y1} до {X2;Y2}”\n" +
            "3. класс Polyline (Ломаная), которая будет представлять собой ломаную линию. Ломаная\n" +
            "линия представляет собой набор следующих характеристик:\n" +
            "• Имеет массив Точек, через которые линия проходит.\n" +
            "• Может быть приведена к строковой форме вида “Линия [Т1,T2,…,TN]”, где TN – это\n" +
            "результат приведения к строке Точки с номером N");

    // Ручной ввод точек
    Scanner scanner = new Scanner(System.in);
    System.out.println("\n=== Ручной ввод точек ===");
    System.out.print("Введите количество точек: ");
    int count = scanner.nextInt();

    Point[] points = new Point[count];
    for (int i = 0; i < count; i++) {
      System.out.println("Точка " + (i + 1) + ":");
      System.out.print("  X: ");
      double x = scanner.nextDouble();
      System.out.print("  Y: ");
      double y = scanner.nextDouble();
      points[i] = new Point(x, y);
    }

    // Обрабатываем точки через стрим
    Polyline result = PolylineStream.processPointsDetailed(points);

    // Выводим результат
    System.out.println("\nИсходные точки: " + Arrays.toString(points));
    System.out.println("Результирующая ломаная: " + result);
  }

  private void manualInput72() {
    System.out.println("Дан текстовый файл со строками, содержащими имя человека и его номер в следующей форме:\n" +
            "Вася:5\n" +
            "Петя:3\n" +
            "Аня:5\n" +
            "Номера людей могут повторяться. У каких-то людей может не быть номера.\n" +
            "Необходимо написать стрим выполняющую следующее:\n" +
            "читаются все люди из файла, все имена приводится к нижнему регистру, но с первой буквой в\n" +
            "верхнем регистре, убираем из перечня всех людей без номеров, а имена оставшихся группируются\n" +
            "по их номеру:\n" +
            "[5:[Вася, Аня], 3:[Петя]]");

    // Ручной ввод имени файла
    Scanner scanner = new Scanner(System.in);
    System.out.print("\nВведите имя файла: ");
    String filename = scanner.nextLine();

    try {
      Map<Integer, List<String>> result = PersonProcessor.processFile(filename);

      // Выводим результат
      System.out.println("Группировка по номерам:");
      result.forEach((number, names) -> {
        System.out.println(number + ": " + names);
      });

      // Или в формате как в задании:
      System.out.println("\nВ формате задания:");
      String formatted = result.entrySet().stream()
              .map(entry -> entry.getKey() + ":[" + String.join(", ", entry.getValue()) + "]")
              .collect(Collectors.joining(", "));
      System.out.println("[" + formatted + "]");

    } catch (IOException e) {
      System.out.println("Ошибка чтения файла: " + e.getMessage());
    }
  }


  // Методы для автоматического ввода
  private void autoInput1() {
    System.out.println("В класс Дробь, добавить интерфейс на два метода: получение вещественного значения, установка\n" +
            "числителя и установка знаменателя.\n" +
            "Сгенерировать такую версию дроби, которая будет кэшировать вычисление вещественного\n" +
            "значения.\n" +
            "Если раннее в вашем варианте не было Дроби, то создайте сущность Дробь со следующими\n" +
            "особенностями:\n" +
            "• Имеет числитель: целое число\n" +
            "• Имеет знаменатель: целое число\n" +
            "• Дробь может быть создана с указанием числителя и знаменателя\n" +
            "• Может вернуть строковое представление вида “числитель/знаменатель”\n" +
            "• Необходимо корректно обрабатывать отрицательные значения. Учтите, что знаменатель не может\n" +
            "быть отрицательным.\n" +
            "• Переопределите метод сравнения объектов по состоянию таким образом, чтобы две дроби\n" +
            "считались одинаковыми тогда, когда у них одинаковые значения числителя и знаменателя.");

    // 1. Создание обычных дробей
    Fraction frac1 = new Fraction(1, 2);
    Fraction frac2 = new Fraction(3, 4);
    System.out.println("1. Обычные дроби:");
    System.out.println("   Дробь 1: " + frac1 + " = " + frac1.getFloat());
    System.out.println("   Дробь 2: " + frac2 + " = " + frac2.getFloat());

    // 2. Обработка отрицательных значений
    Fraction frac3 = new Fraction(-2, 3);
    Fraction frac4 = new Fraction(2, -3);
    Fraction frac5 = new Fraction(-2, -3);
    System.out.println("\n2. Обработка отрицательных значений:");
    System.out.println("   Дробь -2/3: " + frac3 + " = " + frac3.getFloat());
    System.out.println("   Дробь 2/-3: " + frac4 + " = " + frac4.getFloat());
    System.out.println("   Дробь -2/-3: " + frac5 + " = " + frac5.getFloat());

    // 3. Демонстрация кэширования вещественного значения
    System.out.println("\n3. Демонстрация кэширования:");
    Fraction frac6 = new Fraction(5, 8);
    System.out.println("   Первый вызов getFloat(): " + frac6.getFloat());
    System.out.println("   Второй вызов getFloat(): " + frac6.getFloat() + " (значение из кэша)");

    // 4. Изменение числителя и сброс кэша
    System.out.println("\n4. Изменение числителя:");
    System.out.println("   Исходная дробь: " + frac6 + " = " + frac6.getFloat());
    frac6.setNumerator(7);
    System.out.println("   После setNumerator(7): " + frac6 + " = " + frac6.getFloat() + " (кэш сброшен)");

    // 5. Изменение знаменателя и сброс кэша
    System.out.println("\n5. Изменение знаменателя:");
    Fraction frac7 = new Fraction(3, 5);
    System.out.println("   Исходная дробь: " + frac7 + " = " + frac7.getFloat());
    frac7.setDenominator(10);
    System.out.println("   После setDenominator(10): " + frac7 + " = " + frac7.getFloat() + " (кэш сброшен)");

    // 6. Сравнение дробей
    System.out.println("\n6. Сравнение дробей:");
    Fraction frac8 = new Fraction(2, 4);
    Fraction frac9 = new Fraction(1, 2);
    Fraction frac10 = new Fraction(2, 4);
    System.out.println("   Дробь 2/4: " + frac8);
    System.out.println("   Дробь 1/2: " + frac9);
    System.out.println("   Дробь 2/4: " + frac10);
    System.out.println("   2/4 equals 1/2: " + frac8.equals(frac9));
    System.out.println("   2/4 equals 2/4: " + frac8.equals(frac10));

  }

  private void autoInput2() {
    System.out.println("Количество мяуканий.\n" +
            "Необходимо воспользоваться классом Кот и методом принимающим всех мяукающих из задачи 2.5.4.\n" +
            "Необходимо таким образом передать кота в указанный метод, что бы после окончания его работы\n" +
            "узнать сколько раз мяукал кот за время его работы. На рисунке показан пример работы. Перед вызовом\n" +
            "метода создаем кота, отправляем ссылку на кота в метод, после окончания его работы выводим\n" +
            "количество мяуканий на экран. Кота изменять нельзя.\n" +
            "Если раннее в вашем варианте не было Кота, то создайте\n" +
            "1. сущность Кот, которая описывается следующим образом:\n" +
            "• Имеет Имя (строка)\n" +
            "• Для создания необходимо указать имя кота.\n" +
            "• Может быть приведен к текстовой форме вида: “кот: Имя”\n" +
            "• Может помяукать, что приводит к выводу на экран следующего текста: “Имя: мяу!”,\n" +
            "вызвать мяуканье можно без параметров.\n" +
            "2. интерфейс Мяуканье: разработайте метод, который принимает набор объектов способных\n" +
            "мяукать и вызывает мяуканье у каждого объекта. Мяукающие объекты должны иметь метод со\n" +
            "следующей сигнатурой:\n" +
            "public void meow();");
    Cat cat = new Cat("Мурзик");
    MeowCounter counter = new MeowCounter(cat);

    Funs.meowsCare(counter);

    System.out.println("кот мяукал " + counter.getMeowCount() + " раз");
  }

    private void autoInput3() {
        System.out.println("Составить программу, которая формирует список L, включив в него по одному разу элементы, которые входят одновременно в оба списка L1 и L2.");

        // 1. Демонстрация с целыми числами
        System.out.println("\n1. Работа с целыми числами:");
        ListIntersection<Integer> listIntersection1 = new ListIntersection<>();

        // Заполняем список L1
        listIntersection1.addToL1(1);
        listIntersection1.addToL1(2);
        listIntersection1.addToL1(3);
        listIntersection1.addToL1(4);
        listIntersection1.addToL1(5);

        // Заполняем список L2
        listIntersection1.addToL2(3);
        listIntersection1.addToL2(4);
        listIntersection1.addToL2(5);
        listIntersection1.addToL2(6);
        listIntersection1.addToL2(7);

        System.out.println("   Список L1: " + listIntersection1.getL1());
        System.out.println("   Список L2: " + listIntersection1.getL2());

        List<Integer> intersection1 = listIntersection1.getIntersection();
        System.out.println("   Пересечение L1 ∩ L2: " + intersection1);
        System.out.println("   Объяснение: общие элементы в обоих списках: 3, 4, 5");

        // 2. Демонстрация со строками (с дубликатами)
        System.out.println("\n2. Работа со строками (с дубликатами):");
        ListIntersection<String> listIntersection2 = new ListIntersection<>();

        listIntersection2.addToL1("apple");
        listIntersection2.addToL1("banana");
        listIntersection2.addToL1("apple"); // дубликат
        listIntersection2.addToL1("orange");
        listIntersection2.addToL1("grape");
        listIntersection2.addToL1("banana"); // дубликат

        listIntersection2.addToL2("banana");
        listIntersection2.addToL2("orange");
        listIntersection2.addToL2("kiwi");
        listIntersection2.addToL2("banana"); // дубликат
        listIntersection2.addToL2("melon");

        System.out.println("   Список L1: " + listIntersection2.getL1());
        System.out.println("   Список L2: " + listIntersection2.getL2());

        List<String> intersection2 = listIntersection2.getIntersection();
        System.out.println("   Пересечение L1 ∩ L2: " + intersection2);
        System.out.println("   Объяснение: 'banana' и 'orange' есть в обоих списках (дубликаты игнорируются)");

        // 3. Демонстрация без общих элементов
        System.out.println("\n3. Пример без общих элементов:");
        ListIntersection<String> listIntersection3 = new ListIntersection<>();

        listIntersection3.addToL1("cat");
        listIntersection3.addToL1("dog");
        listIntersection3.addToL1("rabbit");

        listIntersection3.addToL2("elephant");
        listIntersection3.addToL2("giraffe");
        listIntersection3.addToL2("lion");

        System.out.println("   Список L1: " + listIntersection3.getL1());
        System.out.println("   Список L2: " + listIntersection3.getL2());

        List<String> intersection3 = listIntersection3.getIntersection();
        System.out.println("   Пересечение L1 ∩ L2: " + intersection3);
        System.out.println("   Объяснение: нет общих элементов - пересечение пустое");

        // 4. Демонстрация с полным совпадением
        System.out.println("\n4. Пример с полным совпадением списков:");
        ListIntersection<Integer> listIntersection4 = new ListIntersection<>();

        List<Integer> identicalList = Arrays.asList(10, 20, 30, 40);
        listIntersection4.setL1(identicalList);
        listIntersection4.setL2(new ArrayList<>(identicalList));

        System.out.println("   Список L1: " + listIntersection4.getL1());
        System.out.println("   Список L2: " + listIntersection4.getL2());

        List<Integer> intersection4 = listIntersection4.getIntersection();
        System.out.println("   Пересечение L1 ∩ L2: " + intersection4);
        System.out.println("   Объяснение: списки идентичны, поэтому пересечение = весь список");

        // 5. Демонстрация с одним пустым списком
        System.out.println("\n5. Пример с пустым списком L2:");
        ListIntersection<String> listIntersection5 = new ListIntersection<>();

        listIntersection5.addToL1("red");
        listIntersection5.addToL1("green");
        listIntersection5.addToL1("blue");

        System.out.println("   Список L1: " + listIntersection5.getL1());
        System.out.println("   Список L2: " + listIntersection5.getL2() + " (пустой)");

        List<String> intersection5 = listIntersection5.getIntersection();
        System.out.println("   Пересечение L1 ∩ L2: " + intersection5);
        System.out.println("   Объяснение: пересечение с пустым множеством всегда пустое");
    }

    private void autoInput4() {
        System.out.println("Имеется список учеников разных школ, сдававших экзамен по информатике, с указанием их\n" +
                "фамилии, имени, школы и набранного балла. Напишите программу, которая будет определять\n" +
                "двух учеников школы № 50, которые лучше всех сдали информатику, и выводить на экран их\n" +
                "фамилии и имена.\n" +
                "Если наибольший балл набрали более двух человек, нужно вывести только их количество. Если\n" +
                "наибольший балл набрал один человек, а следующий балл набрало несколько человек, нужно\n" +
                "вывести только фамилию и имя лучшего.\n" +
                "Известно, что информатику сдавали не менее 5 учеников школы № 50.\n" +
                "На вход программе в первой строке подается количество учеников списке N. В каждой из\n" +
                "последующих N строк находится информация в следующем формате:\n" +
                "<Фамилия><Имя><Школа><Балл>\n" +
                "где <Фамилия> – строка, состоящая не более, чем из 20 символов без пробелов, <Имя>– строка,\n" +
                "состоящая не более, чем из 20 символов без пробелов, <Школа> – целое число от 1 до 99, <Балл> –\n" +
                "целое число от 1 до 100.\n" +
                "Пример входной строки:\n" +
                "Иванов Сергей 50 87");

        System.out.println("\n=== Тест 1: Два лучших ученика ===");
        List<String> test1Data = Arrays.asList(
                "Иванов Сергей 50 95",
                "Петров Иван 50 95",
                "Сидоров Алексей 50 90",
                "Кузнецов Михаил 50 85",
                "Смирнов Дмитрий 50 80",
                "Васильев Андрей 49 100"
        );

        processTestData(test1Data);

        System.out.println("\n=== Тест 2: Более двух с максимальным баллом ===");
        List<String> test2Data = Arrays.asList(
                "Иванов Сергей 50 100",
                "Петров Иван 50 100",
                "Сидоров Алексей 50 100",
                "Кузнецов Михаил 50 95",
                "Смирнов Дмитрий 50 90",
                "Васильев Андрей 50 85"
        );

        processTestData(test2Data);

        System.out.println("\n=== Тест 3: Один лучший, несколько со вторым баллом ===");
        List<String> test3Data = Arrays.asList(
                "Иванов Сергей 50 100",
                "Петров Иван 50 95",
                "Сидоров Алексей 50 95",
                "Кузнецов Михаил 50 95",
                "Смирнов Дмитрий 50 90",
                "Васильев Андрей 50 85"
        );

        processTestData(test3Data);

        System.out.println("\n=== Тест 4: Пример из условия ===");
        List<String> test4Data = Arrays.asList(
                "Иванов Сергей 50 87",
                "Петров Иван 50 92",
                "Сидоров Алексей 50 92",
                "Кузнецов Михаил 50 78",
                "Смирнов Дмитрий 50 85",
                "Васильев Андрей 49 95"
        );

        processTestData(test4Data);
    }

    private void processTestData(List<String> studentData) {
        System.out.println("Входные данные:");
        for (String data : studentData) {
            System.out.println(data);
        }

        class Student {
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
        }

        List<Student> allStudents = new ArrayList<>();

        for (String line : studentData) {
            String[] parts = line.split(" ");
            if (parts.length == 4) {
                try {
                    String lastName = parts[0];
                    String firstName = parts[1];
                    int school = Integer.parseInt(parts[2]);
                    int score = Integer.parseInt(parts[3]);

                    allStudents.add(new Student(lastName, firstName, school, score));
                } catch (NumberFormatException e) {
                    // ignore
                }
            }
        }

        // Фильтруем учеников школы №50
        List<Student> school50Students = new ArrayList<>();
        for (Student s : allStudents) {
            if (s.school == 50) {
                school50Students.add(s);
            }
        }

        // Проверяем минимальное количество
        if (school50Students.size() < 5) {
            System.out.println("\nРезультат: Ошибка - менее 5 учеников школы №50");
            System.out.println("Найдено: " + school50Students.size());
            return;
        }

        // Сортируем по баллам (убывание)
        school50Students.sort((s1, s2) -> s2.score - s1.score);

        int maxScore = school50Students.get(0).score;

        // Считаем учеников с максимальным баллом
        int countMax = 0;
        for (Student s : school50Students) {
            if (s.score == maxScore) {
                countMax++;
            } else {
                break;
            }
        }

        System.out.print("\nРезультат: ");
        if (countMax > 2) {
            System.out.println(countMax);
        } else if (countMax == 2) {
            System.out.println();
            System.out.println(school50Students.get(0).lastName + " " + school50Students.get(0).firstName);
            System.out.println(school50Students.get(1).lastName + " " + school50Students.get(1).firstName);
        } else {
            System.out.println(school50Students.get(0).lastName + " " + school50Students.get(0).firstName);
        }
    }

    private void autoInput5() {
        System.out.println("Файл содержит текст на русском языке. Напечатать в алфавитном порядке все глухие\n" +
                "согласные буквы, которые входят в каждое нечетное слово.\n");

        FileRead analyzer = new FileRead();

        // Тестовые примеры

        System.out.println("=== Пример 1: Простой текст ===");
        String testText1 = "кот пёс мышь заяц волк";
        System.out.println("Текст: " + testText1);
        Set<Character> result1 = analyzer.analyzeText(testText1);
        System.out.print("Результат: ");
        analyzer.printResult(result1);

        System.out.println("\n=== Пример 2: Текст с разными словами ===");
        String testText2 = "парк такси школа книга фон пух";
        System.out.println("Текст: " + testText2);
        Set<Character> result2 = analyzer.analyzeText(testText2);
        System.out.print("Результат: ");
        analyzer.printResult(result2);

        System.out.println("\n=== Пример 3: Текст с общими согласными ===");
        String testText3 = "пакет такт пакт такт";
        System.out.println("Текст: " + testText3);
        Set<Character> result3 = analyzer.analyzeText(testText3);
        System.out.print("Результат: ");
        analyzer.printResult(result3);

        System.out.println("\n=== Пример 4: Длинный текст ===");
        String testText4 = "Солнце светит ярко, птицы поют весело. " +
                "Школьники читают книгу, учат правила. " +
                "Погода прекрасная сегодня!";
        System.out.println("Текст: " + testText4);
        Set<Character> result4 = analyzer.analyzeText(testText4);
        System.out.print("Результат: ");
        analyzer.printResult(result4);

        System.out.println("\n=== Пример 5: Текст без общих согласных ===");
        String testText5 = "парк дом окно река";
        System.out.println("Текст: " + testText5);
        Set<Character> result5 = analyzer.analyzeText(testText5);
        System.out.print("Результат: ");
        analyzer.printResult(result5);

        System.out.println("\n=== Объяснение работы ===");
        System.out.println("1. Слова нумеруются по порядку: 1, 2, 3, 4, ...");
        System.out.println("2. Берутся нечетные слова: 1, 3, 5, ...");
        System.out.println("3. Находятся глухие согласные в каждом нечетном слове");
        System.out.println("4. Ищутся согласные, которые есть в КАЖДОМ нечетном слове");
        System.out.println("5. Результат сортируется по алфавиту");
        System.out.println("6. Глухие согласные: п, ф, к, т, ш, с, х, ц, ч, щ");
    }

    private void autoInput6() {
        System.out.println("Проверить равенство участка очереди с i-го по j-й элемент (i < j).");

        System.out.println("\n=== Тест 1: Все элементы равны на участке ===");
        {
            Queue<Integer> queue1 = new ArrayDeque<>(Arrays.asList(5, 5, 5, 3, 2, 1));
            QueueEqualityChecker<Integer> checker1 = new QueueEqualityChecker<>(queue1);

            System.out.println("Очередь: " + queue1);
            System.out.println("Проверяем участок [0..2] (индексы 0, 1, 2)");
            boolean result1 = checker1.checkEquality(0, 2);
            System.out.println("Результат: " + (result1 ? "РАВНЫ" : "НЕ РАВНЫ"));
            System.out.println("Объяснение: элементы 5, 5, 5 все равны");
        }

        System.out.println("\n=== Тест 2: Элементы не равны на участке ===");
        {
            Queue<Integer> queue2 = new ArrayDeque<>(Arrays.asList(1, 2, 2, 2, 3, 3));
            QueueEqualityChecker<Integer> checker2 = new QueueEqualityChecker<>(queue2);

            System.out.println("Очередь: " + queue2);
            System.out.println("Проверяем участок [0..2] (индексы 0, 1, 2)");
            boolean result2 = checker2.checkEquality(0, 2);
            System.out.println("Результат: " + (result2 ? "РАВНЫ" : "НЕ РАВНЫ"));
            System.out.println("Объяснение: элементы 1, 2, 2 - не все равны");
        }

        System.out.println("\n=== Тест 3: Очередь со строками ===");
        {
            Queue<String> queue3 = new ArrayDeque<>(Arrays.asList("A", "A", "A", "B", "C", "C"));
            QueueEqualityChecker<String> checker3 = new QueueEqualityChecker<>(queue3);

            System.out.println("Очередь: " + queue3);
            System.out.println("Проверяем участок [0..2] (индексы 0, 1, 2)");
            boolean result3 = checker3.checkEquality(0, 2);
            System.out.println("Результат: " + (result3 ? "РАВНЫ" : "НЕ РАВНЫ"));

            System.out.println("Проверяем участок [4..5] (индексы 4, 5)");
            boolean result4 = checker3.checkEquality(4, 5);
            System.out.println("Результат: " + (result4 ? "РАВНЫ" : "НЕ РАВНЫ"));
        }

        System.out.println("\n=== Тест 4: Дополнительные проверки ===");
        {
            Queue<Integer> queue4 = new ArrayDeque<>(Arrays.asList(7, 7, 7, 7, 7));
            QueueEqualityChecker<Integer> checker4 = new QueueEqualityChecker<>(queue4);

            System.out.println("Очередь: " + queue4);
            System.out.println("Вся очередь состоит из одинаковых элементов?");
            boolean allEqual = checker4.isAllEqual();
            System.out.println("Результат: " + (allEqual ? "Да" : "Нет"));

            System.out.println("\nНаходим участки длины 3 с равными элементами:");
            List<Integer> segments = checker4.findEqualSegments(3);
            System.out.println("Начальные индексы: " + segments);
        }

        System.out.println("\n=== Тест 5: Граничные случаи ===");
        {
            Queue<Character> queue5 = new ArrayDeque<>(Arrays.asList('X', 'Y', 'Z'));
            QueueEqualityChecker<Character> checker5 = new QueueEqualityChecker<>(queue5);

            System.out.println("Очередь: " + queue5);
            System.out.println("Проверяем участок [1..2] (индексы 1, 2)");
            try {
                boolean result5 = checker5.checkEquality(1, 2);
                System.out.println("Результат: " + (result5 ? "РАВНЫ" : "НЕ РАВНЫ"));
                System.out.println("Объяснение: Y и Z - разные символы");
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        System.out.println("\n=== Алгоритм проверки ===");
        System.out.println("1. Преобразуем очередь в список для доступа по индексу");
        System.out.println("2. Берем элемент с индексом i как эталон");
        System.out.println("3. Сравниваем все элементы от i+1 до j с эталоном");
        System.out.println("4. Если все элементы равны - возвращаем true");
        System.out.println("5. Если хотя бы один отличается - возвращаем false");
        System.out.println("6. i должен быть меньше j");
    }

  private void autoInput71() {
    System.out.println("Необходимо написать стрим:\n" +
            "Дан набор объектов типа Point, необходимо взять все Point в разных координатах, убрать с\n" +
            "одинаковыми X,Y, отсортировать по X, отрицательные Y сделать положительными и собрать это\n" +
            "все в ломаную (объект типа Polyline)\n" +
            "Если раннее в вашем варианте не было задание с классом Point и Polyline, то написать их:\n" +
            "1. класс Point:\n" +
            "• Координата Х: число.\n" +
            "• Координата Y: число.\n" +
            "• Может возвращать текстовое представление вида “{X;Y}”.\n" +
            "2. класс Line (Линия), расположенная на двумерной плоскости, которая описывается:\n" +
            "• Координата начала: Точка\n" +
            "• Координата конца: Точка\n" +
            "• Может возвращать текстовое представление вида “Линия от {X1;Y1} до {X2;Y2}”\n" +
            "3. класс Polyline (Ломаная), которая будет представлять собой ломаную линию. Ломаная\n" +
            "линия представляет собой набор следующих характеристик:\n" +
            "• Имеет массив Точек, через которые линия проходит.\n" +
            "• Может быть приведена к строковой форме вида “Линия [Т1,T2,…,TN]”, где TN – это\n" +
            "результат приведения к строке Точки с номером N");
    Point[] points = {
            new Point(3, 4),
            new Point(1, 2),
            new Point(3, 4),
            new Point(5, -6),
            new Point(2, -3),
            new Point(1, 2),
            null,
            new Point(4, 7)
    };

    // Обрабатываем точки через стрим
    Polyline result = PolylineStream.processPointsDetailed(points);

    // Выводим результат
    System.out.println("Исходные точки: " + Arrays.toString(points));
    System.out.println("Результирующая ломаная: " + result);
  }

  private void autoInput72() {
    System.out.println("Дан текстовый файл со строками, содержащими имя человека и его номер в следующей форме:\n" +
            "Вася:5\n" +
            "Петя:3\n" +
            "Аня:5\n" +
            "Номера людей могут повторяться. У каких-то людей может не быть номера.\n" +
            "Необходимо написать стрим выполняющую следующее:\n" +
            "читаются все люди из файла, все имена приводится к нижнему регистру, но с первой буквой в\n" +
            "верхнем регистре, убираем из перечня всех людей без номеров, а имена оставшихся группируются\n" +
            "по их номеру:\n" +
            "[5:[Вася, Аня], 3:[Петя]]");
    try {
      Map<Integer, List<String>> result = PersonProcessor.processFile("students.txt");

      // Выводим результат
      System.out.println("Группировка по номерам:");
      result.forEach((number, names) -> {
        System.out.println(number + ": " + names);
      });

      // Или в формате как в задании:
      System.out.println("\nВ формате задания:");
      String formatted = result.entrySet().stream()
              .map(entry -> entry.getKey() + ":[" + String.join(", ", entry.getValue()) + "]")
              .collect(Collectors.joining(", "));
      System.out.println("[" + formatted + "]");

    } catch (IOException e) {
      System.out.println("Ошибка чтения файла: " + e.getMessage());
    }
  }
}
