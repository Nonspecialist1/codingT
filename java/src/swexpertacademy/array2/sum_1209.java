package swexpertacademy.array2;

import java.io.IOException;
import java.util.Scanner;

public class sum_1209 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        for(int T=1; T<=10; T++){
            int caseNum = sc.nextInt();
            int[][] arr = new int[100][100];
            int max = 0;
            int rightMax = 0;
            int leftMax = 0;
            int val = 99;

            for(int i=0; i<100; i++){
                int rowMax = 0;
                for(int j=0; j<100; j++){
                    arr[i][j] = sc.nextInt();
                    rowMax += arr[i][j];
                }
                rightMax += arr[i][i];
                leftMax += arr[i][val--];
                if(rowMax > max){
                    max = rowMax;
                }
            }
            for(int i=0; i<100; i++) {
                int columnMax = 0;
                for (int j = 0; j < 100; j++) {
                    columnMax += arr[j][i];
                }
                if(columnMax > max){
                    max = columnMax;
                }
            }
            int crossMax = Math.max(rightMax, leftMax);
            if(crossMax > max){
                max = crossMax;
            }
            System.out.printf("#%d %d\n", T, max);
        }
    }
}
