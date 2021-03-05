package DesignPattern.Strategy.ExampleWithDuck.QuackBehavior;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Can not quack");
    }
}
