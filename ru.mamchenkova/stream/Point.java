package ru.mamchekova.stream;

import java.util.Objects;

public class Point {
  // Поля
  private double x;
  private double y;

  //Геттеры и сеттеры
  public double getX() {
    return this.x;
  }

  public double getY() {
    return this.y;
  }

  public void setX(double x) {
    this.x = x;
  }

  public void setY(double y) {
    this.y = y;
  }

  //Конструкторы
  public Point() {
    this.x = 0.0;
    this.y = 0.0;
  }

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  //Метод toString
  @Override
  public String toString() {
    return "{" + this.x + ";" + this.y + "}";
  }

  // Переопределяем методы

  // Метод equals для сравнения точек по координатам
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true; // одна и та же ссылка
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false; // проверка класса
    }
    Point other = (Point) obj; // приведение типа
    return Double.compare(this.x, other.x) == 0 &&
            Double.compare(this.y, other.y) == 0;
  }
  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}
