package ru.sidorenko.jc.levelI;

public class MainI {
    public static void main(String[] args) {
        Orange orange = new Orange();
        Orange orange1 = new Orange();
        FruitBox<Orange> orangeFruitBox = new FruitBox<>(orange);
        orangeFruitBox.addFruit(orange1);

        Apple apple = new Apple();
        Apple apple1 = new Apple();
        FruitBox<Apple> appleFruitBox = new FruitBox<>(apple);
        appleFruitBox.addFruit(apple1);
        FruitBox<Apple> appleFruitBox1 = new FruitBox<>(apple);
        appleFruitBox1.addFruit(apple1);

        float a = appleFruitBox.getWeightBox();
        float b = appleFruitBox1.getWeightBox();
        System.out.println("Вес первой коробки - " + a);
        System.out.println("Вес второй коробки - " + b);

        System.out.print("Коробки равны: ");
        appleFruitBox.compareBox(appleFruitBox1);

        System.out.println("Перемещыем фрукты из одной коробки в другую...");
        appleFruitBox.goNewBox(appleFruitBox1);

        a = appleFruitBox.getWeightBox();
        b = appleFruitBox1.getWeightBox();
        System.out.print("Коробки равны: ");
        appleFruitBox.compareBox(appleFruitBox1);

        System.out.println("Вес первой коробки - " + a);
        System.out.println("Вес второй коробки - " + b);
    }
}
