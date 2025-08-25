import java.util.*;
import java.io.*;

public class Main {
    static int a;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = Integer.parseInt(br.readLine());
        String [] s = new String [a];
        for (int i = 0; i < a; i++) {
            s[i] = br.readLine();
        }
        Arrays.sort(s);
        answer = 1;
        for (int i = 0; i < a - 1; i++)  {
            if (!s[i+1].startsWith(s[i]))
                answer++;
        }
        System.out.println(answer);
    }
}
