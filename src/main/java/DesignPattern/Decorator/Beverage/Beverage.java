package DesignPattern.Decorator.Beverage;

public abstract class Beverage {
    String description;

    String getDescription() {
        return description;
    }

    abstract double cost();
}
