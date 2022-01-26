package swexpertacademy.array2;

import java.io.IOException;
import java.util.Scanner;

public class magnetic_1220 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        for(int T=1; T<=10; T++){
            int length = sc.nextInt();
            int[][] arr = new int[length][length];

            for(int i=0; i<100; i++){
                for(int j=0; j<100; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            int ans = 0;
            for(int i=0; i<100; i++) {
                a:for (int j = 0; j < 100; j++) {
                    if(arr[j][i] == 1){
                        for(int k=j+1; k<100; k++){
                            if(arr[k][i] == 2){
                                if(k-1 != j){
                                    arr[j][i] = 0;
                                    arr[k-1][i] = 1;
                                    break;
                                }
                                ans++;
                                continue a;
                            }
                        }
                        arr[j][i] = 0;
                    }
                    else if(arr[j][i] == 2){
                        for(int k=j-1; k>=0; k--){
                            if(arr[k][i] == 1){
                                if(k+1 != j){
                                    arr[j][i] = 0;
                                    arr[k+1][i] = 2;
                                    break;
                                }
                                ans++;
                                continue a;
                            }
                        }
                        arr[j][i] = 0;
                    }
                }
            }
            System.out.printf("#%d %d\n", T, ans/2);
        }
    }
}
