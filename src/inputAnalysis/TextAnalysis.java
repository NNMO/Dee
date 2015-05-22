package inputAnalysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by markus on 22/05/15.
 */
public class TextAnalysis {
    public TextAnalysis() throws IOException{
        loadDictionary();
    }

    /**
     * Methods handling the subject
     * */

    public String getSubject(ArrayList<String> tags, ArrayList<String> words) {
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

    /**
     * Methods handling questions
     * */

    private final String[] SET_VALUES = new String[]{"who", "where", "when", "why", "what", "which", "how", "is"};
    private final Set<String> MY_SET = new HashSet<String>(Arrays.asList(SET_VALUES));

    public boolean getIfQuestion(String s) {
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

    /**
     * Methods handling positivity/negativity
     * */

    private static Map<String, float[]> dictionary;

    private static void loadDictionary() throws IOException {

        dictionary = new HashMap<String, float[]>();

        BufferedReader csv = null;
        try {
            csv = new BufferedReader(new FileReader("src/Resources/test.txt"));
            int lineNumber = 0;

            String line;
            while ((line = csv.readLine()) != null) {
                lineNumber++;


                if (!line.trim().startsWith("#")) {

                    String[] data = line.split("\t");

                    float[] scoreArray = {Float.parseFloat(data[1]), Float.parseFloat(data[2])};
                    dictionary.put(data[0], scoreArray);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (csv != null) {
                csv.close();
            }
        }
    }

    private static float[] getPosAndNeg(String string){

        float[] values = {dictionary.get(string)[0], dictionary.get(string)[1]};

        return values;
    }

}
