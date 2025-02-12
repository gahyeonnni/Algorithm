import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < a; i++){
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < s.length(); j++){
                if (!stack.isEmpty() && stack.peek() == s.charAt(j))
                    stack.pop();
                else
                    stack.push(s.charAt(j));
            }
            if (stack.size() == 0)
                count++;
        }
        System.out.println(count);
    }
}