import edu.stanford.nlp.tagger.maxent.MaxentTagger;

import java.io.IOException;

/**
 * Created by markus on 20/05/15.
 */
public class Main {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        // Initialize the tagger

        MaxentTagger tagger = new MaxentTagger("taggers/english-bidirectional-distsim.tagger");

        // The sample string

        String sample = "This is a sample text";

        // The tagged string

        String tagged = tagger.tagString(sample);

        // Output the result

        System.out.println(tagged);


    }
}
