import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static StringTokenizer st;
    static int [] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int [n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int[] cur = new int[1000001];
        int answer = 0;
        for (int a : array) {
            if (cur[a] > 0) {
                cur[a]--;
                cur[a-1]++;
            }
            else {
                answer++;
                cur[a-1]++;
            }
        }
        System.out.println(answer);
    }
}

