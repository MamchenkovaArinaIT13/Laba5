package ru.mamchekova.stream;

import java.util.Arrays;

public class PolylineStream {
  public static Polyline processPointsDetailed(Point[] points) {
    if (points == null) {
      return new Polyline(new Point[0]);
    }

    Point[] processedPoints = Arrays.stream(points)
            // Шаг 1: Фильтруем null-точки
            .filter(point -> point != null)

            // Шаг 2: Убираем дубликаты (точки с одинаковыми X,Y)
            .distinct()

            // Шаг 3: Сортируем по координате X
            .sorted((p1, p2) -> Double.compare(p1.getX(), p2.getX()))

            // Шаг 4: Отрицательные Y делаем положительными
            .map(point -> {
              double x = point.getX();
              double y = point.getY();
              if (y < 0) {
                // Создаем новую точку с положительным Y
                return new Point(x, -y);
              }
              // Возвращаем оригинальную точку если Y уже положительный
              return point;
            })

            // Шаг 5: Собираем результат в массив
            .toArray(Point[]::new);

    return new Polyline(processedPoints);
  }
}
