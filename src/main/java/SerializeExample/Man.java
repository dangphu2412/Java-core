package SerializeExample;

public class Man {
    // This will run before everything
    static {
        System.out.println("This is a static shit");
        System.exit(1);
    }

    Man() {
        super();
    }

    void hello() {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        Man man = new Man();
        man.hello();
    }
}
