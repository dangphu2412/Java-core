package Collection;

public class SimpleArray {
    public int[] getAnonymousArray() {
        return new int[]{1, 2, 3, 4, 5};
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4};
        int min = arr[0];

        for (int item : arr) {
            if (item < min) min = item;
        }
        System.out.println(min);

        /*
        Anonymous array
         */
    }
}
