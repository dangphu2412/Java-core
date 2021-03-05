package Oop.Abstraction;

import Oop.Encapsulation.AccessModifier;

public class InheritanceAccessModifier extends AccessModifier implements Cloneable {
    public void accessToBaseProtectedMethod() {
        /*
        Can access protected field in this class inheritance only
        Can not call when class is being access
         */
        this.tryToAccessProtectedField();
    }

    public void tryToAccessProtectedField() {
        super.tryToAccessProtectedField();
        System.out.println("Protected method has been override");
    }

    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }
}
