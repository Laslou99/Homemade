package Calculator2;

import java.util.Scanner;

//Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами: a + b, a - b, a * b, a / b. Данные передаются в одну строку (смотри пример)! Решения, в которых каждое число и арифмитеческая операция передаются с новой строки считаются неверными.
//Калькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) числами.
//Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более. На выходе числа не ограничиваются по величине и могут быть любыми.
//Калькулятор умеет работать только с целыми числами.
//Калькулятор умеет работать только с арабскими или римскими цифрами одновременно, при вводе пользователем строки вроде 3 + II калькулятор должен выбросить исключение и прекратить свою работу.
//При вводе римских чисел, ответ должен быть выведен римскими цифрами, соответственно, при вводе арабских - ответ ожидается арабскими.
//При вводе пользователем неподходящих чисел приложение выбрасывает исключение и завершает свою работу.
//При вводе пользователем строки, не соответствующей одной из вышеописанных арифметических операций, приложение выбрасывает исключение и завершает свою работу.
//Результатом операции деления является целое число, остаток отбрасывается.
//Результатом работы калькулятора с арабскими числами могут быть отрицательные числа и ноль. Результатом работы калькулятора с римскими числами могут быть только положительные числа, если результат работы меньше единицы, выбрасывается исключение

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
            if (exp.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }

        if (actionIndex == -1) {
            System.out.println("throws Exception //т.к. строка не является математической операцией");
            return;
        }

        String[] data = exp.split(regexActions[actionIndex]);
        if (converter.isRome(data[0]) == converter.isRome(data[1])) {
            boolean isRome = converter.isRome(data[0]);
            if (isRome) {
                num1 = converter.romanToInt(data[0]);
                num2 = converter.romanToInt(data[1]);

            } else {
                num1 = Integer.parseInt(data[0]);
                num2 = Integer.parseInt(data[1]);
            }
            switch (actions[actionIndex]) {
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
                    end = num1 * num2;
                    break;
                default:
                    System.out.println("Error!");
            }
            if (isRome) {
                if (end < 1) {
                    System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел");
                } else {
                    System.out.println(converter.intToRome(end));
                }
            } else {
                System.out.println(end);
            }
            } else {
                System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
            }
        }
    }
