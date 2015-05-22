package inputAnalysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextAnalysis {
    public TextAnalysis() throws IOException {
        loadDictionary();
    }

    /**
     * Methods handling the subject
     */

    public String getSubject(ArrayList<String> tags, ArrayList<String> words) {
        return findNoun(tags, words);
    }

    private String findNoun(ArrayList<String> tags, ArrayList<String> words) {
        String temp = "";

        for (int i = 0; i < words.size(); i++) {
            if (tags.get(i).equals("NN") || tags.get(i).equals("NNS") || tags.get(i).equals("NNP") || tags.get(i).equals("NNPS")) {
                if (!temp.equals("")) {
                    temp += " and ";
                }
                temp += words.get(i);
            }
        }

        return temp;
    }

    /**
     * Methods handling questions
     */

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
     */

    private Map<String, float[]> dictionary;

    public void evaluateSentence(ArrayList<String> l) {
        float[][] values = sentencePosNeg(l);
        float finP = 0f;
        float finN = 0f;
        float ret;

        for(float[] f: values){
            finN+=f[1];
            finP+=f[0];
        }

        ret = finP-finN;

        System.out.print(ret);
    }

    public void printValues(ArrayList<String> l) {
        for (String s : l) {
            System.out.println(s + " | " + getPosAndNeg(s)[0] + " , " + getPosAndNeg(s)[1]);
        }
    }

    public void printSentenceValues(ArrayList<String> l) {
        for (float[] f : sentencePosNeg(l)) {
            System.out.println(f[0] + " , " + f[1]);
        }
    }

    public float[][] sentencePosNeg(ArrayList<String> l) {
        float[][] ret = new float[l.size()][2];
        float[] temp;
        int counter = 0;

        for (int i = 0; i < l.size(); i++) {
            temp = getPosAndNeg(l.get(i));
            if (temp[0] > 0f || temp[1] > 0f) {
                ret[counter] = temp;
                counter++;
            }
        }

        float[][] retF = new float[counter][2];

        System.arraycopy(ret, 0, retF, 0, counter);

        return retF;
    }

    private void loadDictionary() throws IOException {
        dictionary = new HashMap<String, float[]>();

        BufferedReader csv = null;
        try {
            csv = new BufferedReader(new FileReader("src/Resources/test.txt"));

            String line;
            while ((line = csv.readLine()) != null) {
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

    private float[] getPosAndNeg(String string) {
        float[] values = new float[2];

        try {
            values[0] = dictionary.get(string)[0];
            values[1] = dictionary.get(string)[1];
        } catch (Exception e) {
            values[0] = 0;
            values[1] = 0;
        }

        return values;
    }

}
