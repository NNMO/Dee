package inputAnalysis.textAnalysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IsQuestion {
    private static final String[] SET_VALUES = new String[]{"who", "where", "when", "why", "what", "which", "how", "is"};
    private static final Set<String> MY_SET = new HashSet<String>(Arrays.asList(SET_VALUES));

    public static boolean check(ArrayList<String> l, String s) {
        return questionMark(s) || startsWith(s);
    }

    private static boolean questionMark(String s) {
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) == '?')
                return true;
        }
        return false;
    }

    private static boolean startsWith(String s) {
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                break;
            temp += s.charAt(i);
        }

        return MY_SET.contains(temp.toLowerCase());
    }

}