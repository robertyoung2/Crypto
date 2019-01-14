import javax.sound.midi.SysexMessage;
import java.util.*;

public class Crypto {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

            System.out.println("Starting encryption program....");

            // take in a string to be encrypted
            System.out.print("Please enter the text to be encrypted: ");
            String input_string = input.nextLine();

            // take in shift value
            System.out.print("Please enter the shift value for the caesar cypher: ");
            int shift = input.nextInt();

            // take in group value
            System.out.print("Please enter the group value for the grouped cypher: ");
            int group = input.nextInt();
            String encrypted = (encryptString(input_string, shift, group));
            System.out.println(encrypted);

            // decryption of string check
            System.out.println(decryptString(encrypted,shift));
    }
    // Method to remove all spaces, punctuation and to capitalise the resulting string
    public static String normaliseText(String s) {

        // remove all spaces and punctuation
        s = s.replaceAll("\\s|[^a-zA-Z0-9]","");

        // make all upper case
        String normalisedText = s.toUpperCase();

        // return the result
        return normalisedText;
    }

    // Method to obify by adding "OB" in front of any vowel in the string
    public static String obify(String s) {

        String obifiedText = s.replaceAll("(A|E|I|O|U|Y)", "OB$1");
        return obifiedText;
    }

    // Method to cypher the text using the caesar technique
    public static String caesarify(String s, int key) {

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shifted_alphabet = shiftAlphabet(key);
        String caesarifiedText = "";

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            int index_alpha = alphabet.indexOf(String.valueOf(letter));
            caesarifiedText += shifted_alphabet.charAt(index_alpha);
        }
        return caesarifiedText;
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

    // Group cypher string into equal length blocks
    public static String groupify(String all, int letters_p_g) {

        while (all.length() % letters_p_g != 0) {
            all += 'x';
        }
        String groupifiedText = "";

        for (int i=0; i < all.length(); i++) {
            groupifiedText += all.charAt(i);
            if ((groupifiedText.substring(0,i+1)).length() % letters_p_g == 0 && i >=1) {
                groupifiedText += ' ';
            }
        }
        return groupifiedText;
    }

    // encrypt a given string
    public static String encryptString(String input_string, int shift, int group_size) {

        // Call normalizeText on the input string
        String normalisedText = normaliseText(input_string);

        // Call obify to obfuscate the normalized text
        String obifiedText = obify(normalisedText);

        // Call caesarify to encrypt the obfuscated text
        String caesarifiedText = caesarify(obifiedText, shift);

        // Call groupify to break the cypher text into groups of size letters
        String groupifiedText = groupify(caesarifiedText, group_size);

        // Return the result
        return (groupifiedText);
    }

    // ungroup letters by removing whitespace and 'x'
    public static String ungroupify(String all) {
        all = all.replaceAll(" |[x]", "");
        return all;
    }

    // de-obify by removing "OB"
    public static String deobify(String decaesered) {
        String deobified = "";
        for (int i = 0; i < decaesered.length(); i++){
            if (decaesered.charAt(i) == 'O' && decaesered.charAt(i+1) == 'B') {
                i++;
            } else {
                deobified += decaesered.charAt(i);
            }
        }
        return deobified;
    }

    // decrypt a given string
    public static String decryptString(String input_string, int shift) {
        input_string = ungroupify(input_string);
        input_string = caesarify(input_string, -(shift));
        input_string = deobify(input_string);
        return (input_string);
    }

}
