package Oop.Encapsulation;

import Oop.Abstraction.Shape;

public class AccessModifier {
    /*
    Protected field only access in the same package
     */
    protected String accessDataMemberProtected = "Hello";

    protected void tryToAccessProtectedField() {
        System.out.println("Access protected field");
    }
}

class AccessProtected {
    public static void main(String[] args) {
        /*
        Cannot access default modifier of class Rectangle of package Shape
         */
        /*        Shape shape = new Rectangle();*/

        AccessModifier accessModifier = new AccessModifier();
        System.out.println(accessModifier.accessDataMemberProtected);
        accessModifier.tryToAccessProtectedField();
    }
}
