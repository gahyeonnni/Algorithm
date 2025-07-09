import java.util.*;
import java.io.*;

import static java.lang.Integer.MAX_VALUE;

public class Main {
    static int answer = MAX_VALUE;
    static int[][] array;
    static class Edge implements Comparable<Edge> {
        int to, weight;
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Edge e){
            return this.weight - e.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] wellCost = new int [n];
        for (int i = 0; i < n; i++) {
            wellCost[i]= Integer.parseInt(br.readLine());
        }
        array = new int [n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(new Edge(i, wellCost[i]));
        }

        int answer = 0;
        int count = 0;

        while (!pq.isEmpty() && count < n) {
            Edge a = pq.poll();
            if (visited[a.to])
                continue;

            visited[a.to] = true;
            answer += a.weight;
            count++;

            for (int i = 0; i < n; i++) {
                if (!visited[i])
                    pq.offer(new Edge(i, array[a.to][i]));
            }
        }
        System.out.println(answer);
    }
}
