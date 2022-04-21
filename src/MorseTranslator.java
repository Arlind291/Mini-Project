import java.util.HashMap;
import java.util.Map;

public class MorseTranslator {
    public HashMap<Character, String> ENGLISH_MORSE_MAP = new HashMap<Character, String>();
    public HashMap<String, Character> MORSE_ENGLISH_MAP = new HashMap<String, Character>();
    public static String MORSE_CHARACTER_SPACE = " ";
    public static String MORSE_WORD_SPACE = "   ";

    MorseTranslator() {
        this.populateEnglishToMorseMap();
        this.populateMorseToEnglishMap();
    }

    public void populateEnglishToMorseMap() {

        ENGLISH_MORSE_MAP.put('a', ".-");
        ENGLISH_MORSE_MAP.put('b', "-...");
        ENGLISH_MORSE_MAP.put('c',  "-.-");
        ENGLISH_MORSE_MAP.put('d',  "-..");
        ENGLISH_MORSE_MAP.put('e',    ".");
        ENGLISH_MORSE_MAP.put('f', "..-.");
        ENGLISH_MORSE_MAP.put('g',  "--.");
        ENGLISH_MORSE_MAP.put('h', "....");
        ENGLISH_MORSE_MAP.put('i',   "..");
        ENGLISH_MORSE_MAP.put('j', ".---");
        ENGLISH_MORSE_MAP.put('k',   "-.");
        ENGLISH_MORSE_MAP.put('l', ".-..");
        ENGLISH_MORSE_MAP.put('m',   "--");
        ENGLISH_MORSE_MAP.put('n',   "-.");
        ENGLISH_MORSE_MAP.put('o',  "---");
        ENGLISH_MORSE_MAP.put('p', ".--.");
        ENGLISH_MORSE_MAP.put('q', "--.-");
        ENGLISH_MORSE_MAP.put('r', ".-.");
        ENGLISH_MORSE_MAP.put('s',  "...");
        ENGLISH_MORSE_MAP.put('t',   "-");
        ENGLISH_MORSE_MAP.put('u',  "..-");
        ENGLISH_MORSE_MAP.put('v', "...-");
        ENGLISH_MORSE_MAP.put('w',  ".--");
        ENGLISH_MORSE_MAP.put('x', "-..-");
        ENGLISH_MORSE_MAP.put('y', "-.--");
        ENGLISH_MORSE_MAP.put('z', "--..");
        ENGLISH_MORSE_MAP.put('1', ".----");
        ENGLISH_MORSE_MAP.put('2',"..---");
        ENGLISH_MORSE_MAP.put('3', "...--");
        ENGLISH_MORSE_MAP.put('4', "....-");
        ENGLISH_MORSE_MAP.put('5', ".....");
        ENGLISH_MORSE_MAP.put('6', "-....");
        ENGLISH_MORSE_MAP.put('7', "--...");
        ENGLISH_MORSE_MAP.put('8', "---..");
        ENGLISH_MORSE_MAP.put('9', "----.");
        ENGLISH_MORSE_MAP.put('0', "-----");

    }

    private void populateMorseToEnglishMap() {
        for (Map.Entry<Character, String> entry : ENGLISH_MORSE_MAP.entrySet()) {
            MORSE_ENGLISH_MAP.put(entry.getValue(), entry.getKey());
        }
    }

    public String EnglishToMorse(String english) throws Exception {
        String[] words = english.toLowerCase().split(" ");
        StringBuilder morse = new StringBuilder();

        for (String word : words) {
            for (char character : word.toCharArray()) {
                if (!ENGLISH_MORSE_MAP.containsKey(character)) {
                    throw new Exception("Character " + character + " could not be transpiled to morse code");
                }
                morse.append(ENGLISH_MORSE_MAP.get(character));
                morse.append(MORSE_CHARACTER_SPACE);
            }
            morse.append(MORSE_WORD_SPACE);
        }
        return morse.toString();
    }

    public String morseToEnglish(String morse) throws Exception {
        String[] words = morse.split(MORSE_WORD_SPACE);
        StringBuilder english = new StringBuilder();

        for (String word : words) {
            String[] morseCharacters = word.split(MORSE_CHARACTER_SPACE);
            for (String morseCharacter : morseCharacters) {
                if (morseCharacter.equals("")) {
                    continue;
                }
                if (!MORSE_ENGLISH_MAP.containsKey(morseCharacter)) {
                    throw new Exception(morseCharacter + " is not a morse code character");
                }
                english.append(MORSE_ENGLISH_MAP.get(morseCharacter));
            }
            english.append(" ");
        }
        return english.toString();
    }
}