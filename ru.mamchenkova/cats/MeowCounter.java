package ru.mamchekova.cats;

public class MeowCounter implements Meowable {
  private final Cat cat;
  private int meowCount = 0;

  public MeowCounter() {
    this.cat = null;
  }

  public MeowCounter(Cat cat) {
    this.cat = cat;
  }

  @Override
  public void meow() {
    cat.meow();
    meowCount++;
  }

  public int getMeowCount() {
    return meowCount;
  }

  @Override
  public String toString() {
    return "Вы создани счетчик для мяуканий!";
  }
}
