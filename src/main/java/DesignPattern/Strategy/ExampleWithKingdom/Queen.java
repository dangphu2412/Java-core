package DesignPattern.Strategy.ExampleWithKingdom;

import DesignPattern.Strategy.ExampleWithKingdom.Weapon.KnifeBehavior;

public class Queen extends Character {
    Queen() {
        super(new KnifeBehavior());
    }
}
