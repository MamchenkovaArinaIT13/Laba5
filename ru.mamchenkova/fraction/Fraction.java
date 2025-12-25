package ru.mamchekova.fractions;

import java.util.Objects;

// Шаблон кэширования или ленивая инициализация
public class Fraction implements FractionInterface {
  private int numerator; // Числитель
  private int denominator; // Знаменатель
  private Float cachedFloatValue;

  public Fraction() {
    this.numerator = 0;
    this.denominator = 0;
    this.cachedFloatValue = null;
  }

  public Fraction(int numerator, int denominator) {
    if (denominator == 0) {
      throw new IllegalArgumentException("Знаменатель не может быть равен 0!");
    }
    if (denominator < 0) {
      this.numerator = -numerator;
      this.denominator = -denominator;
    } else {
      this.numerator = numerator;
      this.denominator = denominator;
    }
    this.cachedFloatValue = null;
  }

  public int getNumerator() {
    return numerator;
  }

  public int getDenominator() {
    return denominator;
  }

  @Override
  public float getFloat() {
    if (cachedFloatValue == null) {
      cachedFloatValue = (float) this.numerator / this.denominator;
    }
    return cachedFloatValue;
  }

  @Override
  public void setNumerator(int numerator) {
    if (this.numerator != numerator) {
      this.numerator = numerator;
      cachedFloatValue = null;
    }
  }

  @Override
  public void setDenominator(int denominator) {
    if (denominator == 0) {
      throw new IllegalArgumentException("Знаменатель не может быть равен 0!");
    }

    int newDenominator = denominator;
    int newNumerator = this.numerator;

    if (denominator < 0) {
      newNumerator = -this.numerator;
      newDenominator = -denominator;
    }

    if (this.denominator != newDenominator || this.numerator != newNumerator) {
      this.numerator = newNumerator;
      this.denominator = newDenominator;
      cachedFloatValue = null;
    }
  }

  @Override
  public String toString() {
    return this.numerator + "/" + this.denominator;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Fraction fraction = (Fraction) o;
    return numerator == fraction.numerator && denominator == fraction.denominator;
  }

  @Override
  public int hashCode() {
    return Objects.hash(numerator, denominator);
  }
}
