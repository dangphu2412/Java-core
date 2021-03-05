package Oop.Polymorphism;

public class MethodOverloading {
    // int, float, long have relationship with each other but when call func it will auto move to matching type
    public int sum(int a, int b) {
        return a + b;
    }

    public double sum(double a, double b) {
        return a + b;
    }

    public long sum(long a, long b) {
        return a + b;
    }

    public float sum(float a, float b) {
        return a + b;
    }

    // JVM will this main auto
    public static void main(String[] args) {
        // Because the operand of short plus twice will greater than the range of short so it will
        // go next to integer
        short a = 1, b = 2;
        int result = a + b;
        System.out.println("With array args");
    }

    public static void main(String args) {
        System.out.println("With single arg");
    }

    public static void main() {
        System.out.println("Without any args");
    }
}
