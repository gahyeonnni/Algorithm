import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static  List<Integer> players;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        players = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            players.add(Integer.parseInt(st.nextToken()));

        long sum = 0;
        int maxTarget = n;

        while (players.size() > 1) {
            int index = players.indexOf(maxTarget);
            if (index == 0)
                sum += Math.abs(players.get(index) - players.get(index + 1));
            else if (index == players.size() - 1)
                sum += Math.abs(players.get(index) - players.get(index - 1));
            else
                sum += Math.min(Math.abs(players.get(index) - players.get(index-1)),Math.abs(players.get(index) - players.get(index+1)));

            players.remove(index);
            maxTarget--;
        }

        System.out.println(sum);
    }
}