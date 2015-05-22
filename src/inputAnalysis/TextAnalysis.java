package inputAnalysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by markus on 22/05/15.
 */
public class TextAnalysis {
    public TextAnalysis() {
    }

    public String checkSubject(ArrayList<String> tags, ArrayList<String> words) {
        return findNoun(tags, words);
    }

    private String findNoun(ArrayList<String> tags, ArrayList<String> words) {
        String temp = "";

        for (int i = 0; i < words.size(); i++) {
            if (tags.get(i).equals("NN") || tags.get(i).equals("NNS") || tags.get(i).equals("NNP") || tags.get(i).equals("NNPS")) {
                temp += words.get(i);
                if (i != words.size() - 1) {
                    temp += " and ";
                }
            }
        }

        return temp;
    }

    private final String[] SET_VALUES = new String[]{"who", "where", "when", "why", "what", "which", "how", "is"};
    private final Set<String> MY_SET = new HashSet<String>(Arrays.asList(SET_VALUES));

    public boolean checkQuestion(String s) {
        return questionMark(s) || startsWith(s);
    }

    private boolean questionMark(String s) {
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) == '?')
                return true;
        }
        return false;
    }

    private boolean startsWith(String s) {
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                break;
            temp += s.charAt(i);
        }

        return MY_SET.contains(temp.toLowerCase());
    }

}
