package swexpertacademy.array2;

import java.io.IOException;
import java.util.Scanner;

public class ladder_1210 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        for(int T=1; T<=10; T++){
            int tCase = sc.nextInt();
            int[][] arr = new int[100][100];

            for(int i=0; i<100; i++){
                for(int j=0; j<100; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            int ans = 0;

            System.out.printf("#%d %d\n", tCase, ans);
        }
    }
}
