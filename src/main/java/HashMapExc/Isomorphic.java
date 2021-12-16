package HashMapExc;

import java.util.HashMap;

/*
badc - baba

1: check length match
2: init store
3: get key by first char of s ->  null -> if t[i] in store values -> false
4:
 */

public class Isomorphic {
    static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Character> store = new HashMap<>();
        char[] values = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            Character currFirstChar = store.get(s.charAt(i));
            if (currFirstChar == null) {
                for (char value : values) {
                    if (value == t.charAt(i)) {
                        return false;
                    }
                }

                store.put(s.charAt(i), t.charAt(i));
                values[i] = t.charAt(i);
            } else if (currFirstChar != t.charAt(i)) return false;
        }
        store.clear();

        return true;
    }

    static boolean wordPattern(String pattern, String s) {
        if (s == null) return false;

        HashMap<String, Character> store = new HashMap<>();
        String[] seperated = s.split(" ");

        if (seperated.length != pattern.length()) return false;
        store.put(seperated[0], pattern.charAt(0));

        for (int i = 0; i < pattern.length(); i++) {
            for (int j = pattern.length() - 1; j > i; j--) {
                if (store.get(seperated[j]) == null) {
                    store.put(seperated[j], pattern.charAt(j));
                } else if (store.get(seperated[j]) != pattern.charAt(j)) return false;

                if ((pattern.charAt(i) == pattern.charAt(j)) && !(seperated[i].equals(seperated[j]))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(Isomorphic.isIsomorphic("badc", "baba"));
        System.out.println(Isomorphic.wordPattern("abc", "dog cat dog"));
    }
}
