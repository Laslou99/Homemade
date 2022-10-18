package Calculator2;

import java.util.TreeMap;

public class Converter {
    TreeMap<Character, Integer> romeKeyMap = new TreeMap<>();
    TreeMap<Integer, String> arabianKeyMap = new TreeMap<>();

    public Converter(){
        romeKeyMap.put('I', 1);
        romeKeyMap.put('V', 5);
        romeKeyMap.put('X', 10);
        romeKeyMap.put('L', 50);
        romeKeyMap.put('C', 100);
        romeKeyMap.put('D', 500);
        romeKeyMap.put('M', 1000);

        arabianKeyMap.put(1000, "M");
        arabianKeyMap.put(900, "CM");
        arabianKeyMap.put(500, "D");
        arabianKeyMap.put(400, "CD");
        arabianKeyMap.put(100, "C");
        arabianKeyMap.put(90, "XC");
        arabianKeyMap.put(50, "L");
        arabianKeyMap.put(40, "XL");
        arabianKeyMap.put(10, "X");
        arabianKeyMap.put(9, "IX");
        arabianKeyMap.put(5, "V");
        arabianKeyMap.put(4, "IV");
        arabianKeyMap.put(1, "I");

    }

    public boolean isRome(String number){
        return romeKeyMap.containsKey(number.charAt(0));
    }

    public String intToRome(int number) {
        String roman = "";
        int arabianKey;
        do {
            arabianKey = arabianKeyMap.floorKey(number);
            roman += arabianKeyMap.get(arabianKey);
            number -= arabianKey;
        } while (number != 0);
        return roman;
    }

    public int romanToInt(String s) {
        int res = s.length() - 1;
        char[] arr = s.toCharArray();
        int arabian;
        int end = romeKeyMap.get(arr[res]);
        for (int i = res - 1; i >= 0; i--) {
            arabian = romeKeyMap.get(arr[i]);

            if (arabian < romeKeyMap.get(arr[i + 1])) {
                end -= arabian;
            } else {
                end += arabian;
            }


        }
        return end;

    }
}