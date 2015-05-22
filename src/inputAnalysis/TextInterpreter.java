package inputAnalysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TextInterpreter {
    private HashMap<String, String> tags;
    private ArrayList<String> wordList;
    private ArrayList<String> tagList;
    private TextAnalysis ta;
    private TextModification tm;

    public void analyze(String s) {
        update(s);

        if (ta.getIfQuestion(s))
            System.out.print("You asked a question ");
        else
            System.out.print("You made a statement ");

        //System.out.println(tagList);
        //System.out.println(wordList);

        System.out.print("about " + ta.getSubject(tagList, wordList));
    }

    private void update(String s) {
        wordList = tm.getWords(s);
        tagList = tm.getWordTypes(s);
    }

    private void printResult(String s) {
        System.out.println(s);
    }

    public TextInterpreter() throws IOException{
        ta = new TextAnalysis();
        tm = new TextModification();

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
