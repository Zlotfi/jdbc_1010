package utility;

public class Validation {

    public static boolean isValidPassword(String password){
        if (password.length() < 8)
            return false;
        char[] passwordArray = password.toCharArray();
        char[] signArray = new char[]{'!','@','#','%','^','&'};
        int space = 0, lowerCase = 0, upperCase = 0, sign = 0, digit = 0;
        for (int i = 0; i < passwordArray.length; i++) {
            char c = passwordArray[i];
            if (Character.isSpaceChar(c))
                space++;
            if (Character.isLowerCase(c))
                lowerCase++;
            if (Character.isUpperCase(c))
                upperCase++;
            if (Character.isDigit(c))
                digit++;
            for (int j = 0; j < signArray.length; j++) {
                char value = signArray[j];
                if (c == value)
                    sign++;
            }
        }
        if (space > 0 && lowerCase > 0 && upperCase > 0 && sign > 0 && digit > 0)
            return true;
        else
            return false;
    }
}
