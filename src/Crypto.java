import java.util.*;

public class Crypto {
    public static void main(String[] args) {
        // take in a string to be encrypted
        normaliseText("Hello world    ggggg(. , : ; ’ ” ! ? ( ) )");
    }
    public static String normaliseText(String s) {

        // remove all spaces and punctuation
        s = s.replaceAll("\\s|[^a-zA-Z0-9]","");

        // make all upper case
        s = s.toUpperCase();

        // return the result
        return s;

    }
//    public static String obify() {
//        return obifiedText;
//
//    }
//    public static String ceasarify() {
//        return ceasarifiedText;
//
//    }
//    public static String groupify() {
//        return groupifiedText;
//    }
//
//    public static String encryptString() {
//
//    }

}
