package DesignPattern.Strategy.ExampleWithKingdom;

import DesignPattern.Strategy.ExampleWithKingdom.Weapon.WeaponBehavior;

public abstract class Character {
    WeaponBehavior weaponBehavior;

    Character(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }

    Character() {
    }

    public void fight() {
        weaponBehavior.useWeapon();
    }

    public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }
}
