import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int [] array = new int [n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        
        int l = 0;
        int r = n - 1;
        int a = array[l];
        int b = array[r];
        int minAbs = Math.abs(a + b);

        while (l < r) {
            int sum = array[l] + array[r];
            if (Math.abs(sum) < minAbs) {
                minAbs = Math.abs(sum);
                a = array[l];
                b = array[r];
            }
            if (sum < 0) {
                l++;
            }
            else {
                r--;
            }
        }
        System.out.println(a + " " + b);
    }
}

