package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Special character must be added dot front of them
Example: asterisk(*) will be like this: .*
Each dot will represent one char in string to be passed away
 */
public class RegexExample {
    public static void main(String[] args) {
        // 1st way
        Pattern p = Pattern.compile("[a-z]");
        Matcher m = p.matcher("as");
        boolean isMatched = m.find();
        System.out.println(isMatched);

        // 2st way
        boolean found = Pattern.compile(".*").matcher("fussiudeptrai*").find();
        System.out.println(found);

        // 3st way
        boolean checked = Pattern.matches("...i", "Ojli");
        System.out.println(checked);

        System.out.println("metacharacters d...."); //d means digit

        System.out.println(Pattern.matches("\\d", "abc"));//false (non-digit)
        System.out.println(Pattern.matches("\\d", "1"));//true (digit and comes once)
        System.out.println(Pattern.matches("\\d", "4443"));//false (digit but comes more than once)
        System.out.println(Pattern.matches("\\d", "323abc"));//false (digit and char)

        System.out.println("metacharacters D...."); //D means non-digit

        System.out.println(Pattern.matches("\\D", "abc"));//false (non-digit but comes more than once)
        System.out.println(Pattern.matches("\\D", "1"));//false (digit)
        System.out.println(Pattern.matches("\\D", "4443"));//false (digit)
        System.out.println(Pattern.matches("\\D", "323abc"));//false (digit and char)
        System.out.println(Pattern.matches("\\D", "m"));//true (non-digit and comes once)

        System.out.println("metacharacters D with quantifier....");
        System.out.println(Pattern.matches("\\D*", "mak"));//true (non-digit and may come 0 or more times)
    }
}
