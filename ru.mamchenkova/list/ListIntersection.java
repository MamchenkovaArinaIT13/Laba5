package ru.mamchekova.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListIntersection<T> {
    private List<T> L1;
    private List<T> L2;
    private List<T> L;

    public ListIntersection(List<T> L1, List<T> L2) {
        this.L1 = new ArrayList<>(L1);
        this.L2 = new ArrayList<>(L2);
        this.L = new ArrayList<>();
        this.calculateIntersection();
    }

    public ListIntersection() {
        L1 = new ArrayList<>();
        L2 = new ArrayList<>();
        L = new ArrayList<>();
    }

    // Метод для вычисления пересечения двух списков
    private void calculateIntersection() {
        L.clear();
        Set<T> setL1 = new HashSet<>(L1);

        for (T element : L2) {
            if (setL1.contains(element) && !L.contains(element)) {
                L.add(element);
            }
        }
    }

    // Метод для получения результата (пересечения)
    public List<T> getIntersection() {
        return new ArrayList<>(L);
    }

    // Метод для обновления списков и пересчета пересечения
    public void updateLists(List<T> newL1, List<T> newL2) {
        this.L1 = new ArrayList<>(newL1);
        this.L2 = new ArrayList<>(newL2);
        calculateIntersection();
    }

    // Метод для добавления элемента в L1
    public void addToL1(T element) {
        L1.add(element);
        calculateIntersection();
    }

    // Метод для добавления элемента в L2
    public void addToL2(T element) {
        L2.add(element);
        calculateIntersection();
    }

    // Метод для удаления элемента из L1
    public boolean removeFromL1(T element) {
        boolean removed = L1.remove(element);
        if (removed) {
            calculateIntersection();
        }
        return removed;
    }

    // Метод для удаления элемента из L2
    public boolean removeFromL2(T element) {
        boolean removed = L2.remove(element);
        if (removed) {
            calculateIntersection();
        }
        return removed;
    }

    // Геттеры
    public List<T> getL1() {
        return new ArrayList<>(L1);
    }

    public List<T> getL2() {
        return new ArrayList<>(L2);
    }

    public List<T> getL() {
        return new ArrayList<>(L);
    }

    // Сеттеры
    public void setL1(List<T> l1) {
        this.L1 = new ArrayList<>(l1);
        calculateIntersection();
    }

    public void setL2(List<T> l2) {
        this.L2 = new ArrayList<>(l2);
        calculateIntersection();
    }

    // Вспомогательные методы для вывода
    public void printL1() {
        if (L1.isEmpty()) {
            System.out.println("Список L1 пуст!");
        } else {
            System.out.println("Элементы списка L1:");
            for (T element : L1) {
                System.out.println(element);
            }
        }
    }

    public void printL2() {
        if (L2.isEmpty()) {
            System.out.println("Список L2 пуст!");
        } else {
            System.out.println("Элементы списка L2:");
            for (T element : L2) {
                System.out.println(element);
            }
        }
    }

    public void printIntersection() {
        if (L.isEmpty()) {
            System.out.println("Пересечение пусто!");
        } else {
            System.out.println("Элементы пересечения (список L):");
            for (T element : L) {
                System.out.println(element);
            }
        }
    }

    @Override
    public String toString() {
        return "ListIntersection{" +
                "L1=" + L1 +
                ", L2=" + L2 +
                ", L(пересечение)=" + L +
                '}';
    }

    // Дополнительный метод для проверки, содержится ли элемент в пересечении
    public boolean isInIntersection(T element) {
        return L.contains(element);
    }

    // Метод для очистки всех списков
    public void clearAll() {
        L1.clear();
        L2.clear();
        L.clear();
    }

    // Метод для получения размера пересечения
    public int intersectionSize() {
        return L.size();
    }
}
