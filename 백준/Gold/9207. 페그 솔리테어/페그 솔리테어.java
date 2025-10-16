import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static StringTokenizer st;
    static Character [][] array;
    static int a, b;
    static int [] dx = {1, -1, 0, 0};
    static int [] dy = {0, 0, 1, -1};
    static void dfs(Character [][] array, int move, int pinCount) {
        boolean moved = false;

        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 9; y++) {
                if (array[x][y] == 'o') {
                    for (int i = 0; i < 4; i++) {
                        int sx = x + dx[i];
                        int sy = y + dy[i];
                        int tx = x + 2 * dx[i];
                        int ty = y + 2 * dy[i];
                        if (sx >= 0 && sy >= 0 && tx >= 0 && ty >= 0 && sx < 5 && sy < 9 && tx < 5 && ty < 9) {
                            if (array[sx][sy] == 'o' && array[tx][ty] == '.') {
                                array[x][y] = '.';
                                array[sx][sy] = '.';
                                array[tx][ty] = 'o';

                                dfs(array, move + 1, pinCount - 1);
                                moved = true;

                                array[x][y] = 'o';
                                array[sx][sy] = 'o';
                                array[tx][ty] = '.';
                            }
                        }
                    }
                }
            }
        }
        
        if (!moved) {
            if (pinCount < a) {
                a = pinCount;
                b = move;
            } 
            else if (pinCount == a && move < b) {
                b = move;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int t = 0; t < n; t++) {
            array = new Character[5][9];
            for (int i = 0; i < 5; i++) {
                String s = br.readLine();
                for (int j = 0; j < 9; j++) {
                    array[i][j] = s.charAt(j);
                }
            }
            if (t < n - 1)
                br.readLine();

            int p = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 9; j++) {
                    if (array[i][j] == 'o')
                        p++;
                }
            }
            a = p;
            b = 0;
            dfs(array, 0, p);
            System.out.println(a + " " + b);
        }
    }
}