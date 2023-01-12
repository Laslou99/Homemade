public class IsRoman {

    static boolean isRoman(String romanNumber) {
        RomanNumb[] romanNumbers = RomanNumb.values();
        for (int i = 0; i < romanNumbers.length; i++) {
            if (romanNumber.equals(String.valueOf(romanNumbers[i]))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isArabic(String number) {
        try {
            Integer.valueOf(number);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}