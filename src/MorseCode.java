import java.util.Scanner;
import java.util.regex.Pattern;

public class MorseCode {

    final static MorseTranslator MT = new MorseTranslator();
    final static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("Choose what translation you would like to do:\n" +
                "1.Morse Code to english, 2.English to Morse Code");

        String s1 = scan.nextLine();

        int s = 0;
        try {
            s = Integer.parseInt(s1);
        } catch (NumberFormatException n) {
            System.out.println("Please enter a number!");
        }

        if (s == 1) {
            System.out.println("Enter the morse code:");
            String morse = scan.nextLine();

            Pattern pattern = Pattern.compile("^[\\s.-]*$");
            if (!pattern.matcher(morse).find()) {
                throw new Exception("only morse code characters are allowed!");
            }

            String english = null;
            try {
                english = MT.morseToEnglish(morse);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("The Code: " + morse);
            System.out.println("Translation: " + english);
        } else if (s == 2) {
            System.out.println("Enter a word or a sentence:");
            String sentence = scan.nextLine();

            Pattern pattern = Pattern.compile("^[\\sa-zA-Z0-9]*$");
            if (!pattern.matcher(sentence).find()) {
                throw new Exception("only characters, numbers and spaces are allowed!");
            }

            String morse = null;
            try {
                morse = MT.EnglishToMorse(sentence);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Sentence/Word: " + sentence);
            System.out.println("Translation to Morse: " + morse);
        }
    }
}
