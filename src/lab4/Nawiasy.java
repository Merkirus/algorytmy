package lab4;

public class Nawiasy {

    public static boolean nawiasyZrownowazone(String wyrazenie) {
        return false;
    }

    public static boolean nawiasOtwierajacy(char c) {
        return (c == '(') || (c == '{') || (c == '[');
    }

    public static boolean nawiasZamykajacy(char c) {
        return (c == ')') || (c == '}') || (c == ']');
    }

}
