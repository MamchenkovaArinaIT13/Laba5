package ru.mamchekova.cats;

public class Cat implements Meowable {
  private String name;
  
  public Cat() {
    this.name = null;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Cat(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "кот: " + this.name;
  }

  @Override
  public void meow() {
    System.out.println(this.name + ": мяу!");
  }



}
