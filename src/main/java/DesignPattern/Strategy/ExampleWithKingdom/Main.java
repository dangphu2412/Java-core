package DesignPattern.Strategy.ExampleWithKingdom;

public class Main {
    public static void main(String[] args) {
        Character king = new King();
        king.fight();

        Character queen = new Queen();
        queen.fight();
    }
}
