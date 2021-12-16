package InnerClass;

abstract class SomeAnonymousClass {
    abstract void msg();
}

public class OuterClass {
    private int data = 30;

    class Inner {
        void msg() {
            System.out.println("data is " + data);
        }
    }

    public static void main(String args[]) {
        OuterClass obj = new OuterClass();
        OuterClass.Inner in = obj.new Inner();
        in.msg();

        // Anonymous class
        SomeAnonymousClass ano = new SomeAnonymousClass() {
            @Override
            void msg() {
                System.out.println("This is anonymous class");
            }
        };

        ano.msg();

        // Inner class
        class SomeAnonymousImpl extends SomeAnonymousClass {
            @Override
            void msg() {
                System.out.println("Inner class");
            }
        }

        SomeAnonymousClass inner = new SomeAnonymousImpl();
        inner.msg();
    }
}
