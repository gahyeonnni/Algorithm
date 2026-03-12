import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        int[] array = new int[N];

        long tempK = K;
        int tempN = N - 1;
        int curNum = N;
        int idx = 0;

        while (tempK >= tempN && tempN >= 0) {

            array[idx++] = curNum--;

            tempK -= tempN;
            tempN--;
        }

        if (tempK > 0) {
            array[N - 1 - (int)tempK] = curNum;
        }

        int temp = 1;

        for (int i = idx; i < N; i++) {
            if (array[i] == 0) {
                array[i] = temp++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int v : array) {
            sb.append(v).append(" ");
        }

        System.out.println(sb);
    }
}