import java.util.Scanner;

public class FourthTaskSumAndMultiplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number a:");
		int a = scanner.nextInt();
        System.out.println("Enter second number b:");
		int b = scanner.nextInt();
		System.out.println("a + b = " + (a + b));
		System.out.println("a * b = " + (a * b));
	}
}