package inputAnalysis;

import java.util.ArrayList;
import java.util.HashMap;

public class TextInterpreter {
    private HashMap<String, String> tags;
    private boolean active = false;

    public void analyze(String s) {
        String temp = TextModification.posTag(TextModification.tokenize(s));
    }

    private ArrayList<String> getWordTypes(String s) {
        ArrayList<String> list = new ArrayList<String>();
        String temp = "";

        for (int i = 0; i < s.length(); i++) {
            if (active) {
                if (s.charAt(i) == ' ') {
                    active = false;
                    list.add(temp);
                    temp = "";
                    continue;
                }
                temp += s.charAt(i);
            } else if (s.charAt(i) == '_') {
                active = true;
            }
        }

        return list;
    }

    private void printResult(String s) {
        System.out.println(s);
    }

    public TextInterpreter() {
        tags = new HashMap<String, String>();

        tags.put("CC", "Conjunction, coordinating");
        tags.put("CD", "Cardinal number");
        tags.put("DT", "Determiner");
        tags.put("EX", "Existential");
        tags.put("FW", "Foreign word");
        tags.put("IN", "Preposition or subordinating conjunction");
        tags.put("JJ", "Adjective");
        tags.put("JJR", "Adjective, comparative");
        tags.put("JJS", "Adejctive, superlative");
        tags.put("LS", "List item marker");
        tags.put("MD", "Modal verb");
        tags.put("NN", "Noun, singular or mass");
        tags.put("NNS", "Noun, plural");
        tags.put("NNP", "Proper noun, singular");
        tags.put("NNPS", "Proper noun, plural");
        tags.put("PDT", "Predeterminer");
        tags.put("POS", "Possessive ending");
        tags.put("PRP", "Possessive pronoun");
        tags.put("RB", "Adverb");
        tags.put("RBR", "Adverb, comparative");
        tags.put("RBS", "Adverb, superlative");
        tags.put("RP", "Particle");
        tags.put("SYM", "Symbol");
        tags.put("TO", "To");
        tags.put("UH", "Interjection");
        tags.put("VB", "Verb, base form");
        tags.put("VBD", "Verb, past tense");
        tags.put("VBG", "Verb, gerund or present participle");
        tags.put("VBN", "Verb, past participle");
        tags.put("VBP", "Verb, non-3rd person singular present");
        tags.put("VBZ", "Verb, 3rd person singular present");
        tags.put("WDT", "Wh-determiner");
        tags.put("WP", "Wh-pronoun");
        tags.put("WRB", "Wh-adverb");
    }
}
