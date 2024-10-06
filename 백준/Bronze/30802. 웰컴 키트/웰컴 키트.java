import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int total = scanner.nextInt();
		int [] numbers = new int[6];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = scanner.nextInt();
		}
		int T = scanner.nextInt();
		int P = scanner.nextInt();
		int Tsum = 0;
		for(int j = 0; j < numbers.length; j++) {
			Tsum += numbers[j] / T;
			if (numbers[j] % T != 0)
				Tsum++;
		}
		System.out.println(Tsum);
		int b = total / P;
		int c = total % P;
		System.out.println(b + " " + c);
	}
}