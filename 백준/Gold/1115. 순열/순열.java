import java.util.*;
import java.io.*;

public class Main {
    static int answer = Integer.MAX_VALUE;
    static int n;
    static int[] arrayP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arrayP = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrayP[i] = Integer.parseInt(st.nextToken());
        }
        boolean [] check = new boolean [n];
        int a = 0;

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                a++;
                int x = i;
                while (!check[x]) {
                    check[x] = true;
                    x = arrayP[x];
                }
            }
        }
        answer = (a == 1 ? 0 : a);
        System.out.println(answer);
    }
}
