import java.io.*;
import java.util.*;

public class Main {;
    private static List<Integer>[] arr;
    private static boolean [] visited;
    private static int[] distance;

    public static int BFS(int a){
        visited = new boolean [arr.length];
        distance = new int[arr.length];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(a);
        visited[a] = true;

        while (!queue.isEmpty()){
            int cur = queue.poll();

            for (int n : arr[cur]){
                if (!visited[n]){
                    visited[n] = true;
                    queue.add(n);

                    distance[n] = distance[cur] + 1;
                }
            }
        }

        int w = 0;
        for (int i = 1; i < distance.length; i++) {
            w += distance[i];
        }
        return w;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        int a = Integer.parseInt(in[0]);
        int b = Integer.parseInt(in[1]);

        arr = new LinkedList[a + 1];
        for (int i = 0; i <= a; i++){
            arr[i] = new LinkedList<>();
        }

        for (int i = 0; i < b; i++) {
            String[] input = br.readLine().split(" ");
            int ax = Integer.parseInt(input[0]);
            int by= Integer.parseInt(input[1]);
            arr[ax].add(by);
            arr[by].add(ax);
        }

        int min  = Integer.MAX_VALUE;
        int person = -1;

        for (int i = 1; i <= a; i++) {
            int total = BFS(i);
            if (total < min) {
                min = total;
                person = i;
            }
        }

        System.out.println(person);
    }
}