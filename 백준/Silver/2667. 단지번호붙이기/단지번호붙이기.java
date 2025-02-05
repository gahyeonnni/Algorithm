import java.io.*;
import java.util.*;

public class Main {
	static int [][] num;
	static boolean [][] num2;
	static int[] dx = { -1, 1, 0, 0 }; 
	static int[] dy = { 0, 0, -1, 1 };
	static int n;
    static List<Integer> count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		n = a;  // n을 a로 초기화
		num = new int[a][a];
		num2 = new boolean[a][a];
		count = new ArrayList<>();

		for (int i = 0; i < a; i++) {
			String s = br.readLine();
			for(int j = 0; j < a; j++) {
				num[i][j] = s.charAt(j) - '0';
			}
		}

		for (int i = 0; i < a; i++) {
			for(int j = 0; j < a; j++) {
				if (num[i][j] == 1 && !num2[i][j]) {
					int houseCount = bfs(i, j); 
                    count.add(houseCount); 
				}
			}
		}
		
		// 결과 출력
		System.out.println(count.size());
        Collections.sort(count);
        for (int c : count) {
            System.out.println(c);
        }
	}

	private static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
	    queue.add(new int[] { x, y });
	    num2[x][y] = true;
	    int houseCount = 1;

	    while (!queue.isEmpty()) {
	        int[] current = queue.poll();
	        int cx = current[0];
	        int cy = current[1];

	        for (int i = 0; i < 4; i++) {
	            int nx = cx + dx[i];
	            int ny = cy + dy[i];

	            if (nx >= 0 && nx < n && ny >= 0 && ny < n && num[nx][ny] == 1 && !num2[nx][ny]) {
	                queue.add(new int[] { nx, ny });
	                num2[nx][ny] = true;
	                houseCount++; 
	            }
	        }
	    }
	    return houseCount;
	}
}
