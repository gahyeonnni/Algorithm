import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        char[] dna = br.readLine().toCharArray();

        int dpa = (dna[0]=='A' ? 0 : 1);
        int dpb = (dna[0]=='B' ? 0 : 1);

        for (int i = 1; i < n; i++) {
            char x = dna[i];
            int a, b;

            if (x == 'A') {
                a = Math.min(dpa, dpb + 1);
                b = Math.min(dpb + 1, dpa + 1);
            } else {
                a = Math.min(dpa+ 1, dpb + 1);
                b = Math.min(dpa + 1, dpb);
            }

            dpa = a;
            dpb = b;
        }
        System.out.println(dpa);
    }
}
