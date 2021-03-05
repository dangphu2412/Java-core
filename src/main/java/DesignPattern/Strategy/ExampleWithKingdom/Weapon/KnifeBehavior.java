package DesignPattern.Strategy.ExampleWithKingdom.Weapon;

public class KnifeBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("Using knife");
    }
}
