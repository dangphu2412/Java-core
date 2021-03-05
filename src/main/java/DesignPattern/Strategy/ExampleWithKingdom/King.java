package DesignPattern.Strategy.ExampleWithKingdom;

import DesignPattern.Strategy.ExampleWithKingdom.Weapon.AxeBehavior;

public class King extends Character {
    King() {
        super(new AxeBehavior());
    }
}
