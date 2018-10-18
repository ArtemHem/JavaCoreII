package ru.sidorenko.jc.levelI;

import java.util.ArrayList;
import java.util.List;

public class FruitBox<T extends Fruit> {
    private T fruit;
    private List<T> boxFruits = new ArrayList<>();
    private int count = 0;
    private float sum = 0;
    private float weightBox;

    FruitBox(T fruit) {
        this.fruit = fruit;
        addFruit(fruit);
    }

    void addFruit(T fruit){
        boxFruits.add(fruit);
        count++;
        float weightFruit = fruit.getWeight();
        sum += weightFruit;
    }

    float getWeightBox(){
        weightBox = sum*count;
        return weightBox;
    }

    void compareBox(FruitBox<?> secBox){
        float firstBox = weightBox;
        float secondBox = secBox.getWeightBox();
        if (firstBox == secondBox) {
            System.out.println(true);
            return;
        }
        System.out.println(false);
    }

    void goNewBox(FruitBox<T> secBox){
        for (T x : secBox.boxFruits){
            addFruit(x);
        }
        secBox.clearBox();
    }

    void clearBox(){
        boxFruits.clear();
        count = 0;
        sum = 0;
    }

    List<T> getBoxFruits() {
        return boxFruits;
    }

    void getParam(){
        System.out.println(count + " " + sum);
    }
}
