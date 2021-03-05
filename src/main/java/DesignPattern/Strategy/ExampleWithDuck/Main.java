package DesignPattern.Strategy.ExampleWithDuck;

import DesignPattern.Strategy.ExampleWithDuck.FlyBehavior.FlyWithWings;

public class Main {
    public static void main(String[] args) {
        Duck woodenDuck = new WoodenDuck();

        woodenDuck.performFly();
        woodenDuck.performQuack();

        // Improve into fly with wings for wooden duck
        woodenDuck.setFlyBehavior(new FlyWithWings());
        woodenDuck.performFly();
    }
}
