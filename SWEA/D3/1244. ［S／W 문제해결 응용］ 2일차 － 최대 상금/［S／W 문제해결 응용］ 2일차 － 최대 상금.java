import java.io.*;
import java.util.*;

public class Solution {  
    static List<Integer> list;
    static int max; 
    static boolean found;
    static HashSet<String>[] visited;

    static void backTracking(int count, int b, int[] array) { 
        if (found) return;
        
        StringBuilder sb = new StringBuilder();
        for (int x : array) 
        	sb.append(x);
        String state = sb.toString();

        if (visited[count].contains(state)) 
        	return;
        
        visited[count].add(state);

        if (count == b) {
            int x = 0; 
            for (int p : array)
            	x = x * 10 + p;

            list.add(x);
            if (x == max) found = true;
            return;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) { 
                int tmp = array[i]; 
                array[i] = array[j];
                array[j] = tmp;   

                backTracking(count + 1, b, array);

                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;

                if (found) 
                	return;
            }
        }
    }

    public static void main(String[] args) throws IOException {  
        int index = 1; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) { 
            StringTokenizer st = new StringTokenizer(br.readLine()); 
            int a = Integer.parseInt(st.nextToken()); 
            int b = Integer.parseInt(st.nextToken()); 

            list = new ArrayList<>();  
            max = 0; 
            found = false;

            String s = Integer.toString(a);
            int[] arr = new int[s.length()];
            for (int j = 0; j < s.length(); j++) {
                arr[j] = s.charAt(j) - '0';  
            }

            int[] newArr = Arrays.copyOf(arr, arr.length);
            Arrays.sort(newArr);
            for (int m = newArr.length - 1; m >= 0; m--)
                max = max * 10 + newArr[m];

            visited = new HashSet[b + 1];
            for (int k = 0; k <= b; k++)
                visited[k] = new HashSet<>();

            backTracking(0, b, arr); 

            Collections.sort(list); 
            int ans = list.get(list.size() - 1);
            System.out.println("#" + index + " " + ans);
            index++;
        }
    }
}
