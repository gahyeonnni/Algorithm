import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		String[] parts = s.split("-");
		
		int sum = 0;
		
		for (String addPart : parts[0].split("\\+")) {
			sum += Integer.parseInt(addPart);
		}
		
		for (int i = 1; i < parts.length; i++) {
			int sum2 = 0;
			for (String a : parts[i].split("\\+")) {
				sum2 +=  Integer.parseInt(a);
			}
			sum -= sum2;
		}
		System.out.println(sum);
	}
}