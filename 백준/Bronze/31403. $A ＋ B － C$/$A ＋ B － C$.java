import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		int sum = (a + b -c);
		System.out.println(sum);
		sb.append(a).append(b);
		String s = sb.toString();
		int z = Integer.valueOf(s);
		int sum2 = z - c;
		System.out.println(sum2);
	}
}