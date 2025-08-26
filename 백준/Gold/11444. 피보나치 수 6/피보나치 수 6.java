import java.util.*;
import java.io.*;

public class Main {
    static long a;
    public static void main(String[] args) throws IOException {
        final long MOD = 1_000_000_007L;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = Long.parseLong(br.readLine());

        long r11 = 1, r12 = 0, r21 = 0, r22 = 1;
        long b11 = 1, b12 = 1, b21 = 1, b22 = 0;

        while (a > 0) {
            if ((a & 1) == 1) {
                long t11 = ( (r11 * b11) % MOD + (r12 * b21) % MOD ) % MOD;
                long t12 = ( (r11 * b12) % MOD + (r12 * b22) % MOD ) % MOD;
                long t21 = ( (r21 * b11) % MOD + (r22 * b21) % MOD ) % MOD;
                long t22 = ( (r21 * b12) % MOD + (r22 * b22) % MOD ) % MOD;
                r11 = t11; r12 = t12; r21 = t21; r22 = t22;
            }

            long u11 = ( (b11 * b11) % MOD + (b12 * b21) % MOD ) % MOD;
            long u12 = ( (b11 * b12) % MOD + (b12 * b22) % MOD ) % MOD;
            long u21 = ( (b21 * b11) % MOD + (b22 * b21) % MOD ) % MOD;
            long u22 = ( (b21 * b12) % MOD + (b22 * b22) % MOD ) % MOD;
            b11 = u11; b12 = u12; b21 = u21; b22 = u22;

            a >>= 1;
        }

        System.out.println(r12 % MOD);
    }
}

