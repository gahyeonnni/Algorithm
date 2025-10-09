import java.util.*;
import java.io.*;

class Node {
    int to, weight;
    Node (int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

class Result {
    int cur, height;
    Result(int cur, int height) {
        this.cur = cur;
        this.height = height;
    }
}

public class Main {
    static int n;
    static List <List <Node>> list;
    static StringTokenizer st;
    
    static Result bfs(int a) {
        Queue <Result> queue = new LinkedList<>();
        boolean [] visited = new boolean [n+1];
        queue.add(new Result(a, 0));
        visited[a] = true;

        Result max = new Result(a, 0);
        while (!queue.isEmpty()) {
            Result now = queue.poll();
            for (Node node : list.get(now.cur)) {
                if (!visited[node.to]) {
                    visited[node.to] = true;
                    int dist = now.height + node.weight;
                    queue.add(new Result(node.to, dist));
                    if (dist > max.height) {
                        max = new Result(node.to, dist);
                    }
                }
            }
        }
        return max;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,c));
            list.get(b).add(new Node(a,c));
        }
        Result half = bfs(1);
        Result total = bfs(half.cur);

        System.out.println(total.height);
    }
}