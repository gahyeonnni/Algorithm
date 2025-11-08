import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, 1, 0, -1};
    static void printall(int [][] array) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void findNumToArray(int [][] array, int findnum) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == findnum){
                    System.out.println((i + 1) + " " + (j + 1));
                    return;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        int findnum = Integer.parseInt(br.readLine());
        int [][] array = new int[n][n];
        int x = n / 2;
        int y = n / 2;
        int dir = 0;
        int move = 1;
        int count = 0;
        int num = 1;

        array[x][y] = num;

        while (num < n * n) {
            for (int k = 0; k < 2; k++) {
                for (int i = 0; i < move; i++) {
                    if (num == n * n)
                        break;
                    x += dx[dir];
                    y += dy[dir];
                    array[x][y] = ++num;
                }
                dir = (dir + 1) % 4;
            }
            move++;
        }
        printall(array);
        findNumToArray(array, findnum);
    }
}
