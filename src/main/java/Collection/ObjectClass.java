package Collection;

import Oop.Abstraction.InheritanceAccessModifier;

public class ObjectClass {
    public static void main(String[] args) throws CloneNotSupportedException {
        InheritanceAccessModifier obj = new InheritanceAccessModifier();
        System.out.println(obj.hashCode());
        System.out.println(obj.toString());
        System.out.println(obj.getClass());

        /*
        Fast way to copy an object
         */
        InheritanceAccessModifier cloneObj = (InheritanceAccessModifier) obj.clone();


        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        System.out.println("After waiting");
    }
}
