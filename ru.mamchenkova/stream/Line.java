package ru.mamchekova.stream;

public class Line {
  private Point firstPoint;
  private Point endPoint;

  public Line() {
    this.firstPoint = new Point();
    this.endPoint = new Point();
  }

  public Line(Point firstPoint, Point endPoint) {
    this.firstPoint = firstPoint;
    this.endPoint = endPoint;
  }

  public Point getFirstPoint() {
    return this.firstPoint;
  }

  public Point getEndPoint() {
    return this.endPoint;
  }

  public void setFirstPoint(Point firstPoint) {
    this.firstPoint = firstPoint;
  }

  public void setEndPoint(Point endPoint) {
    this.endPoint = endPoint;
  }

  @Override
  public String toString() {
    return "Линия от " + firstPoint + " до " + endPoint;
  }

}
