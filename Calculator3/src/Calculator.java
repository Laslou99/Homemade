public class Calculator {
    public static String calc(String input) throws ScannerException {
        String[] splitInputs = input.split(" ");
        if (splitInputs.length > 3) {
            System.out.println("(-_-)" + "\n" +"Опаааааа. Условие внизу!");
            throw new ScannerException(
                    "формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else if (splitInputs.length < 3) {
            System.out.println("(0_0)" + "\n" + "(Тяжелый вздох)... Условие внизу!");
            throw new ScannerException(
                    "строка не является математической операцией");
        }
        RomanNumb[] romanNumbers = RomanNumb.values();
        String operand1 = splitInputs[0];
        String operand2 = splitInputs[2];
        String operator = splitInputs[1];
        String result = null;
        if ((IsRoman.isRoman(operand1) && IsRoman.isArabic(operand2))
                || (IsRoman.isArabic(operand1) && IsRoman.isRoman(operand2))) {
            throw new ScannerException("Серьезно?) Используются одновременно разные системы счисления");
        } else if (IsRoman.isArabic(operand1) & IsRoman.isArabic(operand2)) {
            int number1 = Integer.valueOf(operand1);
            int number2 = Integer.valueOf(operand2);
            if ((number1 <= 10 && number1 >= 0) && (number2 <= 10 && number2 >= 0)) {
                switch (operator) {
                    case "-" -> result = Integer.toString(number1 - number2);
                    case "+" -> result = Integer.toString(number1 + number2);
                    case "/" -> result = Integer.toString(number1 / number2);
                    case "*" -> result = Integer.toString(number1 * number2);
                    default -> result = "Введен не корректный знак";
                }
                return result;
            } else {
                throw new ScannerException("Введено некорректное значение(дб >0 и <10)");
            }

        } else if (IsRoman.isRoman(operand1) && IsRoman.isRoman(operand2)) {
            int number1 = RomanNumb.valueOf(operand1).getArabicNumb();
            int number2 = RomanNumb.valueOf(operand2).getArabicNumb();
            int resultRoman;
            if ((number1 >= 1 && number1 <= 10) || (number2 >= 1 && number2 <= 10)) {
                switch (operator) {
                    case "-":
                        resultRoman = number1 - number2;
                        break;
                    case "+":
                        resultRoman = number1 + number2;
                        break;
                    case "/":
                        resultRoman = number1 / number2;
                        break;
                    case "*":
                        resultRoman = number1 * number2;
                        break;
                    default:
                        resultRoman = 10000;
                }
                if (resultRoman > 0) {
                    return String.valueOf(romanNumbers[resultRoman - 1]);
                }
                throw new ScannerException("в римской системе нет отрицательных чисел");

            }

        } else {
            throw new ScannerException("ERROR!");
        }
        return result;
    }
}