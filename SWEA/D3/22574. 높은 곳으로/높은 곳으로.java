import java.io.*;
import java.util.*;

public class Solution {
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int j = 0; j < t; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            answer = 0;

            for (int i = 1; i <= n; i++) {
                answer += i;         
                if (answer == p) {  
                    answer--;        
                }
            }

            System.out.println(answer);
        }
    }
}
