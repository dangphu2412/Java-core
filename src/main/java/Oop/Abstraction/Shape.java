package Oop.Abstraction;

import Oop.Encapsulation.AccessModifier;

interface ShapeAction {
    void clear();
    /*
    Java 8 support default method
     */
    default Integer calcArea() {
        return 0;
    }

    static void bark() {
        System.out.println("gau gau");
    }
}

public abstract class Shape implements ShapeAction {
    protected String UUIDModifier = "Access me when inheritance";

    Shape() {
        System.out.println("Calling constructor of abstract class");
    }
    abstract void draw();

    /*
    clear method has been initialized in shape
     */
    public void clear() {
        System.out.println("Clearing all " + this.getClass());
    }
}

class Rectangle extends Shape {
    Integer width;
    Integer height;

    Rectangle(Integer height, Integer width) {
        this.height = height;
        this.width = width;
    }

    @Override
    void draw() {
        System.out.println("Drawing rectangle");
    }

    @Override
    public Integer calcArea() {
        return this.height * this.width;
    }
}

class Square extends Shape {
    Integer edge;

    Square(Integer edge) {
        this.edge = edge;
    }

    @Override
    void draw() {
        System.out.println("Drawing square");
    }

    @Override
    public Integer calcArea() {
        return this.edge * this.edge;
    }
}

class Main {
    public static void main(String[] args) {
        Shape shape = new Rectangle(10, 2);
        Shape shape1 = new Square(5);

        shape.draw();
        shape1.draw();

        System.out.println("Accessing protected field via child class" + shape.UUIDModifier);

        /*
        Access outside from package Encapsulation cannot access protected field
         */
        AccessModifier accessModifier = new AccessModifier();
        InheritanceAccessModifier inheritanceOfProtected = new InheritanceAccessModifier();
        inheritanceOfProtected.accessToBaseProtectedMethod();

        shape.clear();
        ShapeAction.bark();
        System.out.println("Rectangle area: " + shape.calcArea());
    }
}
