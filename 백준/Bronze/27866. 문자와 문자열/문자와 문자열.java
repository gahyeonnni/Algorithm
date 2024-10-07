import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.next();
		int n = scanner.nextInt();
		char a = text.charAt(n-1);
		System.out.println(a);
		}
	}