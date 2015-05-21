package inputAnalysis;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

import java.util.StringTokenizer;

/**
 * Created by markus on 21/05/15.
 */
public abstract class TextModification {
    public static String tokenize(String s) {

        // Tokenizing the string
        StringTokenizer tokenizer = new StringTokenizer(s, " \t\n\r\f,.:;?![]'");

        // Printing the tokenized string
        String temp = "";
        while (tokenizer.hasMoreTokens()) {
            temp += " " + tokenizer.nextToken();
        }

        return temp;
    }

    public static String posTag(String s) {
        // Initialize the tagger
        MaxentTagger tagger = new MaxentTagger("taggers/english-bidirectional-distsim.tagger");

        // The tagged string
        String temp = tagger.tagString(s);

        return temp;
    }

}
