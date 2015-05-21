import inputAnalysis.TextInterpreter;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        TextInterpreter ti = new TextInterpreter();

        ti.analyze(input);
    }
}
