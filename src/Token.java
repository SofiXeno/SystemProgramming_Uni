import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Token {

    private  Pattern pattern;
    private  String name;
    private  String output;



    public Token(String name, Pattern pattern, String output) {
        this.name=name;
        this.pattern=pattern;
        this.output=output;

    }


    public Pattern getPattern() {
        return pattern;
    }

    public String getOutput() {
        return output;
    }

    public String getName() {
        return name;
    }

    public Matcher tokenMatcher(String regex){
       return this.pattern.matcher(regex);
    }
}
