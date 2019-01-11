import java.util.*;

public class Crypto {
    public static void main(String[] args) {
        // take in a string to be encrypted
        normaliseText("Hello world    ggggg(. , : ; ’ ” ! ? ( ) )");
        obify("FIRE");
        ceasarify("ILIKEZOOS", 1);
    }
    public static String normaliseText(String s) {

        // remove all spaces and punctuation
        s = s.replaceAll("\\s|[^a-zA-Z0-9]","");

        // make all upper case
        s = s.toUpperCase();

        // return the result
        return s;

    }
    public static String obify(String s) {

        s = s.replaceAll("(A|E|I|O|U|Y)", "OB$1");
        return s;

    }
    public static String ceasarify(String s, int key) {

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shifted_alphabet = shiftAlphabet(key);
        String shifted_string = "";

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            int index_alpha = alphabet.indexOf(String.valueOf(letter));
            shifted_string += shifted_alphabet.charAt(index_alpha);
        }

        System.out.println(shifted_string);
        return shifted_string;
    }

    // Method to shift alphabet by given shift value (positive or negative)
    public static String shiftAlphabet(int shift) {

        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }

        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }

        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }


//    public static String groupify() {
//        return groupifiedText;
//    }
//
//    public static String encryptString() {
//
//    }

}
