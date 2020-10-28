import java.util.regex.Pattern;

public class Lexemes {

    private static String SUR = "[ксенофтваКСЕНОФТВА]";
    private static String NOT_SUR = "[йцугшщзхїґипрлджєячміьбюЙЦУГШЩЗХЇҐИПРЛДЖЄЯЧМІЬБЮ]";
    private static String str = "(" + SUR + "*" + NOT_SUR + "*)*" + NOT_SUR + "+(" + SUR + "*" + NOT_SUR + "*)*";
    //(SUR*NON_SUR*)*NON_SUR+(SUR*NON_SUR*)*

    public static final Token SURNAME = new Token("SURNAME", Pattern.compile("\\s[ксенофтваКСЕНОФТВА]+\\s"), " -- Коректна лексема (складається лише з букв прізвища)");
    public static final Token WRONG_WORD = new Token("WRONG_WORD", Pattern.compile(str), " -- Некоректна лексема (складається не лише з букв прізвища)");

    public static final Token EMAIL = new Token("EMAIL", Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"), " -- Лексема email");
    public static final Token NUMBER = new Token("NUMBER", Pattern.compile("(\\+|\\-)?\\d+(\\.\\d+)?"), " -- Лексема числа");
    public static final Token PUNCTUATION = new Token("PUNCTUATION", Pattern.compile("(\\p{P})+"), " -- Лексема пунктуації");
    public static final Token WHITE_SPACE = new Token("WHITE SPACE", Pattern.compile("\\s+"), " -- Лексема пробілу");
    //"^([a-z0-9_\\.-]+)@([a-z0-9_\\.-]+)\\.([a-z\\.]{2,6})$"
    public static final Token PHONE = new Token("PHONE", Pattern.compile("((\\+38)?\\(?\\d{3}\\)?[-]?(\\d{7}|\\d{3}[-]\\d{2}[-]\\d{2}|\\d{3}-\\d{4}))"), " -- Лексема телефонного номеру");


}
