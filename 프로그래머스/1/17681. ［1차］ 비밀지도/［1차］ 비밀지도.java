import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[][] ans = new String[n][n];

        for (int i = 0; i < n; i++) {
            String a = Integer.toBinaryString(arr1[i]);
            String p = "";
            if (a.length() < n) {
                int num3 = n - a.length();
                while (num3-- > 0)
                    p += "0";
            }
            a = p + a;
            for (int j = 0; j < n; j++) {
                char x = a.charAt(j);
                if (x == '1')
                    ans[i][j] = "#";
                else
                    ans[i][j] = " ";
            }
        }

        for (int i = 0; i < n; i++) {
            String a = Integer.toBinaryString(arr2[i]);
            String p = "";
            if (a.length() < n) {
                int num3 = n - a.length();
                while (num3-- > 0)
                    p += "0";
            }
            a = p + a;
            for (int j = 0; j < n; j++) {
                char x = a.charAt(j);
                if (x == '1')
                    ans[i][j] = "#";
                else {
                    if (!ans[i][j].equals("#"))
                        ans[i][j] = " ";
                }
            }
        }

        for (int i = 0; i < n; i++) {
            answer[i] = ""; 
            for (int j = 0; j < n; j++) {
                answer[i] += ans[i][j]; 
            }
        }

        return answer;
    }
}
