import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class Calculator {
    public static void main(String[] args) {
        double num1, num2, end;
        char op;

        Scanner real = new Scanner(System.in);

        System.out.println("Select a num1: ");
        num1 = real.nextDouble();

        System.out.println("Select a value(+, -, /, *): ");
        op = real.next().charAt(0);

        System.out.println("Select a num2: ");
        num2 = real.nextDouble();

        switch (op) {
            case '+':
                end = num1 + num2;
                break;
            case '-':
                end = num1 - num2;
                break;
            case '/':
                end = num1 / num2;
                break;
            case '*':
                end = num1 * num2;
                break;
            default:
                System.out.println("ERROR!");
                return;
        }
        System.out.println("Result:\n");
        System.out.print(num1 + " " + op + " " + num2 + " = " + end);
    }
}
