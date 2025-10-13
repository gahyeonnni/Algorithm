import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static StringTokenizer st;
    static Character [][] array;
    static int answer = 0;
    static String makeString(String x) {
        if (x.length() <= 1)
            return "";
        return x.substring(1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new Character[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                array[i][j] = s.charAt(j);
            }
        }
        List <String> list = new LinkedList<>();
        boolean first = false;
        for (int j = 0; j < m; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(array[i][j]);
            }
            String x = sb.toString();
            if (list.contains(x)) {
                first = true;
                break;
            }
            list.add(x);
        }
        if (first) {
            System.out.println(0);
            return;
        }
        boolean check = false;
        while (!check) {
            HashSet<String> newset = new HashSet<>();
            List <String> newlist = new LinkedList<>();
            for (int i = 0; i < list.size(); i++) {
                String x = makeString(list.get(i));
                if (x.length() == 0) {
                    check = true;
                    break;
                }
                if (!newset.add(x)) {
                    check = true;
                    break;
                }
                newlist.add(x);
            }
            list = newlist;
            answer++;
        }
        System.out.println(answer - 1);
    }
}