package Commons;

public class StringUtils {
    public static String center(String s, int size) {
        return center(s, size, ' ');
    }

    public static String center(String s, int size, char pad) {
        if (s == null || size <= s.length())
            return s;

        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < (size - s.length()) / 2; i++) {
            sb.append(pad);
        }
        sb.append(s);
        while (sb.length() < size) {
            sb.append(pad);
        }
        return sb.toString();
    }

    public static String GetReversedString(String s) {
        if (s.length() == 1) {
            return s;
        }

        else {
            return Character.toString(s.charAt(s.length() - 1)) + GetReversedString(s.substring(0, s.length() - 1));
        }
    }

    public static boolean CheckAlphabet(char ch) {
        if (Character.toLowerCase(ch) >= 'a' && Character.toLowerCase(ch) <= 'z') {
            return true;
        }
        else {
            return false;
        }
    }

    public static int GetNumberOfVowels(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (CheckAlphabet(ch)) {
                ch = Character.toLowerCase(ch); 

                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    count++;
                }
            }
        }


        return count;
    } 

    public static int GetNumberOfConsonants(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (CheckAlphabet(ch)) {
                ch = Character.toLowerCase(ch); 

                if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                    count++;
                }
            }
        }
        return count;
    } 
    public static int GetNumOfUpperLettersRecursive(String str) {
        char ch = str.charAt(0);
        int count = ch >= 'A' && ch <= 'Z' ? 1 : 0;

        if(str.length() == 1) {
            return count;
        }
        else {
            return count + GetNumOfUpperLettersRecursive(str.substring(1));
        }
    }

    public static int GetNumOfUppercaseLetters(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (CheckAlphabet(ch)) {
                if (ch >= 'A' && ch <= 'Z') {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
