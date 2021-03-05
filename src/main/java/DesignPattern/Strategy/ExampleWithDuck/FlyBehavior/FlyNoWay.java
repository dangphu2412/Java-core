package DesignPattern.Strategy.ExampleWithDuck.FlyBehavior;

public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("Can not fly");
    }
}
