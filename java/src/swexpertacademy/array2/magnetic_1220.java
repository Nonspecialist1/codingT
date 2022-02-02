package swexpertacademy.array2;

import java.io.IOException;
import java.util.Scanner;

public class magnetic_1220 {
    static int[][] arr = new int[100][100];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        for(int T=1; T<=10; T++){
            sc.nextInt();

            for(int i=0; i<100; i++){
                for(int j=0; j<100; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            int ans = 0;

            for(int row=0; row<100; row++) {
                int flag = 0;
                for(int col=0; col<100; col++){
                    if(arr[col][row] == 1) flag = 1;
                    else if(arr[col][row] == 2 && flag == 1){
                        ans++; flag = 0;
                    }
                }
            }

            System.out.printf("#%d %d\n", T, ans);
        }
        sc.close();
    }

}
