import java.util.Scanner;

public class FirstTaskSayHello {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name.");
		String name = scanner.next();
		System.out.println("Hello " + name + "!");
		
	}
}