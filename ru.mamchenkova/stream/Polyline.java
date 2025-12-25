package ru.mamchekova.stream;

public class Polyline {
  private Point[] points;

  public Polyline() {
    this.points = new Point[0];
  }

  public Polyline(Point[] points) {
    if (points != null) {
      this.points = points;
    } else {
      this.points = new Point[0];
    }
  }

  public Point[] getPoints() {
    return points;
  }

  public void setPoints(Point[] points) {
    if (points != null) {
      this.points = points;
    } else {
      this.points = new Point[0];
    }
  }

  @Override
  public String toString() {
    if (points == null || points.length == 0) {
      return "Линия []";
    }

    StringBuilder sb = new StringBuilder("Линия [");
    for (int i = 0; i < points.length; i++) {
      sb.append(points[i]);
      if (i < points.length - 1) {
        sb.append(",");
      }
    }
    sb.append("]");
    return sb.toString();
  }
}
