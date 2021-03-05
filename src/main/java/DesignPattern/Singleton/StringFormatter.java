package DesignPattern.Singleton;

public class StringFormatter {
    public String toStringAllFields(Object o) {
        return o.toString();
    }

    public String clearSpecialChar(String s) {
        return s.replaceAll("[^\\w\\d]", "");
    }
}
