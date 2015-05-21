package inputAnalysis.textAnalysis;

import java.util.ArrayList;

public class Subject {
    public static String check(ArrayList<String> tags, ArrayList<String> words) {
        return findNoun(tags, words);
    }

    private static String findNoun(ArrayList<String> tags, ArrayList<String> words) {
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
}