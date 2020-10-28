import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final String path = "./src/file.txt";
    static Main m = new Main();
    public static Token[] tokens = {Lexemes.SURNAME, Lexemes.WRONG_WORD, Lexemes.PHONE, Lexemes.NUMBER, Lexemes.PUNCTUATION, Lexemes.EMAIL, Lexemes.WHITE_SPACE};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();
        Pattern pattern = m.makeBigString(tokens);

        while (line != null) {

                m.readLine(line,pattern);
                line = br.readLine();
            }



        }


    public Pattern makeBigString(Token[] t) {
        String str = "";

        for (int i = 0; i < t.length - 1; i++) {

            str += t[i].getPattern().pattern() + "|";

        }
        str += t[t.length-1].getPattern().pattern();
        return Pattern.compile(str);
    }


    public static void readLine(String str,Pattern pattern) {

            Matcher matcher = pattern.matcher(str);

            while (matcher.find()) {
                String findstr = matcher.group();

                for (Token t : tokens) {
                   if (findstr.matches(t.getPattern().pattern())) {
                       System.out.println(findstr + t.getOutput());
                       break;}

                }

        }
    }

}
