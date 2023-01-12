import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ScannerException {
        Scanner calc = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String input = calc.nextLine();

        System.out.println(Calculator.calc(input));
    }

}