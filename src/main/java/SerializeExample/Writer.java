package SerializeExample;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Writer {
    public static void main(String[] args) throws IOException {
        Human humanSerialized = new Human("Hello");

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\ACER\\Desktop\\test.txt");

        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);

        oos.writeObject(humanSerialized);
        oos.close();
        System.out.println("Write success");
    }
}
