package DesignPattern.Singleton;

// Each class responsibility for their functional
public class Main {
    public static void main(String[] args) {
        User user = new User("fus", 12);
        Store store = new Store();
        StringFormatter stringFormatter = new StringFormatter();

        user.setUsername(
                stringFormatter.clearSpecialChar(user.getUsername())
        );

        System.out.println(stringFormatter.toStringAllFields(user));

        store.storeToMemory(user);
    }
}
