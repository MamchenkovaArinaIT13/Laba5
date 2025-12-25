package ru.mamchekova.queue;

import java.util.*;

public class QueueEqualityChecker<T> {
    private Queue<T> queue;

    public QueueEqualityChecker() {
        this.queue = new ArrayDeque<>();
    }

    public QueueEqualityChecker(Queue<T> queue) {
        this.queue = new ArrayDeque<>(queue);
    }

    // Добавление элемента в очередь
    public void add(T element) {
        queue.add(element);
    }

    // Установка очереди
    public void setQueue(Queue<T> queue) {
        this.queue = new ArrayDeque<>(queue);
    }

    // Получение копии очереди
    public Queue<T> getQueue() {
        return new ArrayDeque<>(queue);
    }

    public boolean checkEquality(int i, int j) {
        if (i >= j) {
            throw new IllegalArgumentException("i должно быть меньше j");
        }

        if (j >= queue.size()) {
            throw new IndexOutOfBoundsException("j выходит за пределы очереди");
        }

        // Преобразуем очередь в список для удобства доступа
        List<T> list = new ArrayList<>(queue);

        // Получаем первый элемент на участке
        T firstElement = list.get(i);

        // Проверяем, что все элементы на участке равны первому
        for (int k = i + 1; k <= j; k++) {
            if (!Objects.equals(list.get(k), firstElement)) {
                return false;
            }
        }

        return true;
    }


    public boolean checkEqualityWithLength(int start, int length) {
        if (length <= 1) {
            return true; // Один элемент или меньше всегда "равны"
        }

        int end = start + length - 1;
        return checkEquality(start, end);
    }


    public List<Integer> findEqualSegments(int length) {
        List<Integer> result = new ArrayList<>();
        List<T> list = new ArrayList<>(queue);

        for (int i = 0; i <= list.size() - length; i++) {
            boolean isEqual = true;
            T firstElement = list.get(i);

            for (int j = 1; j < length; j++) {
                if (!Objects.equals(list.get(i + j), firstElement)) {
                    isEqual = false;
                    break;
                }
            }

            if (isEqual) {
                result.add(i);
            }
        }

        return result;
    }


    public boolean isAllEqual() {
        if (queue.isEmpty()) {
            return true; // Пустая очередь считается "равной"
        }

        Iterator<T> iterator = queue.iterator();
        T firstElement = iterator.next();

        while (iterator.hasNext()) {
            if (!Objects.equals(iterator.next(), firstElement)) {
                return false;
            }
        }

        return true;
    }

    // Вывод очереди
    public void printQueue() {
        if (queue.isEmpty()) {
            System.out.println("Очередь пуста");
            return;
        }

        System.out.println("Очередь (индексы 0.." + (queue.size()-1) + "):");
        int index = 0;
        for (T element : queue) {
            System.out.println("[" + index + "] = " + element);
            index++;
        }
    }

    @Override
    public String toString() {
        return "QueueEqualityChecker{queue=" + queue + "}";
    }
}
