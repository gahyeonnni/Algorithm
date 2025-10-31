import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        int [] index = new int [26];
        for (int i = 0; i < t.length(); i++)
            index[t.charAt(i) - 'a'] = i + 1;

        int[] board = new int[t.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            int cur = index[s.charAt(i) - 'a'];
            if (cur == 0)
                continue;
            if (cur == 1)
                board[cur]++;
            else if (board[cur - 1] > 0) {
                board[cur - 1]--;
                board[cur]++;
            }
        }
        System.out.println(board[t.length()]);
    }
}
