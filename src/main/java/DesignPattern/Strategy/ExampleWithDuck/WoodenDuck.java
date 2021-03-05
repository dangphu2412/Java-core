package DesignPattern.Strategy.ExampleWithDuck;

import DesignPattern.Strategy.ExampleWithDuck.FlyBehavior.FlyNoWay;
import DesignPattern.Strategy.ExampleWithDuck.QuackBehavior.MuteQuack;

public class WoodenDuck extends Duck {
    WoodenDuck() {
        super(new FlyNoWay(), new MuteQuack());
    }
}
