import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] temp = br.readLine().split(" ");
        int a = Integer.parseInt(temp[0]);
        int b = Integer.parseInt(temp[1]);
        int [][] block = new int [a][b];

        String [] temp2 = br.readLine().split(" ");
        int [] water = new int [temp2.length];
        for (int i = 0; i < temp2.length; i++){
            water[i] = Integer.parseInt(temp2[i]);
        }

        int answer = 0;
        int[] leftMax = new int[b];
        int[] rightMax = new int[b];

        leftMax[0] = water[0];
        for (int i = 1; i < b; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], water[i]);
        }

        rightMax[b - 1] = water[b - 1];
        for (int i = b - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], water[i]);
        }

        for (int i = 0; i < b; i++) {
            int max = Math.min(leftMax[i], rightMax[i]);
            answer += Math.max(0, max - water[i]);
        }

        System.out.println(answer);
    }
}