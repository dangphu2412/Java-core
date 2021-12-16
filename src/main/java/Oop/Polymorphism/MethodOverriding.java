package Oop.Polymorphism;

/*
This class consist of method overloading, overriding, covariant return type, super, Instance initializer block
 */

class ParentCovariant {
    ParentCovariant() {
        System.out.println("Constructor Parent call");
    }

    /*
    Block static will be called first
    Then normal block will be called
    and the next is constructor
     */
    static {
        System.out.println("Block static  called");
    }

    {
        System.out.println("Normal Block called");
    }
}

class SubCovariant extends ParentCovariant {
}

class Human {
    /*
    Final var can be assigned in constructor, initialize block relate to its own scope (static or not)
     */
    final String var;
    boolean gender = false;

    /*
    Constructor cannot be final
     */
    Human() {
        /*var = "Oh shit final variable can be assigned in constructor";*/
        System.out.println("Constructor of Human called");
    }

    {
        var = "Oh shit final variable can be assigned in constructor";
    }

    static void sleep() {
        System.out.println("Human is sleeping");
    }

    void talk() {
        System.out.println("Im a human");
    }

    ParentCovariant testCovariantReturnType() {
        return new ParentCovariant();
    }

    /*
    Final method, var are both inheritance but cannot override or assign value as it been final
     */
    final void changeGender() {
        gender = !gender;
        System.out.println("Gender now is" + (gender ? "man" : "woman"));
    }
}

class Man extends Human {
    boolean gender = true;

    Man() {
        /*
        Super must be called first
        Next is instance initializer block
         */
        super();
        System.out.println("Constructor of Man called");
    }

    static {
        System.out.println("Initialize block called after super");
    }

    static void sleep() {
        System.out.println("Man is sleeping");
    }

    static void method(Human human) {
        if (human instanceof Man) {
            Man man = (Man) human;
            System.out.println("Down casting success");
        }
    }

    // Cannot override it because of final keyword
/*     void changeGender() {
        gender = !gender;
        System.out.println("Gender now is" + (gender ? "man" : "woman"));
    }*/

    void talk() {
        super.talk();
        System.out.println("Im a man");
    }

    // Overloading return type on overriding method
    SubCovariant testCovariantReturnType() {
        return new SubCovariant();
    }
}

public class MethodOverriding {
    public static void main(String[] args) {
        /*
         When compile will be Human
         Runtime will call talk of Man

         talk of Man will be called first then talk of Human will be invoked by calling super keyword
        */
        Human human = new Man();
        human.talk();
        human.testCovariantReturnType();
        /*
        Change gender will invoke gender variable of parent class
         */
        human.changeGender();
        /*
        Each static method will belong to it own class so it won t be override when inheritance
         */
        Human.sleep();
        Man.sleep();

        Human human1 = new Man();
        Man.method(human1);
    }
}
