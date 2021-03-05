package String;

import java.util.StringTokenizer;

public class StringExample {
    protected static void checkPalindrome(String input) {
        boolean isPalindrome = true;
        boolean isOdd = (input.length() % 2) > 0;
        for (int i = 0; i < input.length() / 2 - 1; i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                isPalindrome = false;
                break;
            }
        }

        if (!isOdd) {
            if (input.charAt(input.length() / 2 - 1) != input.charAt(input.length() / 2)) {
                isPalindrome = false;
            }
        }

        System.out.println("This string " + input + (isPalindrome ? " a palindrome" : " not a palindrome"));
    }
    public static void main(String[] args) {
        String a = "String Pool";

        String b = "String Pool";
        String notRefA = new String("String pool");
        String refA = notRefA.intern();

        System.out.println(a.equals(b));
        System.out.println(a.equalsIgnoreCase(b));

        System.out.println(a == notRefA);
        System.out.println(a == refA);


        String inPool = "abc";
        /*
        Java compiler is smart enough so it will combine into abcd
        like this: (new StringBuilder()).append("abc").append("d).toString();
         */
        String inPoolWithdChar = "abc" + "d";
        String createNewObjInHeapByConcatUsingStringBuilder = inPoolWithdChar + "e";

        /*
        Also concat primitive value
         */
        String s=50+30+"Sachin"+true+12L;
        System.out.println(s);//80Sachin4040

        // Return abc
        String checkRefToPool = inPoolWithdChar.substring(0, 3);
        System.out.println(checkRefToPool);

        // But here false why
        System.out.println(checkRefToPool == inPool);

        String v1 = new String(" Chuahe");
        String v2 = v1.intern();
        String v3 = v1.intern();

        v1 = v1.trim();
        v2 += " Fus";

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

        StringTokenizer st = new StringTokenizer("my name is fus","/+");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        StringTokenizer st1 = new StringTokenizer("my,name,is,khan");

        // printing next token
        System.out.println("Next token is : " + st1.nextToken(","));

        /*
        Two way to reverse string
         */
        StringBuilder x = new StringBuilder("fus dep trai");
        System.out.println(x.reverse().toString());
        char[] x1 = new String("fus dep trai").toCharArray();
        for (int i = 0; i < x1.length / 2; i++) {
            char t = x1[i];
            x1[i] = x1[x1.length - i - 1];
            x1[x1.length - i - 1] = t;
        }

        System.out.println(new String(x1));

        /*
        Palindrome: chuoi doi xung
         */
        StringExample.checkPalindrome("akaka");
        StringExample.checkPalindrome("Fusngu");
        StringExample.checkPalindrome("asdasddsadsd");
        StringExample.checkPalindrome("asddsa");
    }
}