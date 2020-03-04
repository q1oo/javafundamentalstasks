import java.util.Scanner;

public class SecondTaskTurnOver {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please type any word to turn it over.");
		String str = scanner.nextLine();
		for (int i = str.length() - 1; i >= 0; i--) {
			System.out.print(str.charAt(i));
		}
	}
}