package com.java_8_training.problems.lambdas;


import com.java_8_training.problems.lambdas.model.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;

public class LambdasRefactor {
    public static void main(String[] args) {
        System.out.println(sortInventoryByDecreasingWeight());
        System.out.println(filterGreenApples());
    }

    public static List<Apple> sortInventoryByDecreasingWeight() {
        //TODO: refactor to use lambda expression

        List<Apple> inventory = asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));
        inventory.sort((apple1,apple2) ->apple2.getWeight().compareTo(apple1.getWeight()));
//        {
//            @Override
//            public int compare(Apple apple1, Apple apple2) {
//                return apple2.getWeight().compareTo(apple1.getWeight());
//            }
//        });
        return inventory;
    }

    public static List<Apple> filterGreenApples() {

        // TODO: refactor to use lambda expression

        // TODO: refactor to use standard functional interface

        List<Apple> inventory = asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));

//        List<Apple> result = new ArrayList<>();
//        for (Apple apple : inventory) {
//            if (apple.test(apple)) {
//                result.add(apple);
//            }
//        }
        String destColor = "green";
        List<Apple> greenApples2 = filterApples(inventory,  a->a.getColor().equals(destColor));



        List<Apple> greenApples = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "green".equals(apple.getColor());
            }
        });

        return inventory;

    }

    private static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    interface ApplePredicate {
        boolean test(Apple apple);
    }
}
