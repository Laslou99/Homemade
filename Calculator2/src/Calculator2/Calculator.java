package Calculator2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int num1, num2, end = 0;
        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String exp = scan.nextLine();
        int actionIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if (exp.contains(actions[i])){
                actionIndex = i;
                break;
            }
        }

        if (actionIndex == -1) {
            System.out.println("Некорректное выражение");
            return;
        }

        String[] data = exp.split(regexActions[actionIndex]);
        if (converter.isRome(data[0]) == converter.isRome(data[1])){
            boolean isRome = converter.isRome(data[0]);
            if (isRome) {
                num1 = converter.romanToInt(data[0]);
                num2 = converter.romanToInt(data[1]);

            } else {
                num1 = Integer.parseInt(data[0]);
                num2 = Integer.parseInt(data[1]);
            }
            switch (actions[actionIndex]){
                case "+":
                    end = num1 + num2;
                    break;
                case "-":
                    end = num1 - num2;
                    break;
                case "/":
                    end = num1 / num2;
                    break;
                case "*":
                    end= num1 * num2;
                    break;
                default:
                    System.out.println("Error!");
            }
            if (isRome){
                System.out.println(converter.intToRome(end));
            } else {
                System.out.println(end);
            }
        } else {
            System.out.println("Числа должны быть в одном формате");
        }
    }
}
