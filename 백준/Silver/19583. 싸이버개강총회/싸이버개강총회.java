import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String start, end, que;
    static Set <String> s = new HashSet<>();
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        start = st.nextToken();
        end = st.nextToken();
        que = st.nextToken();
        String input;
        while ((input = br.readLine()) != null) {
            String [] str = input.split(" ");
            if (str[0].compareTo(start) <= 0)
                s.add(str[1]);
            else if (str[0].compareTo(end) >= 0 && str[0].compareTo(que) <= 0){
                if (s.contains(str[1])){
                    answer++;
                    s.remove(str[1]);
                }
            }
        }
        System.out.println(answer);
    }
}
