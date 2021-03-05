package SerializeExample;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Reader {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Human humanSerialized = new Human();

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\ACER\\Desktop\\test.txt");

        ObjectInputStream ois = new ObjectInputStream(fileInputStream);

        humanSerialized = (Human) ois.readObject();

        ois.close();

        System.out.println(humanSerialized.getName());
    }
}
