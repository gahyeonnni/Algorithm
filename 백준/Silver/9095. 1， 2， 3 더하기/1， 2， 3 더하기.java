import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] ans = new int [10];
        ans[0] = 1;
        ans[1] = 2;
        ans[2] = 4;
        for (int i = 3;  i < 10; i++){
            ans[i] = ans[i-3] + ans[i-1] + ans[i-2];
        }
        for(int i=0; i< n; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(ans[num - 1]);
        }
    }
}