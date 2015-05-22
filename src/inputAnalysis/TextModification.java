package inputAnalysis;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class TextModification {
    public TextModification(){}

    public static String tokenize(String s) {

        // Tokenizing the string
        StringTokenizer tokenizer = new StringTokenizer(s, " \t\n\r\f,.:;?![]'()/");

        // Printing the tokenized string
        String temp = "";
        while (tokenizer.hasMoreTokens()) {
            temp += " " + tokenizer.nextToken();
        }

        return temp;
    }

    public static String posTag(String s) {
        // Initialize the tagger
        MaxentTagger tagger = new MaxentTagger("Resources/taggers/english-bidirectional-distsim.tagger");

        // Return the tagged string
        return tagger.tagString(s);

    }

    public ArrayList<String> getWordTypes(String st) {
        boolean active = false;
        ArrayList<String> ret = new ArrayList<String>();
        String temp = "";

        String s = posTag(tokenize(st));


        for (int i = 0; i < s.length(); i++) {
            if (active) {
                if (s.charAt(i) == ' ') {
                    active = false;
                    ret.add(temp);
                    temp = "";
                    continue;
                }
                temp += s.charAt(i);
            } else if (s.charAt(i) == '_') {
                active = true;
            }
        }
        ret.add(temp);
        ret.remove(ret.size()-1);

        return ret;
    }

    public ArrayList<String> getWords(String st) {
        ArrayList<String> ret = new ArrayList<String>();
        String temp = "";

        String s = tokenize(st);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                ret.add(temp);
                temp = "";
                continue;
            }
            temp += s.charAt(i);
        }
        ret.add(temp);
        ret.remove(0);

        return ret;
    }
}
